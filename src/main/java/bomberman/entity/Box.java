package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public class Box extends NoMovableEntity implements MoveBlocker {

	/**
	 * create a new Box
	 * 
	 * @param data
	 *            : Gamedata contains informations of the game
	 * @param x
	 *            : int the abscissa of the Box
	 * @param y
	 *            : int the ordinate of the Box
	 * @param radius
	 *            : int the radius
	 */
	public Box(GameData data, Point position) {
		super(data, position, "/images/level/Box.png");
	}
}
