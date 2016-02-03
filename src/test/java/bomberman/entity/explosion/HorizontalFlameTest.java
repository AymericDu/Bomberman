package bomberman.entity.explosion;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class HorizontalFlameTest extends FlameTest {

	@Override
	public HorizontalFlame createEntity() {
		HorizontalFlame flame = new HorizontalFlame(this.data, this.position, 1);
		flame.timer.stop();
		return flame;
	}

	@Test
	public void createGoalTest() {
		HorizontalFlame flame = this.createEntity();
		assertEquals(new Point(64, 0), flame.createGoal(2));
	}
}