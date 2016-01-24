package bomberman.entity.explosion;

import java.awt.Point;

import gameframework.game.GameData;

public class VerticalFlame extends Flame {

	public VerticalFlame(GameData data, Point position, int moving) {
		super(data, position, "/images/explosion/FlameVertical.png", moving);
	}

	@Override
	public Point createGoal(int moving) {
		Point goal = new Point(this.position.x,
				this.position.y + (moving * this.data.getConfiguration().getSpriteSize()));
		return goal;
	}
}
