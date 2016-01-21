package bomberman.entity.bonus;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BonusTest {
	GameConfiguration myGameConfiguration;
	GameData data;
	Bonus bonusTest;
	Point position;
	String url;
	
	@Before
	public void create(){
		myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		data = new GameData(myGameConfiguration);
		position = new Point(1,1);
		url = "/images/level/Bomb.png";
		bonusTest = new RadiusBombBonus(data, position, url, 0); 
	}
	
	@Test
	public void isMovableTest() {
		assertFalse(bonusTest.isMovable());
	}

	@Test
	public void getPositionTest(){
		assertEquals(new Point(1,1), bonusTest.getPosition());
	}
	
	@Test
	public void getBoundingBoxTest(){
		Rectangle rectangle = bonusTest.getBoundingBox();
		assertEquals(32, rectangle.getWidth(), 0);
		assertEquals(32, rectangle.getHeight(), 0);
		assertEquals(new Point(1,1), rectangle.getLocation());
	}
	
	@Test
	public void drawTest(){
		// TO DO
	}
}
