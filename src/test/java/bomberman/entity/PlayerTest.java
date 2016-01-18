package bomberman.entity;

import static org.junit.Assert.*;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyKeyboard;

public class PlayerTest {

	GameConfiguration myGameConfiguration;
	GameData data;
	Player playerTest;
	List<Bomb> bombsAvailable;
	
	@Before
	public void create(){
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		playerTest = new Player(data, new Point(4, 4));
		bombsAvailable = new ArrayList<Bomb>();

	}

	@Test
	public void getBoundingBoxTest(){
		assertNotNull(playerTest.getBoundingBox());
	}
	
	@Test
	public void isAliveTest(){
		assertEquals(true, playerTest.getIsAlive());
		playerTest.kill();
		assertEquals(false, playerTest.getIsAlive());
	}
	
	@Test
	public void getMoveStrategyTest(){
		MoveStrategy strategy = new MoveStrategyKeyboard();
		assertSame(strategy.getClass(),playerTest.getMoveStrategy().getClass());
	}
	
	@Test
	public void isMovableTest(){
		assertEquals(true, playerTest.isMovable());
	}
	
	@Test
	public void dropBombTest(){
		playerTest.dropBomb();
		assertEquals(true, this.bombsAvailable.isEmpty());
		this.bombsAvailable.add(new Bomb(this.data, playerTest.getPosition(), 2));
		assertNotNull(bombsAvailable);
		playerTest.dropBomb();
		assertEquals(false, this.bombsAvailable.isEmpty());
	}
	
	@Test
	public void getSpriteManagerTest(){
		playerTest.initSpriteManager();
		assertNotNull(playerTest.getSpriteManager());
	}
	
	/*
	@Test
	public void cha(){
		Point p = new Point(1,0);
		playerTest.setPosition(p);
		playerTest.initSpriteManager();
		playerTest.changeSpriteDirection();
		assertEquals("right", playerTest.getSpriteManager());
	}*/
}
