package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyKeyboard;

public class Player extends GameMovable implements GameEntity, KeyListener {

	protected SpriteManagerDefaultImpl spriteManager;
	protected int spriteSize;
	protected GameCanvas canvas;
	protected GameData data;
	protected Point direction;
	protected boolean isAlive;
	protected int authorizedBombs;
	protected MoveStrategyKeyboard keyboard;
	protected URL url;
	
	/**
	 * Constructor of player class, allow to create our player
	 * 
	 * @param x
	 *            initial p of our player
	 * @param y
	 *            initial position of our player
	 */
	public Player(GameData data, Point position) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.spriteSize = data.getConfiguration().getSpriteSize();
		url = Player.class.getResource("/images/level/BombermanSprite.png");
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(url, canvas), this.spriteSize, 5);

		this.isAlive = true;
		this.authorizedBombs = 1;

		this.setPosition(position);
		this.direction = new Point(0, 1);
		this.initSpriteManager();

		keyboard = new MoveStrategyKeyboard(false);
		keyboard.setSpeed(this.data.getConfiguration().getSpriteSize());
		this.getDriver().setStrategy(keyboard);
		this.getDriver().setmoveBlockerChecker(data.getMoveBlockerChecker());

		this.data.getCanvas().addKeyListener(keyboard);
		this.data.getCanvas().addKeyListener(this);
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
	 * getGameData allows to give the GameData of our player
	 */
	public GameData getGameData() {
		return this.data;
	}

	/**
	 * setDirection allows to change the direction of our player
	 * 
	 * @param p
	 *            the new direction
	 */
	public void setDirection(Point p) {
		this.direction = p;
	}

	/**
	 * getDirection return the direction of our player
	 * 
	 * @return the direction
	 */
	public Point getDirection() {
		return this.direction;
	}
	
	/**
	 * getKeyboard return the MoveStrategyKeyboard of our player
	 * @return the MoveStrategyKeyboard
	 */
	public MoveStrategyKeyboard getKeyboard() {
		return this.keyboard;
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
		if (this.authorizedBombs > 0) {
			this.authorizedBombs--;
			this.data.getUniverse().addGameEntity(new Bomb(this.data, this.position, 2));
		}
	}

	/**
	 * add a bomb for the player
	 */
	public void addBomb() {
		this.authorizedBombs++;
	}

	/**
	 * @return true if the player is alive and false if he's dead
	 */
	protected boolean getIsAlive() {
		return isAlive;
	}

	/**
	 * This function allows to change isAlive in false. It allow to kill the
	 * player.
	 */
	protected void kill() {
		// TODO Change img
		this.isAlive = false;
	}

	/**
	 * Initialize the spriteManager with a picture composed by 5 animations
	 */
	public void initSpriteManager() {
		this.spriteManager.setTypes("down", "right", "up", "left", "died");
		this.spriteManager.setType("down");
		this.spriteManager.reset();
	}

	/**
	 * @return the sprite manager
	 */
	public SpriteManagerDefaultImpl getSpriteManager() {
		return this.spriteManager;
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
		this.spriteManager.draw(g, position);
	}

	/**
	 * do one step of a movement
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		Point d = this.moveDriver.getSpeedVector(this).getDirection();
		if (!direction.equals(d)) {
			if (d.equals(new Point(1, 0))) {
				this.spriteManager.setType("right");
				direction = d;
			} else if (d.equals(new Point(-1, 0))) {
				this.spriteManager.setType("left");
				direction = d;
			} else if (d.equals(new Point(0, -1))) {
				this.spriteManager.setType("up");
				direction = d;
			} else if (d.equals(new Point(0, 1))) {
				this.spriteManager.setType("down");
				direction = d;
			}
		}
		if (!(d.equals(new Point(0, 0)))) {
			this.spriteManager.increment();
		}
	}

	@Override
	public boolean isMovable() {
		return true;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	/**
	 * Override keyPressed to know if the player pressed or not space
	 * 
	 * @param event
	 *            the key pressed
	 */
	@Override
	public void keyPressed(KeyEvent event) {
		keyPressed(event.getKeyCode());
	}

	/**
	 * Called by keyPressed, make a hit if the previous hit is finished.
	 * 
	 * @param keyCode
	 *            the keyCode give by keyPressed.
	 */
	public void keyPressed(int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_SPACE:
			this.dropBomb();
			break;
		default:
			;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// nothing to do
	}

}
