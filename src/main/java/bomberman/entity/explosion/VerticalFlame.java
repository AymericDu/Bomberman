package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

public class VerticalFlame extends Flame {

	/**
	 * Constructor of VerticalFlame
	 * @param data
	 * @param position
	 */
	public VerticalFlame(GameData data, Point position, int moving) {
		super(data, position, "/images/explosion/FlameVertical.png", moving);
	}

	/**
	 * createGoal allows to create a Point with an int in parameter
	 */
	@Override
	public Point createGoal(int moving) {
		Point goal = new Point(this.position.x,
				this.position.y + (moving * this.data.getConfiguration().getSpriteSize()));
		return goal;
	}
}
