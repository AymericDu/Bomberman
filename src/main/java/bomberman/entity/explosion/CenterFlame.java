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
	 * createGoal returns a point representing the flame's expansion, in this case it will return the same point
	 * The center flame will not be expanded 
	 * @param moving
	 * 				: the expansion level from the explosion, useless here	
	 * @return a Point
	 */
	@Override
	public Point createGoal(int moving) {
		return this.position;
	}
}