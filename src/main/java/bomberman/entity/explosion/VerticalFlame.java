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
	 * createGoal returns a point representing the flame's expansion, in this case it will return a point in the same vertical line 
	 * 
	 * @param moving
	 * 				: the expansion level from the explosion	
	 * @return a Point
	 */
	@Override
	public Point createGoal(int moving) {
		Point goal = new Point(this.position.x,
				this.position.y + (moving * this.data.getConfiguration().getSpriteSize()));
		return goal;
	}
}