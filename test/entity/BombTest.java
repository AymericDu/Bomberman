package entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BombTest {

	protected Bomb b;

	@Before
	public void create() {
		GameConfiguration myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		GameData data = new GameData(myGameConfiguration);
		Bomb b = new Bomb(data, 2, new Player(data, 1,1));
 
	}

	@Test
	public void getRadiusTest() {
		assertEquals(2, b.getRadius());
	}

}
