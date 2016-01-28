package bomberman.entity.explosion;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class VerticalFlameTest extends FlameTest {

	@Override
	public VerticalFlame createEntity() {
		VerticalFlame flame = new VerticalFlame(this.data, this.position, 1);
		flame.timer.stop();
		return flame;
	}

	@Test
	public void createGoalTest() {
		VerticalFlame flame = this.createEntity();
		assertEquals(new Point(0, 64), flame.createGoal(2));
	}
}