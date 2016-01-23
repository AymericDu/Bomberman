package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import bomberman.entity.explosion.Bomb;
import bomberman.uid.BombermanMoveStrategy;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;

public class Player extends Entity {

	protected SpriteManagerDefaultImpl spriteManager;
	protected int authorizedBombs;
	protected BombermanMoveStrategy keyboard;
	protected int bombRadius;
	private boolean isAlive;

	/**
	 * Constructor of player class, allow to create our player
	 * 
	 * @param x
	 *            initial p of our player
	 * @param y
	 *            initial position of our player
	 */
	public Player(GameData data, Point position) {
		super(data, position, "/images/BombermanSprite.png");

		this.getDriver().setmoveBlockerChecker(data.getMoveBlockerChecker());

		this.spriteManager = new SpriteManagerDefaultImpl(this.image, data.getConfiguration().getSpriteSize(), 5);
		this.spriteManager.setTypes("down", "right", "up", "left", "died");
		this.spriteManager.setType("down");
		this.spriteManager.reset();

		this.authorizedBombs = 1;
		this.bombRadius = 1;
		this.isAlive = true;
	}
	
	/**
	 * draw allow to draw a Graphics g in the gameEntity
	 */
	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, position);
	}

	/**
	 * getBoundingBox allows to return a rectangle in the GameEntity
	 */
	@Override
	public Rectangle getBoundingBox() {
		int spriteSize = data.getConfiguration().getSpriteSize();
		Rectangle rectangle = new Rectangle(spriteSize, spriteSize);
		rectangle.setLocation((int) this.position.getX() * spriteSize, (int) this.position.getY() * spriteSize);
		return rectangle;
	}

	/**
	 * Do one step of a movement
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		Point direction = this.moveDriver.getSpeedVector(this).getDirection();
		if (direction.equals(new Point(1, 0))) {
			this.spriteManager.setType("right");
		} else if (direction.equals(new Point(-1, 0))) {
			this.spriteManager.setType("left");
		} else if (direction.equals(new Point(0, -1))) {
			this.spriteManager.setType("up");
		} else if (direction.equals(new Point(0, 1))) {
			this.spriteManager.setType("down");
		}
		if (!(direction.equals(new Point(0, 0)))) {
			this.spriteManager.increment();
		}
	}

	/**
	 * Initialize the Keyboard
	 * @param keyboard
	 */
	public void setKeyboard(BombermanMoveStrategy keyboard) {
		this.keyboard = keyboard;
		this.keyboard.setPlayer(this);
		this.keyboard.setSpeed(this.data.getConfiguration().getSpriteSize());
		this.getDriver().setStrategy(keyboard);
		this.data.getCanvas().addKeyListener(keyboard);
	}

	/**
	 * Drop a bomb in the position of the player
	 */
	public void dropBomb() {
		if (this.authorizedBombs > 0) {
			this.authorizedBombs--;
			new Bomb(this.data, this.position, this.bombRadius, this);
		}
	}

	/**
	 * Add a bomb for the player
	 */
	public void increaseAuthorizedBomb() {
		this.authorizedBombs++;
	}


	/**
	 * Increase the bomb radius for the player
	 */
	public void increaseBombRadius() {
		this.bombRadius++;
	}

	/**
	 * This function allows to kill the player.
	 */
	public void killed() {
		this.spriteManager.setType("died");
		this.data.getCanvas().removeKeyListener(this.keyboard);
		this.isAlive = false;
	}
	
	/**
	 * getAuthorizedBomb allows to return the numbers of authorized Bomb
	 * @return the authorized bomb
	 */
	public int getAuthorizedBomb(){
		return this.authorizedBombs;
	}
	
	/**
	 * getBombsRadius return the bomb radius
	 * @return the bomb radius
	 */
	public int getBombsRadius(){
		return this.bombRadius;
	}

	public boolean isAlive() {
		return this.isAlive;
	}
}
