package bomberman.entity.separation;

import java.awt.Point;

import bomberman.entity.NoMovableEntity;
import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public class Wall extends NoMovableEntity implements MoveBlocker {

	/**
	 * Constructor of the wall entity
	 * 
	 * @param data
	 *            : the game data
	 * @param position
	 *            : the position of the entity
	 */
	public Wall(GameData data, Point position) {
		super(data, position, "/images/separation/Wall.png");
	}
}
