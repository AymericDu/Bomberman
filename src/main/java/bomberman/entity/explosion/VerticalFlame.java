package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * the VerticalFlame class represents the vertical borders of the explosion 
 */
public class VerticalFlame extends Flame {

	/**
	 * Constructor of VerticalFlame
	 * 
	 * @param data
	 * 				: the game's data
	 * @param position
	 * 				: the position of the entity
	 */
	public VerticalFlame(GameData data, Point position, int moving) {
		super(data, position, "/images/explosion/FlameVertical.png", moving);
	}

	/**
	 * createGoal allows to create a Point with an int in parameter
	 * 
	 * @param moving
	 * 				: the moving
	 * @return a Point
	 */
	@Override
	public Point createGoal(int moving) {
		Point goal = new Point(this.position.x,
				this.position.y + (moving * this.data.getConfiguration().getSpriteSize()));
		return goal;
	}
}