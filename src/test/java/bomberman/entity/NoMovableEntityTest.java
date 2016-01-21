package bomberman.entity;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public abstract class NoMovableEntityTest {

	GameConfiguration myGameConfiguration;
	GameData data;
	Point position;
	NoMovableEntity entity;
	
	@Before
	public void create(){
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);;
		data = new GameData(myGameConfiguration);
		position = new Point(0, 0);
		entity = this.createNoMovableEntity();

	}
	
	public abstract NoMovableEntity createNoMovableEntity();
	
	@Test
	public void noMovableTest() {
		assertFalse(entity.isMovable());
	}
	
	@Test
	public void getPositionTest(){
		assertEquals(position ,entity.getPosition());
	}
}
