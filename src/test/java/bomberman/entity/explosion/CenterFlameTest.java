package bomberman.entity.explosion;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class CenterFlameTest extends FlameTest {

	@Override
	public CenterFlame createEntity() {
		CenterFlame flame = new CenterFlame(this.data, this.position);
		flame.timer.stop();
		return flame;
	}

	@Test
	public void createGoalTest() {
		CenterFlame flame = this.createEntity();
		assertEquals(new Point(0, 0), flame.createGoal(2));
	}
}