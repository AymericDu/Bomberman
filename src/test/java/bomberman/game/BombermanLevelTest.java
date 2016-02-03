package bomberman.game;

import static org.junit.Assert.*;

import java.awt.Point;
import java.awt.event.KeyEvent;

import org.junit.Before;
import org.junit.Test;

import bomberman.entity.player.Player;
import bomberman.uid.Bomberman;
import gameframework.game.GameData;

public class BombermanLevelTest {

	protected GameData data;
	protected BombermanLevel level;

	@Before
	public void init() {
		this.data = new GameData(new MockConfiguration(21, 21, 32));
		this.level = new BombermanLevel(this.data);
	}

	@Test
	public void endTest() {
		this.level.displayScore = false;
		this.level.init();
		assertEquals(0, Bomberman.pointsPlayer1);
		assertEquals(0, Bomberman.pointsPlayer2);
		assertTrue(this.data.getUniverse().getGameEntitiesIterator().hasNext());
		this.level.end();
		assertEquals(1, Bomberman.pointsPlayer1);
		assertEquals(1, Bomberman.pointsPlayer2);
		assertFalse(this.data.getUniverse().getGameEntitiesIterator().hasNext());
	}

	@Test
	public void initTest() {
		assertTrue(this.level.occupiedPoints.isEmpty());
		assertNull(this.level.player1);
		assertNull(this.level.player2);
		this.level.init();
		assertFalse(this.level.occupiedPoints.isEmpty());
		assertNotNull(this.level.player1);
		assertNotNull(this.level.player2);
		assertEquals(this.level.createPoint(1, 1), this.level.player1.getPosition());
		assertEquals(this.level.createPoint(this.data.getConfiguration().getNbColumns() - 2,
				this.data.getConfiguration().getNbRows() - 2), this.level.player2.getPosition());
	}

	@Test
	public void createPlayerTest() {
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				this.level.occupiedPoints.contains(this.level.createPoint(0 + i, 0 + j));
			}
		}
		Player player = this.level.createPlayer(0, 0, new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT,
				KeyEvent.VK_DOWN, KeyEvent.VK_LEFT, KeyEvent.VK_SPACE), Player.GREEN_PLAYER);
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				this.level.occupiedPoints.contains(this.level.createPoint(0 + i, 0 + j));
			}
		}
		assertEquals(this.level.createPoint(0, 0), player.getPosition());
	}

	@Test(expected = IllegalStateException.class)
	public void createPlayerTestException() throws IllegalStateException {
		this.level.occupiedPoints.add(new Point(0, 0));
		this.level.createPlayer(0, 0, null, Player.GREEN_PLAYER);
	}

	@Test
	public void createPointTest() {
		Point point;
		point = this.level.createPoint(0, 0);
		assertEquals(new Point(0, 0), point);
		point = this.level.createPoint(1, 1);
		assertEquals(new Point(32, 32), point);
	}

	@Test
	public void createWallTest() {
		assertFalse(this.level.occupiedPoints.contains(this.level.createPoint(0, 0)));
		this.level.createWall(0, 0);
		assertTrue(this.level.occupiedPoints.contains(this.level.createPoint(0, 0)));
	}

	@Test
	public void createAllWallsTest() {
		assertTrue(this.level.occupiedPoints.isEmpty());
		this.level.createAllWalls();
		assertFalse(this.level.occupiedPoints.isEmpty());
	}

	@Test
	public void createWallsOnBoardTest() {
		assertTrue(this.level.occupiedPoints.isEmpty());
		this.level.createWallsOnBoard();
		assertFalse(this.level.occupiedPoints.isEmpty());
	}

	@Test
	public void createWallsOnEdgesTest() {
		assertTrue(this.level.occupiedPoints.isEmpty());
		this.level.createWallsOnEdges();
		assertFalse(this.level.occupiedPoints.isEmpty());
	}

	@Test
	public void spawnBoxTestWithNullProbability() {
		assertTrue(this.level.occupiedPoints.isEmpty());
		this.level.spawnBox(0);
		assertTrue(this.level.occupiedPoints.isEmpty());
	}

	@Test
	public void spawnBoxTestWithSureProbability() {
		assertTrue(this.level.occupiedPoints.isEmpty());
		this.level.spawnBox(100);
		for (int i = 0; i < 21; i++) {
			for (int j = 0; j < 21; j++) {
				assertTrue(this.level.occupiedPoints.contains(this.level.createPoint(i, j)));
			}
		}
	}
}