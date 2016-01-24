package bomberman.entity.explosion;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class VerticalFlameTest extends FlameTest{

	@Override
	public VerticalFlame createEntity() {
		return new VerticalFlame(this.data, this.position, 0);
	}

	@Test
	public void createGoalTest() {
		VerticalFlame v = this.createEntity();
		assertEquals(new Point(this.position.x,
				this.position.y + (2 * this.data.getConfiguration().getSpriteSize())) ,v.createGoal(2));
	}
}
