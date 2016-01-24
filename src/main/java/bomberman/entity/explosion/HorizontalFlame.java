package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

public class HorizontalFlame extends Flame {

	public HorizontalFlame(GameData data, Point position, int moving) {
		super(data, position, "/images/explosion/FlameHorizontal.png", moving);
	}

	@Override
	public Point createGoal(int moving) {
		Point goal = new Point(this.position.x + (moving * this.data.getConfiguration().getSpriteSize()),
				this.position.y);
		return goal;
	}
}
