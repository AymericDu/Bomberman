package bomberman.entity.player;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bomberman.entity.MovableEntity;
import bomberman.entity.explosion.Bomb;
import bomberman.game.BombermanMoveStrategy;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameLevel;

/**
 * Player class represents a player (bomberman) to be manipulated with the
 * keyboard
 */
public class Player extends MovableEntity implements ActionListener {

	protected SpriteManagerDefaultImpl spriteManager;
	protected int authorizedBombs;
	protected BombermanMoveStrategy keyboard;
	protected int bombRadius;
	protected boolean isAlive;
	private Timer timer;

	protected final Object lockAuthorizedBomb = new Object();
	protected final GameLevel myLevel;

	protected static final int INIT_AUTHORIZED_BOMBS = 1;
	protected static final int INIT_BOMB_RADIUS = 1;
	protected static final int AFTER_DEATH_TIME = 2000;

	public static final String GREEN_PLAYER = "/images/player/BombermanSpriteGreenPlayer.png";
	public static final String PINK_PLAYER = "/images/player/BombermanSpritePinkPlayer.png";

	/**
	 * @param level
	 *            the level in which the player moves
	 */
	public Player(GameData data, Point position, String url, GameLevel level) {
		super(data, position, url);

		this.getDriver().setmoveBlockerChecker(data.getMoveBlockerChecker());

		this.spriteManager = new SpriteManagerDefaultImpl(this.image, data.getConfiguration().getSpriteSize(), 5);
		this.spriteManager.setTypes("down", "right", "up", "left", "died");
		this.spriteManager.setType("down");
		this.spriteManager.reset();

		this.authorizedBombs = Player.INIT_AUTHORIZED_BOMBS;
		this.bombRadius = Player.INIT_BOMB_RADIUS;
		this.isAlive = true;

		this.timer = new Timer(Player.AFTER_DEATH_TIME, this);
		this.getTimer().setRepeats(false);

		this.myLevel = level;
	}

	@Override
	public void draw(Graphics g) {
		this.spriteManager.draw(g, position);
	}

	@Override
	public Rectangle getBoundingBox() {
		int spriteSize = data.getConfiguration().getSpriteSize();
		Rectangle rectangle = new Rectangle(spriteSize, spriteSize);
		rectangle.setLocation((int) this.position.getX() * spriteSize, (int) this.position.getY() * spriteSize);
		return rectangle;
	}

	/**
	 * Each movement is associated an image showing the behavior of the player
	 */
	@Override
	public void oneStepMoveAddedBehavior() {
		if (this.isAlive) {
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
	}

	/**
	 * Initialize the move strategy of the player
	 * 
	 * @param keyboard
	 *            the keyboard contains the moving key and the bomb depot
	 */
	public void setKeyboard(BombermanMoveStrategy keyboard) {
		this.keyboard = keyboard;
		this.keyboard.setPlayer(this);
		this.keyboard.setSpeed(this.data.getConfiguration().getSpriteSize() / 2);
		this.getDriver().setStrategy(keyboard);
		this.data.getCanvas().addKeyListener(keyboard);
	}

	/**
	 * Remove the keyboard of the player, the player now cannot move
	 */
	public void removeKeyboard() {
		if (this.keyboard != null) {
			this.keyboard.getSpeedVector().setSpeed(0);
			this.data.getCanvas().removeKeyListener(this.keyboard);
			this.keyboard = null;
		}
	}

	/**
	 * Drop a bomb in the position of the player
	 */
	public void dropBomb() {
		synchronized (this.lockAuthorizedBomb) {
			if (this.authorizedBombs > 0) {
				this.authorizedBombs--;
				new Bomb(this.data, (Point) this.position.clone(), this.bombRadius, this);
			}
		}
	}

	/**
	 * Increase by one the number of bombs that can be on the board at the same
	 * time for this player
	 */
	public void increaseAuthorizedBomb() {
		synchronized (this.lockAuthorizedBomb) {
			this.authorizedBombs++;
		}
	}

	/**
	 * Increase the radius of the player's bombs by one
	 */
	public void increaseBombRadius() {
		this.bombRadius++;
	}

	/**
	 * Kill the player and start the timer at the end of the level
	 */
	public synchronized void kill() {
		if (this.isAlive) {
			this.isAlive = false;
			this.spriteManager.setType("died");
			this.removeKeyboard();
			this.getTimer().start();
		}
	}

	public boolean isAlive() {
		return this.isAlive;
	}

	/**
	 * The action performed after the player's death who ends the level
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.myLevel.end();
	}

	public Timer getTimer() {
		return timer;
	}
}