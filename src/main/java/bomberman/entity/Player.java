package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyKeyboard;

public class Player extends GameMovable implements GameEntity {

	// protected SpriteManagerDefaultImpl spriteManager;
	protected DrawableImage img;
	protected int spriteSize;
	protected GameCanvas canvas;
	protected GameData data;
	protected Point position;
	protected boolean isAlive;
	protected List<Bomb> bombsAvailable = new ArrayList<Bomb>();

	/**
	 * Constructor of player class, allow to create our player
	 * 
	 * @param x
	 *            initial p of our player
	 * @param y
	 *            initial position of our player
	 */
	public Player(GameData data, int x, int y) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.spriteSize = data.getConfiguration().getSpriteSize();
		// this.spriteManager = new SpriteManagerDefaultImpl(new
		// DrawableImage(sprite, canvas), this.spriteSize, 4);
		URL url = Player.class.getResource("/images/level/BombermanTest.png");
		this.img = new DrawableImage(url, this.canvas);
		this.position = new Point(x, y);
		this.isAlive = true;
		this.bombsAvailable.add(new Bomb(this.data, this.getPosition(), 2));
	}

	/**
	 * MoveStrategy allow to define the strategy choose by the player
	 * 
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
		rectangle.setLocation((int) this.position.getX() * this.spriteSize,
				(int) this.position.getY() * this.spriteSize);
		return rectangle;
	}

	/**
	 * drop a bomb in the position of the player
	 */
	public void dropBomb() {
		if (!this.bombsAvailable.isEmpty()) {
			Bomb bombToDrop = this.bombsAvailable.get(0);
			bombToDrop.dropBomb(this.position);
			bombsAvailable.remove(0);
		}
	}

	/**
	 * @return true if the player is alive and false if he's dead
	 */
	public boolean isAlive() {
		return isAlive;
	}
	
	/**
	 * This function allows to change isAlive in false. It allow to kill the player.
	 */
	public void setIsAlive(){
		this.isAlive= false;
	}

	/**
	 * draw the player with the Graphics g, the image and the coordinates of
	 * him.
	 * 
	 * @param g
	 *            : Graphics
	 */
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);
	}

	/**
	 * do one step of a movement
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isMovable() {
		return true;
	}
}
