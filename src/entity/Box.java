package entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class Box implements GameEntity, MoveBlocker, Drawable {

	protected GameData data;
	protected Point position;
	protected GameCanvas canvas;
	protected DrawableImage img;

	URL url = Bomb.class.getResource("/images/level1/Box.gif");

	/**
	 * create a new Box
	 * @param data : Gamedata contains informations of the game
	 * @param x : int the abscissa of the Box
	 * @param y : int the ordinate of the Box
	 * @param radius : int the radius
	 */
	public Box(GameData data, int x, int y) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.position = new Point(x, y);
		this.img = new DrawableImage(url, this.canvas);
	}

	/**
	 * give the bounding box of the box
	 * @return Rectangle : the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getHeight());
		rectangle.setLocation(position.x, position.y);
		return rectangle;
	}

	/**
	 * draw the box with the Graphics g, the image and the coordinates of the box.
	 * @param g : Graphics
	 */
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);
	}

	/**
	 * return if the box is movable or not
	 * @return boolean : false
	 */
	@Override
	public boolean isMovable() {
		// TODO Auto-generated method stub
		return false;
	}

}
