package bomberman.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public abstract class EntityTest {

	protected GameData data = new GameData(new GameConfiguration(20, 20, 20, 20));
	protected Point position = new Point(0, 0);
	
	/**
	 * use the attributes data and position
	 */
	public abstract Entity createEntity();
	
	@Test
	public void noMovableTest() {
		Entity entity = this.createEntity();
		assertTrue(entity.isMovable());
	}

	@Test
	public void getBoundingBoxTest() {
		Entity entity = this.createEntity();
		Rectangle rectangle = entity.getBoundingBox();
		assertEquals(32, rectangle.getWidth(), 0);
		assertEquals(32, rectangle.getHeight(), 0);
		assertEquals(this.position, rectangle.getLocation());
	}
}
