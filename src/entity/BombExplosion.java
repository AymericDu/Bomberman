package entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.TimerTask;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class BombExplosion extends TimerTask implements GameEntity, MoveBlocker, Drawable {

	protected GameData data;
	protected Point position;
	protected GameCanvas canvas;
	protected DrawableImage img;

	/**
	 * create a new BombExplosion
	 * @param data : GameData who contains informations of the game
	 * @param x : int the abscissa of the explosion
	 * @param y : int the ordinate of the explosion
	 */
	public BombExplosion(GameData data, int x, int y){
		this.data = data;
		this.canvas = data.getCanvas();
		this.position = new Point(x,y);
		this.img = new DrawableImage("/images/level1/explode.gif", this.canvas);
	}
	
	/**
	 * give the bounding box of the explosion
	 * @return Rectangle : the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getHeight());
		rectangle.setLocation(position.x, position.y);
		return rectangle;
	}

	/**
	 * draw the explosion with the Graphics g, the image and the coordinates of it.
	 * @param g : Graphics
	 */
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);		
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
	 * remove life to a character, destroy destructibles entity or nothing
	 */
	@Override
	public void run() {
		//TO-DO
	}

}
