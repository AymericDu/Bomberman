package bomberman.entity;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class RadiusBonusTest {
	
	GameConfiguration myGameConfiguration;
	GameData data;
	Player playerTest;
	List<Bomb> bombsAvailable;
	String url;
	RadiusBonus radiusBomb;
	
	
	@Before
	public void create(){
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		playerTest = new Player(data, new Point(1, 1));
		bombsAvailable = new ArrayList<Bomb>();
		url = "/images/level/BombermanSprite.png";
		radiusBomb = new RadiusBonus(this.data, playerTest.getPosition(),url,4);
	}
	
	@Test
	public void effectTest() {
		playerTest.bombsAvailable.clear();
		assertTrue(playerTest.bombsAvailable.isEmpty());
		radiusBomb.effect(playerTest);
		assertTrue(!playerTest.bombsAvailable.isEmpty());
		assertEquals(4, playerTest.bombsAvailable.get(0).getRadius());
	}

}
