package bomberman.game;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.JOptionPane;

import bomberman.entity.bonus.BombBonus;
import bomberman.entity.bonus.BombRadiusBonus;
import bomberman.entity.bonus.DeathBonus;
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import bomberman.entity.separation.Wall;
import bomberman.uid.Bomberman;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;

/**
 * BombermanLevel initializes the game, it creates the map with walls, boxes and bonuses
 */
public class BombermanLevel extends GameLevelDefaultImpl {

	protected Player player1, player2;
	protected Set<Point> occupiedPoints;
	protected boolean displayScore;
	protected boolean isFinished;
	
	protected final Random random = new Random();

	public static MoveBlockerChecker walls = new MoveBlockerCheckerDefaultImpl();

	protected static final int PROBABILITY_BONUS = 20;
	protected static final int PROBABILITY_BOX = 40;

	public BombermanLevel(GameData data) {
		super(data);
		this.occupiedPoints = new HashSet<Point>();
		this.displayScore = true;
		this.isFinished = false;
	}

	/**
	 * Ends the current level and clears the board
	 */
	@Override
	public synchronized void end() {
		if (!this.isFinished) {
			super.end();

			this.isFinished = true;
			this.player1.getTimer().stop();
			this.player2.getTimer().stop();

			if (this.player1.isAlive()) {
				Bomberman.pointsPlayer1++;
				this.player1.removeKeyboard();
			}
			if (this.player2.isAlive()) {
				Bomberman.pointsPlayer2++;
				this.player2.removeKeyboard();
			}

			if (displayScore)
				JOptionPane.showMessageDialog(null,
						"Player1 : " + Bomberman.pointsPlayer1 + "  -  " + Bomberman.pointsPlayer2 + " : Player2",
						"Score", JOptionPane.INFORMATION_MESSAGE);

			this.data.getUniverse().removeAllGameEntities();
			BombermanLevel.walls = new MoveBlockerCheckerDefaultImpl();
		}
	}

	/**
	 * Initializes the level with the players, the walls and the boxes
	 */
	@Override
	protected void init() {
		int rows = this.data.getConfiguration().getNbRows();
		int columns = this.data.getConfiguration().getNbColumns();

		this.gameBoard = new GameUniverseViewPortDefaultImpl(this.data);
		this.gameBoard.setBackgroundImage("/images/Background.png");

		BombermanMoveStrategy keyboard;
		keyboard = new BombermanMoveStrategy(KeyEvent.VK_Z, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_Q,
				KeyEvent.VK_SPACE);
		this.player1 = this.createPlayer(1, 1, keyboard, Player.PINK_PLAYER);
		keyboard = new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
				KeyEvent.VK_ENTER);
		this.player2 = this.createPlayer(columns - 2, rows - 2, keyboard, Player.GREEN_PLAYER);
		
		this.createAllWalls();
		this.spawnBox(BombermanLevel.PROBABILITY_BOX);
	}
	
	/**
	 * creates a point using the position given in parameter and the sprite's size
	 * 
	 * @param data
	 * 				: the game's data
	 * @param columnNumber 
	 * 				: the column representing a coordinate of the position
	 * @param rowNumber
	 * 				: the row representing a coordinate of the position
	 * @return a Point
	 */
	protected Point createPoint(int columnNumber, int rowNumber) {
		int spriteSize = this.data.getConfiguration().getSpriteSize();
		return new Point(spriteSize * columnNumber, spriteSize * rowNumber);
	}

	/**
	 * createPlayer creates a new player at the position in parameter using the movestrategy in parameter
	 * 
	 * @param columnNumber
	 *           	: the column representing a coordinate of the position
	 * @param rowNumber
	 *           	: the row representing a coordinate of the position
	 * @param keyboard
	 * 			  	: the move strategy
	 * @param url 
	 * 				: the player's sprite path
	 * @return a new player
	 */
	protected Player createPlayer(int columnNumber, int rowNumber, BombermanMoveStrategy keyboard,String url) {
		Point position = this.createPoint(columnNumber, rowNumber);
		if (this.occupiedPoints.contains(position))
			throw new IllegalStateException();
		Player player = new Player(this.data, position, url, this);
		player.setKeyboard(keyboard);
		this.occupiedPoints.add(position);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				this.occupiedPoints.add(this.createPoint(columnNumber + i, rowNumber + j));
			}
		}
		return player;
	}

	/**
	 * createWall creates a new Wall in the position give by the parameters
	 * 
	 * @param columnNumber
	 *           	: the column representing a coordinate of the position
	 * @param rowNumber
	 *           	: the row representing a coordinate of the position
	 */
	protected void createWall(int columnNumber, int rowNumber) {
		Point point;
		point = this.createPoint(rowNumber, columnNumber);
		BombermanLevel.walls.addMoveBlocker(new Wall(data, point));
		this.occupiedPoints.add(point);
	}

	/**
	 * Creation of all the walls
	 */
	protected void createAllWalls() {
		this.createWallsOnEdges();
		this.createWallsOnBoard();
	}

	/**
	 * createWallsOnEdges creates the walls on the edges of the board
	 */
	protected void createWallsOnEdges() {
		int rows = this.data.getConfiguration().getNbRows();
		int columns = this.data.getConfiguration().getNbColumns();
		for (int x = 0; x < columns; x++) {
			this.createWall(0, x);
			this.createWall(rows - 1, x);
		}
		for (int y = 1; y < rows - 1; y++) {
			this.createWall(y, 0);
			this.createWall(y, columns - 1);
		}
	}

	/**
	 * Creation of the on-board walls
	 */
	protected void createWallsOnBoard() {
		int rows = this.data.getConfiguration().getNbRows();
		int columns = this.data.getConfiguration().getNbColumns();
		for (int x = 2; x < columns - 2; x = x + 2) {
			for (int y = 2; y < rows - 2; y = y + 2) {
				createWall(y, x);
			}
		}
	}

	/**
	 * Creation of boxes in the game (in random places)
	 * 
	 * @param probability
	 *            : the probability of creating a box on a position (0 < probability < 100)
	 */
	protected void spawnBox(int probability) {
		int rows = this.data.getConfiguration().getNbRows();
		int columns = this.data.getConfiguration().getNbColumns();
		Point point;
		int randomInt;
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				point = this.createPoint(i, j);
				if (!this.occupiedPoints.contains(point)) {
					randomInt = this.random.nextInt(100);
					if (randomInt < probability) {
						this.spawnBonus(point, BombermanLevel.PROBABILITY_BONUS);
						new Box(data, point);
						this.occupiedPoints.add(point);
					}
				}
			}
		}
	}

	/**
	 * This method will have a chance of creating a bonus in the game, at the given position
	 * @param position
	 * 				: the position of the bonus 
	 * @param probability
	 *  			: the probability  of creating a bonus on the position given in parameter (0 < probability < 100)
	 */
	protected void spawnBonus(Point position, int probability) {
		int randomInt = this.random.nextInt(100);
		if (randomInt < probability) {
			randomInt = this.random.nextInt(3);
			switch (randomInt) {
			case 0:
				new BombRadiusBonus(this.data, position);
				break;
			case 1:
				new DeathBonus(this.data, position);
				break;
			default:
				new BombBonus(this.data, position);
				break;
			}
		}
	}
}