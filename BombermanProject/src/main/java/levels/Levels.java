package levels;

import gameframework.game.GameData;
import gameframework.game.GameLevelDefaultImpl;
import players.Player;
import uid.Wall;

public class Levels extends GameLevelDefaultImpl {
	
	protected Player p1,p2;
	protected int rows;
	protected int columns;
	protected int spriteSize;
	
	public Levels(GameData data) {
		super(data);
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.spriteSize = this.data.getConfiguration().getSpriteSize();
	}
	
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}
	
	protected void createWalls(){
		createLeftWalls();
		createRightWalls();
		createTopWalls();
		createBottomWalls();
	}
	
	protected void createLeftWalls(){
		for (int i = 0; i<rows;i++){
			this.universe.addGameEntity(new Wall(data,0,i));
		}
	}
	
	protected void createRightWalls(){
		for (int i = 0; i<rows;i++){
			this.universe.addGameEntity(new Wall(data,0,columns-i));
		}
	}
	
	protected void createTopWalls(){
		for (int i = 0; i<columns;i++){
			this.universe.addGameEntity(new Wall(data,rows,rows-i));
		}
	}
	
	protected void createBottomWalls(){
		for (int i = 0; i<columns;i++){
			this.universe.addGameEntity(new Wall(data,0,rows-i));
		}
		
	}

}
