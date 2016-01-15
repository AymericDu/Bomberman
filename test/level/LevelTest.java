package level;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class LevelTest {

	GameConfiguration configuration;
	GameData data;
	Level level;

	@Before
	public void create() {
		configuration = new GameConfiguration(20,20,20,20);
		data = new GameData(configuration);
		level = new Level(data);
	}

	@Test
	public void createWallsTest(){
		level.createWalls();
	}
}
