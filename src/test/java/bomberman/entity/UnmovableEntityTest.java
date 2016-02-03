package bomberman.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class UnmovableEntityTest extends EntityTest {

	@Override
	public abstract UnmovableEntity createEntity();

	@Test
	public void isMovableTest() {
		UnmovableEntity entity = this.createEntity();
		assertFalse(entity.isMovable());
	}
}