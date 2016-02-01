package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * the VerticalFlame class represents the vertical dimension of the explosion 
 */
public class VerticalFlame extends Flame {

	public VerticalFlame(GameData data, Point position, int moving) {
		super(data, position, "/images/explosion/FlameVertical.png", moving);
	}

	/**
	 * createGoal will return a point in the same vertical line 
	 * 
	 * @param moving
	 * 				: the shift between the position of the explosion and the flame's goal	
	 * @return a Point
	 */
	@Override
	protected Point createGoal(int moving) {
		Point goal = new Point(this.position.x,
				this.position.y + (moving * this.data.getConfiguration().getSpriteSize()));
		return goal;
	}
}