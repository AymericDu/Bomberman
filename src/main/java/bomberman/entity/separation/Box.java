package bomberman.entity.separation;

import java.awt.Point;

import bomberman.entity.NoMovableEntity;
import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public class Box extends NoMovableEntity implements MoveBlocker {

	/**
	 * Constructor of Box
	 * 
	 * @param data
	 *            the gameData
	 * @param position
	 *            the position
	 */
	public Box(GameData data, Point position) {
		super(data, position, "/images/separation/Box.png");
	}

	public void destroy() {
		this.data.getUniverse().removeGameEntity(this);
	}
}
