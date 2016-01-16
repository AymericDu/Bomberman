package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;

public class Wall extends NoMovableEntity {

	/**
	 * create a new Wall
	 * 
	 * @param data
	 *            : Gamedata contains informations of the game
	 * @param x
	 *            : int the abscissa of the Wall
	 * @param y
	 *            : int the ordinate of the Wall
	 * @param radius
	 *            : int the radius
	 */
	public Wall(GameData data, Point position) {
		super(data, position, "/images/level/Wall.png");
	}
}
