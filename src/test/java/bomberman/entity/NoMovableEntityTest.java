package bomberman.entity;

import static org.junit.Assert.*;

import org.junit.Test;

public abstract class NoMovableEntityTest extends EntityTest {

	@Override
	public abstract NoMovableEntity  createEntity();
	
	@Test
	public void isMovableTest() {
		NoMovableEntity entity = this.createEntity();
		assertFalse(entity.isMovable());
	}
}