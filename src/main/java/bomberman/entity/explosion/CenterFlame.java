package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

public class CenterFlame extends Flame {

	/**
	 * Constructor of CenterFlame
	 * @param data
	 * @param position
	 */
	public CenterFlame(GameData data, Point position) {
		super(data, position, "/images/explosion/FlameCenter.png", 0);
	}

	/**
	 * createGoal allows to create a Point with an int in parameter
	 */
	@Override
	public Point createGoal(int moving) {
		return this.position;
	}
}
