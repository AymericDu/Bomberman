package entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BoxTest {

	protected GameConfiguration myGameConfiguration;
	protected GameData data;
	protected Box boxTest;

	@Before
	public void create() {
		GameConfiguration myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		GameData data = new GameData(myGameConfiguration);
		Box boxTest = new Box(data, 3, 3);
	}

	@Test
	public void getBoundingBoxTest() {
		assertNotNull(boxTest.getBoundingBox());
	}
}
