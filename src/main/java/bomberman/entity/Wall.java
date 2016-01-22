package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;

public class Wall extends BlockerEntity {

	/**
	 * Constructor of the wall entity
	 * @param data : the game data 
	 * @param position : the position of the entity
	 */
	public Wall(GameData data, Point position) {
		super(data, position, "/images/level/Wall.png");
	}
}
