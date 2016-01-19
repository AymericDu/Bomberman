package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.drawing.SpriteManagerDefaultImpl;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyKeyboard;
import gameframework.motion.SpeedVector;

public class Player extends GameMovable implements GameEntity, KeyListener {

	protected SpriteManagerDefaultImpl spriteManager;
	protected int spriteSize;
	protected GameCanvas canvas;
	protected GameData data;
	
	protected Point direction;
	
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
	public Player(GameData data, Point position) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.spriteSize = data.getConfiguration().getSpriteSize();
		URL url = Player.class.getResource("/images/level/BombermanSprite.png");
		this.spriteManager = new SpriteManagerDefaultImpl(new DrawableImage(url, canvas), this.spriteSize, 5);

		this.isAlive = true;
		this.bombsAvailable.add(new Bomb(this.data, this.getPosition(), 2));

		this.setPosition(position);
		this.direction = new Point(0, 1);
		this.initSpriteManager();

		MoveStrategyKeyboard keyboard = new MoveStrategyKeyboard(false);
		keyboard.setSpeed(32);
		this.getDriver().setStrategy(keyboard);
		this.getDriver().setmoveBlockerChecker(data.getMoveBlockerChecker());
		
		this.data.getCanvas().addKeyListener(keyboard);
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
	public GameData getGameData(){
		return this.data;
	}
	
	/**
	 * setDirection allows to change the direction of our player
	 * @param p the new direction
	 */
	public void setDirection(Point p){
		this.direction=p;
	}
	
	/**
	 * getDirection return the direction of our player
	 * @return the direction
	 */
	public Point getDirection(){
		return this.direction;
	}
	
	public MoveStrategyKeyboard getKeyboard(){
		return this.getKeyboard();
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
	 * add a bomb for the player
	 */
	public void addBomb(Bomb b){
		bombsAvailable.add(b);
	}
	
	/**
	 * @return true if the player is alive and false if he's dead
	 */
	protected boolean getIsAlive() {
		return isAlive;
	}
	
	/**
	 * This function allows to change isAlive in false. It allow to kill the player.
	 */
	protected void kill(){
		// TODO Change img
		this.isAlive=false;
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
	public SpriteManagerDefaultImpl getSpriteManager(){
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
		// TODO Auto-generated method stub
		
	}

	/**
	 * Override keyPressed to know if the player pressed or not space
	 * @param arg0 the key pressed
	 */
	@Override
	public void keyPressed(KeyEvent arg0) {
		keyPressed(arg0.getKeyCode());
	}
	
	/**
	 * Called by keyPressed, make a hit if the previous hit is finished.
	 * @param keyCode the keyCode give by keyPressed.
	 */
	public void keyPressed(int keyCode) {
			switch (keyCode) {
			case KeyEvent.VK_SPACE: {
				this.dropBomb();
				break;
			}
			default:
				;
			}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
}
