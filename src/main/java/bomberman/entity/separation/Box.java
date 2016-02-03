package bomberman.entity.separation;

import java.awt.Point;

import bomberman.entity.UnmovableEntity;
import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

/**
 * Box class represents a Box that can be destroyed by bombs/flames in the game
 */
public class Box extends UnmovableEntity implements MoveBlocker {

	public Box(GameData data, Point position) {
		super(data, position, "/images/separation/Box.png");
	}

	/**
	 * Destroy and remove this box in the Game's universe
	 */
	public void destroy() {
		this.data.getUniverse().removeGameEntity(this);
	}
}