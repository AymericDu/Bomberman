package entities;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class PlayerTest {
	
	protected GameConfiguration myGameConfiguration;
	protected GameData data;
	protected Player playerTest;
	
	@Before
	public void create(){
		GameConfiguration myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		GameData data = new GameData(myGameConfiguration);
		Player playerTest = new Player(data,4,4);
	}
	
	@Test
	public void getBoundingBoxTest(){
		assertNotNull(playerTest.getBoundingBox());
	}
}
