package bomberman.uid;

import static org.junit.Assert.*;

import org.junit.Test;

import gameframework.game.GameData;

public class BombermanConfigurationTest {

	@Test
	public void createOverlapRulesApplierTest() {
		BombermanConfiguration conf = new BombermanConfiguration(1, 1, 1, 1);
		GameData data = new GameData(conf);
		assertEquals(conf, data.getConfiguration());
	}
}
