package bomberman.entity;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class ExtraBombsBonusTest {

	GameConfiguration myGameConfiguration;
	GameData data;
	Player playerTest;
	List<Bomb> bombsAvailable;
	ExtraBombsBonus extraBomb;
	String url;
	
	@Before
	public void create(){
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		playerTest = new Player(data, new Point(1, 1));
		//mettre nouvelle url si besoin, j'en ai pris une juste pour le test
		url = "/images/level/BombermanSprite.png";
		extraBomb = new ExtraBombsBonus(this.data, playerTest.getPosition(),url,3);
	}
	
	@Test
	public void effectTest(){
		playerTest.bombsAvailable.clear();
		assertTrue(playerTest.bombsAvailable.isEmpty());
		extraBomb.effect(playerTest);
		assertTrue(!playerTest.bombsAvailable.isEmpty());
	}
	
	@Test 
	public void isMovableTest(){
		assertFalse(extraBomb.isMovable());
	}
	
	@Test
	public void getPositionTest(){
		assertEquals(new Point(1, 1),extraBomb.getPosition());
	}
	
	@Test
	public void getBoundingBoxTest(){
		assertNotNull(extraBomb.getBoundingBox());
	}
}
