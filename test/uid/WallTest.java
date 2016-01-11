package uid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import uid.Wall;

public class WallTest {

	protected GameConfiguration myGameConfiguration;
	protected GameData data;
	protected Wall wallTest;

	@Before
	public void create() {
		GameConfiguration myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		GameData data = new GameData(myGameConfiguration);
		Wall wallTest = new Wall(data, 20, 20);
	}

	@Test
	public void getBoundingBoxTest() {
		assertNotNull(wallTest.getBoundingBox());
	}
}
