package bomberman.entity;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BombTest {

	Bomb b;
	GameConfiguration myGameConfiguration;
	GameData data;

	@Before
	public void create() {
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		b = new Bomb(data, new Point(0, 0), 2);
	}

	@Test
	public void getRadiusTest() {
		assertEquals(2, b.getRadius());
	}

}
