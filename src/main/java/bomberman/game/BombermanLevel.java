package bomberman.game;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;

public class BombermanLevel extends GameLevelDefaultImpl {

	protected Player player1, player2;
	protected Set<Point> occupiedPoints;
	protected List<BombermanMoveStrategy> keyboards;
	
	protected final Random random = new Random();

	public static int levelNumber = 0;
	public static MoveBlockerChecker walls = new MoveBlockerCheckerDefaultImpl();

	protected static final int PROBABILITY_BONUS = 20;
	protected static final int PROBABILITY_BOX = 40;

	/**
	 * Constructor of Level class
	 * 
	 * @param data
	 *            a new gameData
	 */
	public BombermanLevel(GameData data) {
		super(data);
		this.occupiedPoints = new HashSet<Point>();
		this.keyboards = new ArrayList<BombermanMoveStrategy>();
	}

	/**
	 * Initialize the levels with the players, the walls and the box
	 */
	@Override
	protected void init() {
		int rows = this.data.getConfiguration().getNbRows();
		int columns = this.data.getConfiguration().getNbColumns();
		BombermanMoveStrategy keyboard;
		this.gameBoard = new BombermanUniverseViewPort(this.data);
		keyboard = new BombermanMoveStrategy(KeyEvent.VK_Z, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_Q,
				KeyEvent.VK_SPACE);
		this.player1 = this.createPlayer(1, 1, keyboard,"/images/BombermanSpritePlayer1.png");
		keyboard = new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
				KeyEvent.VK_ENTER);
		this.player2 = this.createPlayer(columns - 2, rows - 2, keyboard, "/images/BombermanSpritePlayer2.png");
		
		this.createAllWalls();
		this.spawnBox(BombermanLevel.PROBABILITY_BOX);
	}
	
	/**
	 * creates a point using the position given in parameter and the sprite's size
	 * @param data the game's data
	 * @param columnNumber 
	 * @param rowNumber
	 * @return a Point
	 */
	public Point create(int columnNumber, int rowNumber) {
		int spriteSize = this.data.getConfiguration().getSpriteSize();
		return new Point(spriteSize * columnNumber, spriteSize * rowNumber);
	}

	/**
	 * createPlayers allows to create a new player at the position in parameter using the movestrategy in parameter
	 * 
	 * @param columnNumber
	 *            the column representing a coordinate of the position
	 * @param rowNumber
	 *            the row representing a coordinate of the position
	 * @param keyboard
	 * 			  the move strategy
	 * @return a new player
	 */
	protected Player createPlayer(int columnNumber, int rowNumber, BombermanMoveStrategy keyboard,String url) {
		Point position = this.create(columnNumber, rowNumber);
		if (this.occupiedPoints.contains(position))
			throw new IllegalStateException();
		Player player = new Player(this.data, position,url);
		player.setKeyboard(keyboard);
		this.data.getCanvas().addKeyListener(keyboard);
		this.keyboards.add(keyboard);
		this.occupiedPoints.add(position);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				this.occupiedPoints.add(this.create(columnNumber + i, rowNumber + j));
			}
		}
		return player;
	}

	/**
	 * Creation of all the walls
	 */
	public void createAllWalls() {
		this.createWallsOnEdges();
		this.createWallsOnBoard();
	}

	/**
	 * createWall creates a new Wall in the position give by his parameters
	 * 
	 * @param columnNumber
	 * @param rowNumber
	 */
	protected void createWall(int columnNumber, int rowNumber) {
		Point point;
		point = this.create(rowNumber, columnNumber);
		BombermanLevel.walls.addMoveBlocker(new Wall(data, point));
		this.occupiedPoints.add(point);
	}

	/**
	 * createWallsOnEdges creates the walls on the edges of the game
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
	 * Creation of on-board walls
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
	 * Creation of boxes in the game (random place)
	 * 
	 * @param probability
	 *            the probability of creating a box on a position (0 < probability < 100)
	 */
	protected void spawnBox(int probability) {
		int rows = this.data.getConfiguration().getNbRows();
		int columns = this.data.getConfiguration().getNbColumns();
		Point point;
		int randomInt;
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				point = this.create(i, j);
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
	 * Creation of the bonus in the game (random place)
	 * @param position 
	 * @param probability
	 *  		greater than 0 and less than 100
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

	/**
	 * getGameBoard returns the GameBoard of our game
	 * 
	 * @return the GameBoard
	 */
	public GameUniverseViewPort getGameBoard() {
		return this.gameBoard;
	}

	/**
	 * getPlayer1 returns the player1 of our game
	 * 
	 * @return the player1
	 */
	public Player getPlayer1() {
		return this.player1;
	}

	/**
	 * getPlayer2 returns the player2 of our game
	 * 
	 * @return the player2
	 */
	public Player getPlayer2() {
		return this.player2;
	}

	/**
	 * getGameData returns the GameData of our game
	 * 
	 * @return the GameData
	 */
	public GameData getGameData() {
		return this.data;
	}

	/**
	 * ends the current level and clears the board
	 */
	@Override
	public synchronized void end() {
		super.end();
		if (this.player1.isAlive())
			Bomberman.pointsPlayer1++;
		if (this.player2.isAlive())
			Bomberman.pointsPlayer2++;
		JOptionPane.showMessageDialog(null, "Player1 "+ Bomberman.pointsPlayer1 + " - " + Bomberman.pointsPlayer2 + " Player2", "Score", JOptionPane.INFORMATION_MESSAGE);
		// TODO remove all entities
		for (BombermanMoveStrategy keyboard : this.keyboards)
			this.data.getCanvas().removeKeyListener(keyboard);
		this.keyboards.clear();
		BombermanLevel.walls = new MoveBlockerCheckerDefaultImpl();
		BombermanLevel.levelNumber++;
	}

	/**
	 * getColumns returns the number of columns in the game
	 * 
	 * @return the number of columns
	 */
	public int getColumns() {
		return this.data.getConfiguration().getNbColumns();
	}

	/**
	 * getRows returns the number of rows in the game
	 * 
	 * @return the number of rows
	 */
	public int getRows() {
		return this.data.getConfiguration().getNbRows();
	}
}