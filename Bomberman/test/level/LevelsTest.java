package level;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class LevelsTest {

	GameConfiguration configuration;
	GameData data;
	Levels myLevels;

	@Before
	public void create() {
		int nbRows = 20;
		int nbColumns = 20;
		int spriteSize = 20;
		int nbLives = 20;
		GameConfiguration configuration = new GameConfiguration(nbRows, nbColumns, spriteSize, nbLives);
		GameData data = new GameData(configuration);
		Levels myLevels = new Levels(data);
		myLevels.createWalls();
	}

	@Test
	public void mytest() {
	}

}
