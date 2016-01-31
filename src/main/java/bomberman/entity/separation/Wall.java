package bomberman.entity.separation;

import java.awt.Point;

import bomberman.entity.NoMovableEntity;
import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

/**
 * Wall class represents the Wall in the game which are fixed and cannot be destroyed by bombs/flames
 */
public class Wall extends NoMovableEntity implements MoveBlocker {

	public Wall(GameData data, Point position) {
		super(data, position, "/images/separation/Wall.png");
	}
}