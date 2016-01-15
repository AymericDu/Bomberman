package level;

import java.util.Random;

import entity.Box;
import entity.Player;
import entity.Wall;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;

public class Level extends GameLevelDefaultImpl {

	protected Player player1, player2;
	protected int rows;
	protected int columns;
	protected int spriteSize;

	public Level(GameData data) {
		super(data);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.spriteSize = this.data.getConfiguration().getSpriteSize();
	}

	/**
	 * Initialize the levels with the players, the walls and the box
	 */
	@Override
	protected void init() {
		this.player1 = new Player(data, 0, 0);
		this.player2 = new Player(data, this.data.getConfiguration().getNbColumns() - 1,
				this.data.getConfiguration().getNbRows() - 1);
		this.gameBoard = new GameUniverseViewPortDefaultImpl(this.data);
		this.universe.addGameEntity(this.player1);
		this.universe.addGameEntity(this.player2);
		this.createWalls();
		// Initialy we put only 10 boxes
		this.spawnBox(10);
	}

	/**
	 * Creation of boxes in the game space (random place)
	 */
	protected void spawnBox(int nbOfBoxInGame) {
		Random r = new Random();

		for (int i = 0; i < r.nextInt(nbOfBoxInGame); i++) {
			int random_x = r.nextInt(this.data.getConfiguration().getNbColumns());
			int random_y = r.nextInt(this.data.getConfiguration().getNbRows());

			Box newBox = new Box(data, random_x, random_y);
			this.universe.addGameEntity(newBox);
		}
	}

	/**
	 * Creation of all the walls
	 */
	protected void createWalls() {
		createLeftAndRightWalls();
		createTopAndBottomWalls();
	}

	/**
	 * Creation of left and right walls
	 */
	protected void createLeftAndRightWalls() {
		for (int i = 0; i < rows; i++) {
			// add left walls
			this.universe.addGameEntity(new Wall(data, 0, i));
			// add right walls
			this.universe.addGameEntity(new Wall(data, 0, columns - i));
		}
	}

	/**
	 * Creation of top and bottom walls
	 */
	protected void createTopAndBottomWalls() {
		for (int i = 0; i < columns; i++) {
			// add top walls
			this.universe.addGameEntity(new Wall(data, rows, rows - i));
			// add bottom walls
			this.universe.addGameEntity(new Wall(data, rows, rows - i));
		}
	}
}
