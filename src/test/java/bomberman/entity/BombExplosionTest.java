package bomberman.entity;

import static org.junit.Assert.assertNotNull;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BombExplosionTest {

	GameConfiguration myGameConfiguration;
	GameData data;
	BombExplosion bombExplosionTest;

	@Before
	public void create() {
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		bombExplosionTest = new BombExplosion(data, new Point(0, 0));
	}

	@Test
	public void getBoundingBoxTest() {
		assertNotNull(bombExplosionTest.getBoundingBox());
	}
}
