package uid;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class WallTest {
	
	GameConfiguration myGameConfiguration;
	GameData data;
	Wall myWall;
	
	@Before
	public void create(){
		GameConfiguration myGameConfiguration = new GameConfiguration(20, 20, 20, 20);
		GameData data = new GameData(myGameConfiguration);
		Wall myWall = new Wall(data,20,20);
	}
	
	@Test
	public void test(){
	}
}