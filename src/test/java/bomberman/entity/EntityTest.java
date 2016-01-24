package bomberman.entity;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public abstract class EntityTest {

	protected GameData data = new GameData(new GameConfiguration(21, 21, 32, 1));
	protected Point position = new Point(0, 0);

	/**
	 * use the attributes data and position
	 */
	public abstract Entity createEntity();

	@Test
	public void getBoundingBoxTest() {
		Entity entity = this.createEntity();
		Rectangle rectangle = entity.getBoundingBox();
		assertEquals(32, rectangle.getWidth(), 0);
		assertEquals(32, rectangle.getHeight(), 0);
		assertEquals(this.position, rectangle.getLocation());
	}
}
