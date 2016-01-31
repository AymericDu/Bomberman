package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.GameMovable;

/**
 * This abstract class represents all the movable entities
 */
public abstract class MovableEntity extends GameMovable implements Entity {

	protected GameData data;
	protected GameCanvas canvas;
	protected DrawableImage image;

	/**
	 * Constructor of NoMovableEntity
	 * 
	 * @param data
	 * 				: the GameData
	 * @param position
	 * 				: the position of this entity
	 * @param urlString
	 * 				: the string representing the path to the entity's image
	 */
	public MovableEntity(GameData data, Point position, String urlString) {
		this.data = data;
		this.canvas = data.getCanvas();
		URL url = MovableEntity.class.getResource(urlString);
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
}
