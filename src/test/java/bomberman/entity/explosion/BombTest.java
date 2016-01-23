package bomberman.entity.explosion;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import bomberman.entity.EntityTest;
import bomberman.entity.Player;

public class BombTest extends EntityTest {

	@Override
	public Bomb createEntity() {
		return new Bomb(this.data, this.position, 2, new Player(this.data, this.position));
	}

	@Test
	public void getRadiusTest() {
		Bomb bomb = this.createEntity();
		assertEquals(2, bomb.getRadius());
	}
}
