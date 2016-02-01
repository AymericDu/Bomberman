package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * the HorizontalFlame class represents the horizontal dimension of the explosion 
 */
public class HorizontalFlame extends Flame {

	public HorizontalFlame(GameData data, Point position, int moving) {
		super(data, position, "/images/explosion/FlameHorizontal.png", moving);
	}

	/**
	 * createGoal will return a point in the same horizontal line 
	 * 
	 * @param shift
	 * 				: the shift between the position of the explosion and the flame's goal	
	 * @return a Point
	 */
	@Override
	protected Point createGoal(int shift) {
		Point goal = new Point(this.position.x + (shift * this.data.getConfiguration().getSpriteSize()),
				this.position.y);
		return goal;
	}
}