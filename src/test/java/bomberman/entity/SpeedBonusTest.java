package bomberman.entity;

import java.awt.Point;

import org.junit.Before;
import static org.junit.Assert.*;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class SpeedBonusTest {
	
	GameConfiguration myGameConfiguration;
	GameData data;
	Player player;
	SpeedBonus bonus;
	
	@Before
	public void create(){
		myGameConfiguration = new GameConfiguration(20,20,20,20);
		data = new GameData(myGameConfiguration);
		player = new Player(data, new Point(1,1));
		bonus = new SpeedBonus(data, new Point(1,1), "", 100);
	}
	
	
	public void effectTest(){
		assertEquals(32, player.getSpeedVector());
		bonus.effect(player);
		assertEquals(100, player.getSpeedVector());
	}
}
