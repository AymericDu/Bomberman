package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * the CenterFlame class represents the center of the explosion, it's located where the bomb is dropped 
 */
public class CenterFlame extends Flame {

	/**
	 * Constructor of CenterFlame
	 * 
	 * @param data
	 * 				: the game's data
	 * @param position
	 * 				: the position of the entity
	 */
	public CenterFlame(GameData data, Point position) {
		super(data, position, "/images/explosion/FlameCenter.png", 0);
	}

	/**
	 * createGoal allows to create a Point with an int in parameter
	 * @param moving
	 * 				: the moving
	 * @return a Point
	 */
	@Override
	public Point createGoal(int moving) {
		return this.position;
	}
}