package bomberman.entity;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategy;
import gameframework.motion.MoveStrategyKeyboard;

public class PlayerTest{

	GameConfiguration myGameConfiguration;
	GameData data;
	Player playerTest;
	
	@Before
	public void create(){
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		playerTest = new Player(data, new Point(1, 1));
		
	}

	@Test
	public void getBoundingBoxTest(){
		assertNotNull(playerTest.getBoundingBox());
	}
	
	@Test
	public void getGameDataTest(){
		assertEquals(data, playerTest.getGameData());
	}
	
	@Test
	public void setDirectionTest(){
		playerTest.setDirection(new Point (3,1));
		assertEquals(new Point(3,1),playerTest.direction);
	}
	
	@Test
	public void getDirection(){
		playerTest.setDirection(new Point (3,1));
		assertEquals(new Point(3,1),playerTest.getDirection());
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
		assertTrue(playerTest.bombsAvailable.isEmpty());
		playerTest.bombsAvailable.add(new Bomb(this.data, playerTest.getPosition(), 2));
		assertNotNull(playerTest.bombsAvailable);
		playerTest.dropBomb();
		assertTrue(playerTest.bombsAvailable.isEmpty());
	}
	
	@Test
	public void addBombTest(){
		playerTest.bombsAvailable.clear();
		assertNotNull(playerTest.bombsAvailable);
		assertTrue(playerTest.bombsAvailable.isEmpty());
		Bomb b = new Bomb(this.data, playerTest.getPosition(), 2);
		playerTest.addBomb(b);
		assertFalse(playerTest.bombsAvailable.isEmpty());
		
	}
	
	@Test
	public void getSpriteManagerTest(){
		playerTest.initSpriteManager();
		assertNotNull(playerTest.getSpriteManager());
	}
	
	
	/*@Test
	public void oneStepMoveAddedBehaviorTest(){
		Point pos = new Point(0,1);
		playerTest.setPosition(pos);
		playerTest.initSpriteManager();
		Point newPoint = new Point(0,1);
		playerTest.setDirection(newPoint);
		playerTest.oneStepMoveAddedBehavior();
		assertEquals(newPoint,playerTest.getDriver().getSpeedVector(playerTest).getDirection());		
		// beug attend le point(0,0) je sais pas pq
	}*/
	
}
