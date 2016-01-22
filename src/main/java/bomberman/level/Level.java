package bomberman.level;

import java.awt.Point;
import java.util.HashSet;
import java.util.Random;

import bomberman.entity.Box;
import bomberman.entity.Player;
import bomberman.entity.Wall;
import bomberman.uid.BombermanUniverseViewPort;
import gameframework.drawing.GameUniverseViewPort;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class Level extends GameLevelDefaultImpl {

	protected Player player1, player2;
	protected int rows;
	protected int columns;
	protected HashSet<Point> occupiedPoints;

	public Level(GameData data) {
		super(data);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.occupiedPoints = new HashSet<Point>();
	}

	protected Point createPoint(int columnNumber, int rowNumber) {
		int spriteSize = this.data.getConfiguration().getSpriteSize();
		return new Point(spriteSize * columnNumber, spriteSize * rowNumber);
	}

	/**
	 * Initialize the levels with the players, the walls and the box
	 */
	@Override
	protected void init() {
		this.gameBoard = new BombermanUniverseViewPort(this.data);
		this.player1 = this.createPlayers(1, 1);
		this.player2 = this.createPlayers(this.columns - 2, this.rows - 2);
		this.player1.kill();
		this.createWalls();
		this.spawnBox(40);
	}

	protected Player createPlayers(int columnNumber, int rowNumber) {
		Point position = this.createPoint(columnNumber, rowNumber);
		if (this.occupiedPoints.contains(position))
			throw new IllegalStateException();
		Player player = new Player(this.data, position);
		this.occupiedPoints.add(position);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				this.occupiedPoints.add(this.createPoint(columnNumber + i, rowNumber + j));
			}
		}
		return player;
	}


	/**
	 * Creation of all the walls
	 */
	protected void createWalls() {
		createLeftAndRightWalls();
		createBottomAndTopWalls();
		createWallsOnBoard();
	}

	/**
	 * Creation of left and right walls
	 */
	protected void createLeftAndRightWalls() {
		Point point;
		for (int y = 0; y < this.rows; y++) {
			for (int x = 0; x < this.columns; x = x + this.columns - 1) {
				point = this.createPoint(x, y);
				new Wall(data, point);
				this.occupiedPoints.add(point);
			}
		}
	}

	/**
	 * Creation of bottom and top walls
	 */
	protected void createBottomAndTopWalls() {
		Point point;
		for (int x = 1; x < this.columns - 1; x++) {
			for (int y = 0; y < this.rows; y = y + this.rows - 1) {
				point = this.createPoint(x, y);
				new Wall(data, point);
				this.occupiedPoints.add(point);
			}
		}
	}

	/**
	 * Creation of on-board walls
	 */
	protected void createWallsOnBoard() {
		Point point;
		for (int x = 2; x < columns - 2; x = x + 2) {
			for (int y = 2; y < rows - 2; y = y + 2) {
				point = this.createPoint(x, y);
				new Wall(data, point);
				this.occupiedPoints.add(point);
			}
		}
	}

	/**
	 * Creation of boxes in the game space (random place)
	 * 
	 * @param probality
	 *            greater than 0 and less than 100
	 */
	protected void spawnBox(int probality) {
		Random random = new Random();
		Point point;
		int randomInt;
		for (int i = 0; i < this.columns; i++) {
			for (int j = 0; j < this.rows; j++) {
				point = this.createPoint(i, j);
				if (!this.occupiedPoints.contains(point)) {
					randomInt = random.nextInt(100);
					if (randomInt < probality) {
						new Box(data, point);
						this.occupiedPoints.add(point);
					}
				}
			}
		}
	}
	
	/**
	 * getGameBoard return the GameBoard of our game
	 * @returnthe GameBoard
	 */
	public GameUniverseViewPort getGameBoard(){
		return this.gameBoard;
	}
	
	/**
	 * getPlayer1 return the player1 of our game
	 * @return the player1
	 */
	public Player getPlayer1(){
		return this.player1;
	}
	
	/**
	 * getPlayer2 return the player2 of our game
	 * @return the player2
	 */
	public Player getPlayer2(){
		return this.player2;
	}
	
	/**
	 * getColumns return the numbers of columns in the game
	 * @return the numbers of columns 
	 */
	public int getColumns(){
		return this.columns;
	}
	
	/**
	 * getRows return the numbers of rows in the game
	 * @return the numbers of rows
	 */
	public int getRows(){
		return this.rows;
	}
	
	/**
	 * getGameData return the GameData of our game
	 * @return the GameData
	 */
	public GameData getGameData(){
		return this.data;
	}
}
