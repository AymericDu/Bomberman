package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;

public class Wall extends NoMovableEntity {

	public Wall(GameData data, Point position) {
		super(data, position, "/images/level/Wall.png");
	}
}
