package bomberman.entity.explosion;

import java.awt.Point;
import gameframework.game.GameData;

/**
 * the HorizontalFlame class represents the horizontal borders of the explosion 
 */
public class HorizontalFlame extends Flame {

	/**
	 * Constructor of HorizontalFlame
	 * 
	 * @param data
	 * 				: the game's data
	 * @param position
	 * 				: the position of the entity
	 */
	public HorizontalFlame(GameData data, Point position, int moving) {
		super(data, position, "/images/explosion/FlameHorizontal.png", moving);
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
		Point goal = new Point(this.position.x + (moving * this.data.getConfiguration().getSpriteSize()),
				this.position.y);
		return goal;
	}
}