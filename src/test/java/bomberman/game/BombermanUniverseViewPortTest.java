package bomberman.game;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bomberman.game.BombermanUniverseViewPort;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BombermanUniverseViewPortTest {

	GameConfiguration config;
	GameData data;
	BombermanUniverseViewPort bombermanTest;

	@Before
	public void create() {
		config = new GameConfiguration(0, 0, 0, 0);
		data = new GameData(config);
		bombermanTest = new BombermanUniverseViewPort(data);
	}

	@Test
	public void backgroundImageTest() {
		assertNotNull(bombermanTest.backgroundImage());
	}
}