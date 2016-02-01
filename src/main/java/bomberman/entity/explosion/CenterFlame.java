package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * the CenterFlame class represents the center of the explosion, it's located where the bomb is dropped 
 */
public class CenterFlame extends Flame {

	public CenterFlame(GameData data, Point position) {
		super(data, position, "/images/explosion/FlameCenter.png", 0);
	}

	/**
	 * createGoal will return the same point because the goal of the centerFlame is the same point
	 * @param shift
	 * 				: useless here	
	 * @return a Point
	 */
	@Override
	protected Point createGoal(int shift) {
		return this.position;
	}
}