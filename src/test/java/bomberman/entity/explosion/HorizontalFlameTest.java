package bomberman.entity.explosion;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class HorizontalFlameTest extends FlameTest {

	@Override
	public HorizontalFlame createEntity() {
		return new HorizontalFlame(this.data, this.position,1);
	}

	@Test
	public void createGoalTest() {
		HorizontalFlame v = this.createEntity();
		assertEquals(new Point(this.position.x+ (2 * this.data.getConfiguration().getSpriteSize()),
				this.position.y) ,v.createGoal(2));
	}

}
