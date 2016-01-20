package bomberman.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public abstract class NoMovableEntityTest {

	GameConfiguration myGameConfiguration = new GameConfiguration(20, 20, 20, 20);;
	GameData data = new GameData(myGameConfiguration);
	Point position = new Point(0, 0);

	/**
	 * use the attributes
	 */
	public abstract NoMovableAndBlockerEntity createNoMovableEntity();

	@Test
	public void noMovableTest() {
		NoMovableAndBlockerEntity entity = this.createNoMovableEntity();
		assertFalse(entity.isMovable());
	}

	@Test
	public void getBoundingBoxTest() {
		NoMovableAndBlockerEntity entity = this.createNoMovableEntity();
		Rectangle rectangle = entity.getBoundingBox();
		assertEquals(32, rectangle.getWidth(), 0);
		assertEquals(32, rectangle.getHeight(), 0);
		assertEquals(this.position, rectangle.getLocation());
	}
}
