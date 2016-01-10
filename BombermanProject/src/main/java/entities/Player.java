package entities;

import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyKeyboard;

public class Player extends GameMovable implements GameEntity{
	
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
	public Player(GameData data, int x, int y){
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

	/**
	 * return the rectangle which represent the game space
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.spriteSize, this.spriteSize);
		rectangle.setLocation(position.x * this.spriteSize, position.y* this.spriteSize);
		return rectangle;	
		}

	
	/**
	 * add sprite change if our player move
	 **/
	@Override
	public void oneStepMoveAddedBehavior() {
		Point d = this.moveDriver.getSpeedVector(this).getDirection();
		if (!direction.equals(d)) {
			// player go right
			if (d.equals(new Point(1, 0))) {
				this.spriteManager.setType("right");
				direction = d;
			// player go left
			} else if (d.equals(new Point(-1, 0))) {
				this.spriteManager.setType("left");
				direction = d;
			// player go on top
			} else if (d.equals(new Point(0, -1))) {
				this.spriteManager.setType("up");
				direction = d;
			// player go on bottom
			} else if (d.equals(new Point(0, 1))) {
				this.spriteManager.setType("down");
				direction = d;
			}
		}
		// player don't move 
		if (!(d.equals(new Point(0, 0)))) {
			this.spriteManager.increment();
		}
	}		
	
	
}
