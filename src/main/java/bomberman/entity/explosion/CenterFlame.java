package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

public class CenterFlame extends Flame {

	public CenterFlame(GameData data, Point position) {
		super(data, position, "/images/explosion/FlameCenter.png", 0);
	}

	@Override
	public Point createGoal(int moving) {
		return this.position;
	}
}
