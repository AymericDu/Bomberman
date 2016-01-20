package bomberman.entity;

import java.awt.Point;
import java.awt.Rectangle;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public abstract class NoMovableAndBlockerEntity extends NoMovableEntity implements MoveBlocker {

	public NoMovableAndBlockerEntity(GameData data, Point position, String urlString) {
		super(data, position, urlString);
	}

	/**
	 * give the bounding box of the box
	 * 
	 * @return Rectangle : the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(this.position);
		return rectangle;
	}
}
