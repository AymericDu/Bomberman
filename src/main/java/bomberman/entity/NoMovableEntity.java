package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;

/**
 * All of the objects which are not movable
 * 
 *
 */
public class NoMovableEntity extends Entity {

	public NoMovableEntity(GameData data, Point position, String urlString) {
		super(data,position,urlString);
	}
	
	/**
	 * isMovable returns false because by definition a NoMovableEntity cannot move
	 * @return false
	 */
	@Override
	public boolean isMovable() {
		return false;
	}
}
