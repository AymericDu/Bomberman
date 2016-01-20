package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.blocking.MoveBlocker;

public class Box extends NoMovableEntity implements MoveBlocker {

	public Box(GameData data, Point position) {
		super(data, position, "/images/level/Box.png");
	}
}
