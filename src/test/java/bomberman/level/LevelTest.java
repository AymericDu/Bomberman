package bomberman.level;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import bomberman.entity.Player;
import bomberman.uid.BombermanUniverseViewPort;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class LevelTest {

	GameConfiguration configuration;
	GameData data;
	Level level;
	Player p;

	@Before
	public void create() {
		configuration = new GameConfiguration(20, 20, 1, 1);
		data = new GameData(configuration);
		level = new Level(data);
	}

	@Test
	public void initTest(){
		//check if hashmap occupiedPoints is empty before we use the fonction init()
		assertTrue(level.occupiedPoints.isEmpty());
		level.init();
		assertSame(new BombermanUniverseViewPort(level.getGameData()).getClass(), level.getGameBoard().getClass());
		assertEquals(new Point(1,1), level.getPlayer1().getPosition());
		assertEquals(new Point(level.getColumns()-2,level.getRows()-2), level.getPlayer2().getPosition());
		assertFalse(level.occupiedPoints.isEmpty());
	}
	
	@Test
	public void createPlayersTest(){
		p = level.createPlayers(10,10);
		assertEquals(new Point(10,10), p.getPosition());
	}
	
	@Test
	public void createPlayersTestException() throws IllegalStateException{
		try{
		level.createPlayers(10,10);
		level.createPlayers(10,10);
		}
		catch(Exception IllegalStateException ){
			IllegalStateException.getMessage();
		}
	}
}
