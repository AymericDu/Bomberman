package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class Bomb implements GameEntity,  MoveBlocker, Drawable, ActionListener {

	protected Timer timer;
	protected GameData data;
	protected GameCanvas canvas;
	protected DrawableImage img;
	protected int radius;
	protected Player player;

	/**
	 * create a new Bomb
	 * @param data : Gamedata contains informations of the game
	 * @param x : int the abscissa of the bomb
	 * @param y : int the ordinate of the bomb
	 * @param radius : int the radius
	 */
	public Bomb(GameData data, int radius, Player p) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.radius = radius;
		this.img = new DrawableImage("/images/level1/caisselvl1.gif",this.canvas);
		this.timer = new Timer();
		this.player = p;
	}

	/**
	 * give the radius of the current bomb
	 * @return int : the radius of the bomb
	 */
	public int getRadius() {
		return this.radius;
	}

	/**
	 * give the bounding box of the bomb
	 * @return Rectangle : the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getHeight());
		rectangle.setLocation((int) player.getPosition().getX(), (int) player.getPosition().getY());
		return rectangle;
	}
	/**
	 * draw the bomb with the Graphics g, the image and the coordinates of the bomb.
	 * @param g : Graphics
	 */
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), (int) player.getPosition().getX(),
				(int) player.getPosition().getY());
	}

	/**
	 * return if the bomb is movable or not
	 * @return boolean : false
	 */
	@Override
	public boolean isMovable() {
		return false;
	}
	
	/**
	 * start the Timer (before explosion)
	 */
	public void startTimer(){
		BombExplosion task = new BombExplosion(this.data);
		timer.schedule(task, 2000);
	}

	/**
	 * do an explosion when this an specific action is occur (timer be 0)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
