package bomberman.entity;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import bomberman.uid.BombermanMoveStrategy;
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
		Rectangle rectangle = playerTest.getBoundingBox();
		assertEquals(20, rectangle.getWidth(), 0);
		assertEquals(20, rectangle.getHeight(), 0);
		assertEquals(new Point(20,20), rectangle.getLocation());
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
		assertTrue(playerTest.getIsAlive());
		playerTest.kill();
		assertFalse(playerTest.getIsAlive());
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
		playerTest.setKeyboard(new BombermanMoveStrategy(1,1,1,1,1));
		assertSame(new BombermanMoveStrategy(1,1,1,1,1).getClass(),playerTest.getKeyboard().getClass());
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
