package bomberman.entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class WallTest {

	GameConfiguration myGameConfiguration;
	GameData data;
	Wall wallTest;

	@Before
	public void create() {
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		wallTest = new Wall(data, 20, 20);
	}

	@Test
	public void getBoundingBoxTest() {
		assertNotNull(wallTest.getBoundingBox());
	}
}
