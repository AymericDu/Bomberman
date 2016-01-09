package players;

import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyKeyboard;

public class Player {
	
	protected SpriteManagerDefaultImpl spriteManager;
	protected int spriteSize;
	protected GameCanvas canvas;
	protected GameData data;
	protected Point direction;
	protected int x;
	protected int y;

	/**
	 * Constructor of player class, allow to create our player
	 * @param x initial p of our player
	 * @param y initial position of our player
	 */
	public Player(int x, int y){
		this.data = data;
		this.canvas = data.getCanvas(); //bomberman on the canvas
		this.spriteSize = data.getConfiguration().getSpriteSize();// size of bomberman
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage("/resources/finalGifIcons/BombermanBas.gif", canvas), this.spriteSize, 3); //give the gif of bomberman
		this.direction = new Point(0, 1); // direction of bomberman
		//this.setLocation(x, y); // start position of bomberman doesn't work .. don't know why

	}
	
	/**
	 * MoveStrategy allow to define the strategy choose by the player 
	 * @return the choosen strategy
	 */
	protected MoveStrategy getMoveStrategy() {
		return new MoveStrategyKeyboard(); 
	}
	
}
