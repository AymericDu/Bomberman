package bomberman.entity;

import static org.junit.Assert.*;

import java.awt.Graphics;
import java.awt.Point;

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

	@Before
	public void create(){
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		playerTest = new Player(data, new Point(4, 4));
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
	
}
