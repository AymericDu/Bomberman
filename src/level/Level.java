package level;

import java.util.Random;

import entity.Box;
import entity.Player;
import entity.Wall;
import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import uid.BombermanUniverseViewPort;

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
		this.player1 = new Player(data,1,1);
		this.player2 = new Player(data, this.data.getConfiguration().getNbColumns() - 1,
				this.data.getConfiguration().getNbRows() - 1);
		this.gameBoard = new BombermanUniverseViewPort(this.data);
		this.universe.addGameEntity(this.player1);
		this.universe.addGameEntity(this.player2);
		this.createWalls();
		this.spawnBox(10);
	}

	/**
	 * Creation of boxes in the game space (random place)
	 */
	protected void spawnBox(int nbOfBoxInGame) {
		Random r = new Random();

		for (int i = 0; i < nbOfBoxInGame; i++) {
			int random_x = 0;
			int random_y = 0;
			
			while ((random_x == 0 || random_y == 0) || (random_x == 1 || random_y == 1)){
				random_x = r.nextInt(this.spriteSize * (this.data.getConfiguration().getNbColumns() - 1));
				random_y = r.nextInt(this.spriteSize * (this.data.getConfiguration().getNbRows() - 1));
			}
				
			Box newBox = new Box(data, random_x, random_y);
			this.universe.addGameEntity(newBox);
		}
	}

	/**
	 * Creation of all the walls
	 */
	protected void createWalls() {
		createLeftAndRightWalls();
		createBottomAndTopWalls();
	}

	/**
	 * Creation of left and right walls
	 */
	protected void createLeftAndRightWalls() {
		for (int i = 0; i < rows; i++) {
			this.universe.addGameEntity(new Wall(data, 0, i*this.spriteSize));
		}
		for (int j = rows;j>0;j--){
			this.universe.addGameEntity(new Wall(data,this.spriteSize * (this.data.getConfiguration().getNbColumns() - 1),this.spriteSize * j));
		}
	}

	/**
	 * Creation of bottom and top walls
	 */
	protected void createBottomAndTopWalls() {
		for (int i = 0; i < columns; i++) {
			this.universe.addGameEntity(new Wall(data,this.spriteSize * i,this.spriteSize * (this.data.getConfiguration().getNbRows()-1)));
		}
		for (int j = columns; j > 0; j--) {
			this.universe.addGameEntity(new Wall(data, this.spriteSize * j, 0));
		}
	}
}
