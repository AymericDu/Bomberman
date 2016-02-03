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
	 * Adds the entity to the game universe
	 * 
	 * @param data
	 *            the game data that the entity uses
	 * @param position
	 *            the position of this entity on the board
	 * @param urlString
	 *            the string representing the path to the entity's image
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
	 * Draws the entity with the graphics, the image and the coordinates
	 */
	@Override
	public void draw(Graphics graphics) {
		this.canvas.drawImage(graphics, this.image.getImage(), this.position.x, this.position.y);
	}

	/**
	 * Gives the bounding box of the entity, it's a rectangle
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.image.getWidth(), this.image.getWidth());
		rectangle.setLocation(this.position);
		return rectangle;
	}
}