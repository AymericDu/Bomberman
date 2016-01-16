package bomberman.entity;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BoxTest {

	Box boxTest;
	GameData data;
	GameConfiguration myGameConfiguration;

	@Before
	public void create() {
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		boxTest = new Box(data, new Point(0, 0));
	}

	@Test
	public void getBoundingBoxTest() {
		assertNotNull(boxTest.getBoundingBox());
	}
}
