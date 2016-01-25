package bomberman.game;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import bomberman.entity.bonus.BombBonus;
import bomberman.entity.bonus.BombRadiusBonus;
import bomberman.entity.bonus.Bonus;
import bomberman.entity.bonus.DeathBonus;
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameLevelDefaultImpl;

public class BombermanLevel extends GameLevelDefaultImpl {

	protected Player player1, player2;
	protected int rows;
	protected int columns;
	protected Set<Point> occupiedPoints;
	protected List<GameEntity> gameEntities;
	protected List<BombermanMoveStrategy> keyboards;
	
	protected final Random random = new Random();

	public static int levelNumber = 0;

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
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.occupiedPoints = new HashSet<Point>();
		this.occupiedPoints.addAll(((BombermanUniverse) this.data.getUniverse()).getOccupiedPoints());
		this.gameEntities = new ArrayList<GameEntity>();
		this.keyboards = new ArrayList<BombermanMoveStrategy>();
	}

	/**
	 * Initialize the levels with the players, the walls and the box
	 */
	@Override
	protected void init() {
		BombermanMoveStrategy keyboard;
		this.gameBoard = new BombermanUniverseViewPort(this.data);
		keyboard = new BombermanMoveStrategy(KeyEvent.VK_Z, KeyEvent.VK_D, KeyEvent.VK_S, KeyEvent.VK_Q,
				KeyEvent.VK_SPACE);
		this.player1 = this.createPlayers(1, 1, keyboard);
		keyboard = new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN, KeyEvent.VK_LEFT,
				KeyEvent.VK_ENTER);
		this.player2 = this.createPlayers(this.columns - 2, this.rows - 2, keyboard);
		this.spawnBox(BombermanLevel.PROBABILITY_BOX);
	}

	/**
	 * createPlayers allows to create a new player
	 * 
	 * @param columnNumber
	 *            the numbers of colums
	 * @param rowNumber
	 *            the numbers of rows
	 * @return a new player
	 */
	protected Player createPlayers(int columnNumber, int rowNumber, BombermanMoveStrategy keyboard) {
		Point position = ConstructorPoint.create(this.data, columnNumber, rowNumber);
		if (this.occupiedPoints.contains(position))
			throw new IllegalStateException();
		Player player = new Player(this.data, position);
		player.setKeyboard(keyboard);
		this.data.getCanvas().addKeyListener(keyboard);
		this.gameEntities.add(player);
		this.keyboards.add(keyboard);
		this.occupiedPoints.add(position);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				this.occupiedPoints.add(ConstructorPoint.create(this.data, columnNumber + i, rowNumber + j));
			}
		}
		return player;
	}



	/**
	 * Creation of boxes in the game space (random place)
	 * 
	 * @param probability
	 *            greater than 0 and less than 100
	 */
	protected void spawnBox(int probability) {
		Point point;
		int randomInt;
		for (int i = 0; i < this.columns; i++) {
			for (int j = 0; j < this.rows; j++) {
				point = ConstructorPoint.create(this.data, i, j);
				if (!this.occupiedPoints.contains(point)) {
					randomInt = this.random.nextInt(100);
					if (randomInt < probability) {
						this.spawnBonus(point, BombermanLevel.PROBABILITY_BONUS);
						this.gameEntities.add(new Box(data, point));
						this.occupiedPoints.add(point);
					}
				}
			}
		}
	}

	/**
	 * Creation of the bonus in the game space (random place)
	 * @param position 
	 * @param probability
	 *  		greater than 0 and less than 100
	 */
	protected void spawnBonus(Point position, int probability) {
		int randomInt = this.random.nextInt(100);
		if (randomInt < probability) {
			randomInt = this.random.nextInt(3);
			Bonus bonus;
			switch (randomInt) {
			case 0:
				bonus = new BombRadiusBonus(this.data, position);
				break;
			case 1:
				bonus = new DeathBonus(this.data, position);
				break;
			default:
				bonus = new BombBonus(this.data, position);
				break;
			}
			this.gameEntities.add(bonus);
		}
	}

	/**
	 * getGameBoard return the GameBoard of our game
	 * 
	 * @return the GameBoard
	 */
	public GameUniverseViewPort getGameBoard() {
		return this.gameBoard;
	}

	/**
	 * getPlayer1 return the player1 of our game
	 * 
	 * @return the player1
	 */
	public Player getPlayer1() {
		return this.player1;
	}

	/**
	 * getPlayer2 return the player2 of our game
	 * 
	 * @return the player2
	 */
	public Player getPlayer2() {
		return this.player2;
	}

	/**
	 * getColumns return the numbers of columns in the game
	 * 
	 * @return the numbers of columns
	 */
	public int getColumns() {
		return this.columns;
	}

	/**
	 * getRows return the numbers of rows in the game
	 * 
	 * @return the numbers of rows
	 */
	public int getRows() {
		return this.rows;
	}

	/**
	 * getGameData return the GameData of our game
	 * 
	 * @return the GameData
	 */
	public GameData getGameData() {
		return this.data;
	}

	/**
	 * end allows to end the level one time and clear the level
	 */
	@Override
	public void end() {
		super.end();
		for (GameEntity gameEntity : this.gameEntities)
			this.data.getUniverse().removeGameEntity(gameEntity);
		for (BombermanMoveStrategy keyboard : this.keyboards)
			this.data.getCanvas().removeKeyListener(keyboard);
		this.gameEntities.clear();
		this.keyboards.clear();
		BombermanLevel.levelNumber++;
	}
}
