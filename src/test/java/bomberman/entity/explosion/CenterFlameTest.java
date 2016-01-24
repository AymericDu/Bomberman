package bomberman.entity.explosion;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class CenterFlameTest extends FlameTest{

	@Override
	public CenterFlame createEntity() {
		return new CenterFlame(this.data, this.position);
	}

	@Test
	public void createGoalTest() {
		CenterFlame v = this.createEntity();
		assertEquals(new Point(this.position.x,
				this.position.y ) ,v.createGoal(2));
	}

}
