package bomberman.entity.separation;

import java.awt.Point;

import bomberman.entity.BlockerEntity;
import gameframework.game.GameData;

public class Wall extends BlockerEntity {

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
