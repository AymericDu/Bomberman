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
		assertTrue(playerTest.isMovable());
	}
	
	@Test
	public void getKeyboardTest(){
		assertSame(new MoveStrategyKeyboard(false).getClass(),playerTest.getKeyboard().getClass());
	}
	
	@Test
	public void dropBombTest(){
		playerTest.setAuthorizedBombs(10);
		assertEquals(10 ,playerTest.getAuthorizedBombs());
		playerTest.dropBomb();
		assertEquals(9 ,playerTest.getAuthorizedBombs());
		playerTest.setAuthorizedBombs(0);
		playerTest.dropBomb();
		assertEquals(0 ,playerTest.getAuthorizedBombs());
	}
	
	@Test
	public void addBombTest(){
		playerTest.setAuthorizedBombs(0);
		assertEquals(0 ,playerTest.getAuthorizedBombs());
		playerTest.addBomb();
		assertEquals(1 ,playerTest.getAuthorizedBombs());
	}
	
	@Test
	public void getSpriteManagerTest(){
		playerTest.initSpriteManager();
		assertNotNull(playerTest.getSpriteManager());
	}
}
