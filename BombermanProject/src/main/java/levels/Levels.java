package levels;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import players.Player;
import uid.Wall;

public class Levels extends GameLevelDefaultImpl {
	
	protected Player player1,player2;
	protected int rows;
	protected int columns;
	protected int spriteSize;
	
	public Levels(GameData data) {
		super(data);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.spriteSize = this.data.getConfiguration().getSpriteSize();
	}
	
	
	/**
	 * Initialize the levels
	 */
	@Override
	protected void init() {
		this.player1 = new Player(data , 1,1);
		this.createWalls();
	}
	
	
	/**
	 * Creation of all the walls
	 */
	protected void createWalls(){
		createLeftAndRightWalls();
		createTopAndBottomWalls();
	}
	
	/**
	 * Creation of left and right walls
	 */
	protected void createLeftAndRightWalls(){
		for (int i = 0; i<rows;i++){
			//add left walls
			this.universe.addGameEntity(new Wall(data,0,i));
			//add right walls
			this.universe.addGameEntity(new Wall(data,0,columns-i));
		}
	}
	
	/**
	 * Creation of top and bottom walls
	 */
	protected void createTopAndBottomWalls(){
		for (int i = 0; i<columns;i++){
			//add top walls
			this.universe.addGameEntity(new Wall(data,rows,rows-i));
			//add  bottom walls
			this.universe.addGameEntity(new Wall(data,rows,rows-i));
		}
	}
}
