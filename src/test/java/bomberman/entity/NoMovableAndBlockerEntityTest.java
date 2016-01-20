package bomberman.entity;

import static org.junit.Assert.assertEquals;

import java.awt.Rectangle;

import org.junit.Test;

public abstract class NoMovableAndBlockerEntityTest extends NoMovableEntityTest {

	/**
	 * use the attributes
	 */
	@Override
	public abstract NoMovableAndBlockerEntity createNoMovableEntity();

	@Test
	public void getBoundingBoxTest() {
		NoMovableAndBlockerEntity entity = this.createNoMovableEntity();
		Rectangle rectangle = entity.getBoundingBox();
		assertEquals(32, rectangle.getWidth(), 0);
		assertEquals(32, rectangle.getHeight(), 0);
		assertEquals(this.position, rectangle.getLocation());
	}
}
