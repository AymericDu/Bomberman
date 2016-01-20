package bomberman.entity;

import static org.junit.Assert.assertFalse;

import java.awt.Point;

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
	public abstract NoMovableEntity createNoMovableEntity();

	@Test
	public void noMovableTest() {
		NoMovableEntity entity = this.createNoMovableEntity();
		assertFalse(entity.isMovable());
	}
}
