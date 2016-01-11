package entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class GrassTest {

	protected GameConfiguration myGameConfiguration;
	protected GameData data;
	protected Grass grassTest;

	@Before
	public void create() {
		GameConfiguration myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		GameData data = new GameData(myGameConfiguration);
		Grass grassTest = new Grass(data, 0, 0);
	}

	@Test
	public void getBoundingBoxTest() {
		assertNotNull(grassTest.getBoundingBox());
	}
}
