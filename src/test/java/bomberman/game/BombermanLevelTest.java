package bomberman.game;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import bomberman.entity.player.Player;
import bomberman.game.BombermanConfiguration;
import bomberman.game.BombermanLevel;
import bomberman.game.BombermanMoveStrategy;
import bomberman.game.BombermanUniverseViewPort;
import bomberman.uid.Bomberman;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BombermanLevelTest {

	GameConfiguration configuration;
	GameData data;
	BombermanLevel level;
	Player p;
	BombermanMoveStrategy strategy;

	@Before
	public void create() {
		configuration = new BombermanConfiguration(20, 20, 1);
		data = new GameData(configuration);
		level = new BombermanLevel(data);
		strategy = new BombermanMoveStrategy(1,1,1,1,1);
	}

	@Test
	public void initTest() {
		// check if hashmap occupiedPoints is empty before we use the function
		// init()
		assertTrue(level.occupiedPoints.isEmpty());
		level.init();
		assertSame(new BombermanUniverseViewPort(level.getGameData()).getClass(), level.getGameBoard().getClass());
		assertEquals(new Point(1, 1), level.getPlayer1().getPosition());
		assertEquals(new Point(level.getColumns() - 2, level.getRows() - 2), level.getPlayer2().getPosition());
		assertFalse(level.occupiedPoints.isEmpty());
	}

	@Test
	public void createPlayerTest() {
		p = level.createPlayer(10, 10, strategy, "/images/BombermanSpritePlayer1.png");
		assertEquals(new Point(10, 10), p.getPosition());
	}

	@Test
	public void createPlayerTestException() throws IllegalStateException {
		try {
			level.createPlayer(10, 10, strategy, "/images/BombermanSpritePlayer1.png");
			level.createPlayer(10, 10, strategy, "/images/BombermanSpritePlayer1.png");
			} catch (Exception IllegalStateException) {
			IllegalStateException.getMessage();
		}
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void endTest(){
		level.init();
		assertEquals(0,level.levelNumber);
		assertEquals(0,Bomberman.pointsPlayer1);
		assertEquals(0,Bomberman.pointsPlayer2);
		level.end();
		assertEquals(1,level.levelNumber);
		assertEquals(1,Bomberman.pointsPlayer1);
		assertEquals(1,Bomberman.pointsPlayer2);	
	}
}