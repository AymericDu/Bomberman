package entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class PlayerTest {

	GameConfiguration myGameConfiguration;
	GameData data;
	Player playerTest;

	@Before
	public void create() {
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		playerTest = new Player(data, 4, 4);
	}

	@Test
	public void getBoundingBoxTest() {
		assertNotNull(playerTest.getBoundingBox());
	}
}
