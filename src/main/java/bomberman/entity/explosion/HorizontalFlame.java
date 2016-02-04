package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * The HorizontalFlame class represents the horizontal dimension of the
 * explosion
 */
public class HorizontalFlame extends Flame {

	public HorizontalFlame(GameData data, Point position, int shift) {
		super(data, position, "/images/explosion/FlameHorizontal.png", shift);
	}

	/**
	 * Return a point in the same horizontal line
	 */
	@Override
	protected Point createGoal(int shift) {
		Point goal = new Point(this.position.x + (shift * this.data.getConfiguration().getSpriteSize()),
				this.position.y);
		return goal;
	}
}