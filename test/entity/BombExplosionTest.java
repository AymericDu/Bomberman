package entity;

import static org.junit.Assert.assertNotNull;


import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BombExplosionTest {

	protected GameConfiguration myGameConfiguration;
	protected GameData data;
	protected BombExplosion bombExplosionTest;

	@Before
	public void create(){
		GameConfiguration myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		GameData data = new GameData(myGameConfiguration);
		BombExplosion bombExplosionTest = new BombExplosion(data, 0, 0);
	}

	@Test
	public void getBoundingBoxTest() {
		assertNotNull(bombExplosionTest.getBoundingBox());
	}
}