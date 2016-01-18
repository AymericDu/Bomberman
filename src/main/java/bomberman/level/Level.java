package bomberman.level;

import java.awt.Point;
import java.util.Random;

import bomberman.entity.Box;
import bomberman.entity.Player;
import bomberman.entity.Wall;
import bomberman.uid.BombermanUniverseViewPort;
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
		this.player1 = new Player(this.data, 1 * this.spriteSize, 1 * this.spriteSize);
		this.player2 = new Player(this.data, (this.data.getConfiguration().getNbColumns() - 2) * this.spriteSize,
				(this.data.getConfiguration().getNbRows() - 2) * this.spriteSize);
		this.gameBoard = new BombermanUniverseViewPort(this.data);
		this.createWalls();
		//this.spawnBox(100);
		this.universe.addGameEntity(this.player1);
	//	this.universe.addGameEntity(this.player2);
	}

	/**
	 * Creation of boxes in the game space (random place)
	 */
	protected void spawnBox(int nbOfBoxInGame) {
		Random r = new Random();

		for (int i = 0; i < nbOfBoxInGame; i++) {
			int random_x = 0;
			int random_y = 0;

			while ((random_x == 0 || random_y == 0) || (random_x == 1 || random_y == 1)) {
				random_x = r.nextInt(this.spriteSize * (this.data.getConfiguration().getNbColumns() - 1));
				random_y = r.nextInt(this.spriteSize * (this.data.getConfiguration().getNbRows() - 1));
			}

			Box newBox = new Box(data, new Point(random_x, random_y));
			this.universe.addGameEntity(newBox);
		}
	}
	
	/**
	 * Remove a box
	 * @param b the box that we would remove
	 */
	protected void removeBox(Box b){
		this.universe.removeGameEntity(b);
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
		for (int i = 0; i < rows; i++) {
			this.universe.addGameEntity(new Wall(data, new Point(0, i * this.spriteSize)));
		}
		for (int j = rows; j > 0; j--) {
			this.universe.addGameEntity(new Wall(data, new Point(
					this.spriteSize * (this.data.getConfiguration().getNbColumns() - 1), this.spriteSize * j)));
		}
	}

	/**
	 * Creation of bottom and top walls
	 */
	protected void createBottomAndTopWalls() {
		for (int i = 0; i < columns; i++) {
			this.universe.addGameEntity(new Wall(data,
					new Point(this.spriteSize * i, this.spriteSize * (this.data.getConfiguration().getNbRows() - 1))));
		}
		for (int j = columns; j > 0; j--) {
			this.universe.addGameEntity(new Wall(data, new Point(this.spriteSize * j, 0)));
		}
	}
	
	/**
	 * Creation of on-board walls
	 */
	protected void createWallsOnBoard(){
		int i = 2;
		int j = 2;
		while(i<rows){
			while (j < columns){
				this.universe.addGameEntity(new Wall(data, new Point(this.spriteSize * j, this.spriteSize * i)));
				j = j +2;
			}
			j =0;
			i = i +2;
			}
		
	}
}
