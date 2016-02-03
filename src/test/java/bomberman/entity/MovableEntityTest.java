package bomberman.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class MovableEntityTest extends EntityTest {

	@Override
	public abstract MovableEntity createEntity();

	@Test
	public void isMovableTest() {
		MovableEntity entity = this.createEntity();
		assertTrue(entity.isMovable());
	}
}