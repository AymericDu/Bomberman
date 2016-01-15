package entity;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BoxTest {
	
	Box boxTest;
	GameData data;
	GameConfiguration myGameConfiguration;

	@Test
	public void getBoundingBoxTest() {
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		boxTest = new Box(data,1,1);
		assertNotNull(boxTest.getBoundingBox());
	}
}
