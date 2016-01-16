package bomberman.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BombTest extends NoMovableEntityTest {

	@Override
	public Bomb createNoMovableEntity() {
		return new Bomb(this.data, this.position, 2);
	}

	@Test
	public void getRadiusTest() {
		Bomb bomb = this.createNoMovableEntity();
		assertEquals(2, bomb.getRadius());
	}
}
