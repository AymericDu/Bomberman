package bomberman.entity;

import java.awt.Point;

import bomberman.entity.explosion.Flame;
import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public abstract class BlockerEntity extends Entity implements MoveBlocker {

	/**
	 * Constructor of NoMovableAndBlockerEntity
	 * 
	 * @param data
	 *            the GameData
	 * @param position
	 *            the position NoMovableAndBlockerEntity
	 * @param urlString
	 *            the url of the NoMovableAndBlockerEntity
	 */
	public BlockerEntity(GameData data, Point position, String urlString) {
		super(data, position, urlString);
	}
	
	/*public void block(Flame flame){
		flame.setBlocked(true);
	}*/
}
