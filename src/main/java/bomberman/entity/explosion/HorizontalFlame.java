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
	 * createGoal returns a point representing the flame's expansion, in this case it will return a point in the same horizontal line 
	 * 
	 * @param moving
	 * 				: the expansion level from the explosion	
	 * @return a Point
	 */
	@Override
	protected Point createGoal(int moving) {
		Point goal = new Point(this.position.x + (moving * this.data.getConfiguration().getSpriteSize()),
				this.position.y);
		return goal;
	}
}