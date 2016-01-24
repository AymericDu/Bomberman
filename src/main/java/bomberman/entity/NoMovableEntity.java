package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;

public class NoMovableEntity implements Entity {

	protected GameData data;
	protected GameCanvas canvas;
	protected DrawableImage image;
	protected Point position;

	/**
	 * Constructor of NoMovableEntity
	 * 
	 * @param data the game's data
	 * @param position the position of the entity
	 * @param urlString the string representing the path to the entity's image
	 */
	public NoMovableEntity(GameData data, Point position, String urlString) {
		this.data = data;
		this.canvas = data.getCanvas();
		URL url = NoMovableEntity.class.getResource(urlString);
		this.image = new DrawableImage(url, this.canvas);
		this.position = position;
		this.data.getUniverse().addGameEntity(this);
	}

	/**
	 * Draw the bomb with the Graphics g, the image and the coordinates of the
	 * bomb.
	 * 
	 * @param g
	 *            : Graphics
	 */
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.image.getImage(), this.position.x, this.position.y);
	}

	/**
	 * Give the bounding box of the box
	 * 
	 * @return Rectangle : the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.image.getWidth(), this.image.getWidth());
		rectangle.setLocation(this.position);
		return rectangle;
	}

	
	/**
	 * returns false because by definition a NoMovableEntity cannot move
	 * @return false
	 */
	@Override
	public boolean isMovable() {
		return false;
	}

	
	/**
	 * returns the position of the entity
	 * @return a point representing the position
	 */
	@Override
	public Point getPosition() {
		return this.position;
	}
}
