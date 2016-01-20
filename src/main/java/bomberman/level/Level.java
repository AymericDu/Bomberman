package bomberman.level;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
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
	protected List<Point> boardEntities;
	protected List<Point> boardNoEntities;
	
	public Level(GameData data) {
		super(data);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.spriteSize = this.data.getConfiguration().getSpriteSize();
		this.boardEntities = new ArrayList<Point>();
		this.boardNoEntities = new ArrayList<Point>();
	}

	/**
	 * Initialize the levels with the players, the walls and the box
	 */
	@Override
	protected void init() {
		this.player1 = new Player(this.data, new Point(1 * this.spriteSize, 1 * this.spriteSize));
		this.player2 = new Player(this.data,
				new Point((this.data.getConfiguration().getNbColumns() - 2) * this.spriteSize,
				(this.data.getConfiguration().getNbRows() - 2) * this.spriteSize));
		this.gameBoard = new BombermanUniverseViewPort(this.data);
		this.createWalls();
		this.protectAreaAtBeginning();
		this.fillList();
		this.spawnBox(300);
		this.universe.addGameEntity(this.player1);
		this.universe.addGameEntity(this.player2);
	}
	
	/**
	 * We implement this method to make the board clear.
	 * That mean that at some point, we can't put boxs.
	 * For example : at each side where the player spawn because if not, the player wont move.
	 * 				Where the player spawn, we can't put boxs too.
	 */
	protected void protectAreaAtBeginning(){
		//Positions of players.
		this.boardEntities.add(new Point(1 * this.spriteSize, 1 * this.spriteSize));
		this.boardEntities.add(new Point((this.data.getConfiguration().getNbColumns() - 2) * this.spriteSize,
				(this.data.getConfiguration().getNbRows() - 2) * this.spriteSize));
		
		// Sides of player 1.
		this.boardEntities.add(new Point(2*this.spriteSize,this.spriteSize));
		this.boardEntities.add(new Point(this.spriteSize,2*this.spriteSize));
		this.boardEntities.add(new Point(3*this.spriteSize,this.spriteSize));
		this.boardEntities.add(new Point(this.spriteSize,3*this.spriteSize));
		
		//Sides of player 2.
		this.boardEntities.add(new Point(this.spriteSize* (this.data.getConfiguration().getNbColumns() - 3), this.spriteSize * (this.data.getConfiguration().getNbRows() - 2)));
		this.boardEntities.add(new Point(this.spriteSize* (this.data.getConfiguration().getNbColumns() - 2), this.spriteSize * (this.data.getConfiguration().getNbRows() - 3)));
		this.boardEntities.add(new Point(this.spriteSize* (this.data.getConfiguration().getNbColumns() - 4), this.spriteSize * (this.data.getConfiguration().getNbRows() - 2)));
		this.boardEntities.add(new Point(this.spriteSize* (this.data.getConfiguration().getNbColumns() - 2), this.spriteSize * (this.data.getConfiguration().getNbRows() - 4)));
	}
	/**
	 * Get every point on the board and fill the lists.
	 * The boardNoEntities list will contains the points where there are no entities
	 * The boardEntities list will contains the points where there are entities,
	 * at the beginning, there are only the walls
	 */
	protected void fillList(){
		int i = 0;
		int j = 0;
		while(i<this.rows){
			while (j < this.columns){
				Point p = new Point(this.spriteSize * j, this.spriteSize * i);
				this.boardNoEntities.add(p);
				j=j+1;
			}
			j = 0;
			i = i + 1;
			}
		
		for (int k = 0 ; k < this.boardEntities.size(); k++){
			Point p = this.boardEntities.get(k);
			this.boardNoEntities.remove(p);
		}
	}
	
	/**
	 * Creation of boxes in the game space (random place)
	 */
	protected void spawnBox(int nbOfBoxInGame) {
		Random r = new Random();
		int i = 0;
		
		while (i<nbOfBoxInGame){
			int k = r.nextInt(this.boardNoEntities.size());
			Point p = this.boardNoEntities.get(k);
			
			this.universe.addGameEntity(new Box(data,p));
			this.boardNoEntities.remove(p);
			this.boardEntities.add(p);
			
			i++;
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
			Point p = new Point(0, i * this.spriteSize);
			this.universe.addGameEntity(new Wall(data,p));
			this.boardEntities.add(p);
		}
		for (int j = rows; j > 0; j--) {
			Point p = new Point(this.spriteSize * (this.data.getConfiguration().getNbColumns() - 1), this.spriteSize * j);
			this.universe.addGameEntity(new Wall(data,p));
			this.boardEntities.add(p);
		}
	}
	
	/**
	 * Creation of bottom and top walls
	 */
	protected void createBottomAndTopWalls() {
		for (int i = 0; i < columns; i++) {
			Point p = new Point(this.spriteSize * i, this.spriteSize * (this.data.getConfiguration().getNbRows() - 1));
			this.universe.addGameEntity(new Wall(data,p));		
			this.boardEntities.add(p);
		}
		for (int j = columns; j > 0; j--) {
			Point p = new Point(this.spriteSize * j, 0);
			this.universe.addGameEntity(new Wall(data,p));
			this.boardEntities.add(p);
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
				Point p = new Point(this.spriteSize * j, this.spriteSize * i);
				this.universe.addGameEntity(new Wall(data, p));
				this.boardEntities.add(p);
				j = j +2;
			}
			j =0;
			i = i +2;
			}
	}
}
