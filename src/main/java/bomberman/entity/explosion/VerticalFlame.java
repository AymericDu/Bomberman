package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * The VerticalFlame class represents the vertical dimension of the explosion
 */
public class VerticalFlame extends Flame {

	public VerticalFlame(GameData data, Point position, int shift) {
		super(data, position, "/images/explosion/FlameVertical.png", shift);
	}

	/**
	 * Return a point in the same vertical line
	 */
	@Override
	protected Point createGoal(int shift) {
		Point goal = new Point(this.position.x,
				this.position.y + (shift * this.data.getConfiguration().getSpriteSize()));
		return goal;
	}
}