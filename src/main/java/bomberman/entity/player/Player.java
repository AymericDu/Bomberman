package bomberman.entity.player;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.Timer;

import bomberman.entity.MovableEntity;
import bomberman.entity.explosion.Bomb;
import bomberman.game.BombermanLevel;
import bomberman.game.BombermanMoveStrategy;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;

public class Player extends MovableEntity implements ActionListener {

	protected SpriteManagerDefaultImpl spriteManager;
	protected int authorizedBombs;
	protected BombermanMoveStrategy keyboard;
	protected int bombRadius;
	protected boolean isAlive;
	protected Timer timer;
	
	protected final Lock lockAuthorizedBomb = new ReentrantLock();

	protected static final int INIT_AUTHORIZED_BOMBS = 1;
	protected static final int INIT_BOB_RADIUS = 1;
	protected static final int AFTER_DEATH_TIME = 2000;

	/**
	 * Constructor of player, used in method createPlayer of class BombermanLevel
	 * 
	 * @param data
	 * 			the game's data
	 * @param position
	 *            initial position of the player
	 */
	public Player(GameData data, Point position, String url) {
		super(data, position, url);

		this.getDriver().setmoveBlockerChecker(data.getMoveBlockerChecker());

		this.spriteManager = new SpriteManagerDefaultImpl(this.image, data.getConfiguration().getSpriteSize(), 5);
		this.spriteManager.setTypes("down", "right", "up", "left", "died");
		this.spriteManager.setType("down");
		this.spriteManager.reset();

		this.authorizedBombs = Player.INIT_AUTHORIZED_BOMBS;
		this.bombRadius = Player.INIT_BOB_RADIUS;
		this.isAlive = true;

		this.timer = new Timer(Player.AFTER_DEATH_TIME, this);
		this.timer.setRepeats(false);
	}
	
	/**
	 * draws the player
	 * @param g the graphics
	 */
	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, position);
	}

	/**
	 * getBoundingBox returns a rectangle which is the same size as the player's
	 * @return the rectangle
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
	 * Initialize the move strategy of the player
	 * @param keyboard the move strategy
	 */
	public void setKeyboard(BombermanMoveStrategy keyboard) {
		this.keyboard = keyboard;
		this.keyboard.setPlayer(this);
		this.keyboard.setSpeed(this.data.getConfiguration().getSpriteSize());
		this.getDriver().setStrategy(keyboard);
	}

	/**
	 * Drop a bomb in the position of the player
	 */
	public void dropBomb() {
		if (this.lockAuthorizedBomb.tryLock()) {
			try {
				if (this.authorizedBombs > 0) {
					this.authorizedBombs--;
					new Bomb(this.data, (Point) this.position.clone(), this.bombRadius, this);
				}
			} finally {
				this.lockAuthorizedBomb.unlock();
			}
		}
	}

	/**
	 * increases by 1 the number of bombs that can be on the board at the same time for the player
	 */
	public void increaseAuthorizedBomb() {
		if (this.lockAuthorizedBomb.tryLock()) {
			try {
				this.authorizedBombs++;
			} finally {
				this.lockAuthorizedBomb.unlock();
			}
		}
	}

	/**
	 * Increase the radius of the player's bombs by 1
	 */
	public void increaseBombRadius() {
		this.bombRadius++;
	}

	/**
	 * This function kills the player.
	 */
	public void kill() {
		this.spriteManager.setType("died");
		this.data.getCanvas().removeKeyListener(this.keyboard);
		this.isAlive = false;
		this.timer.start();
		try {
			this.lockAuthorizedBomb.lockInterruptibly();
		} catch (InterruptedException e) {
		}
	}

	/**
	 * isAlive returns true if our player is alive and false if he's dead
	 * @return true or false
	 */
	public boolean isAlive() {
		return this.isAlive;
	}
	
	/**
	 * getAuthorizedBombs return the authorizedBombs
	 * @return the authorizedBombs
	 */
	public int getAuthorizedBombs(){
		return this.authorizedBombs;
	}
	
	/**
	 * getRadius return the bombRadius
	 * @return the bombRadius
	 */
	public int getRadius(){
		return this.bombRadius;
	}

	/**
	 * actionPerformed allows us to access to the end of game
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		((BombermanLevel) this.data.getLevels().get(BombermanLevel.levelNumber)).end();
	}
}
