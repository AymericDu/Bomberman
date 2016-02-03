package bomberman.entity.player;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;

import bomberman.entity.MovableEntityTest;
import bomberman.game.BombermanLevel;
import bomberman.game.BombermanMoveStrategy;

public class PlayerTest extends MovableEntityTest {

	@Override
	public Player createEntity() {
		return new Player(this.data, this.position, Player.GREEN_PLAYER, new BombermanLevel(this.data));
	}

	@Test
	public void setKeyboardTest() {
		Player player = this.createEntity();
		BombermanMoveStrategy keyboard = new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN,
				KeyEvent.VK_LEFT, KeyEvent.VK_SPACE);
		assertNull(player.keyboard);
		player.setKeyboard(keyboard);
		assertSame(keyboard, player.keyboard);
	}

	@Test
	public void removeKeyboardTest() {
		Player player = this.createEntity();
		BombermanMoveStrategy keyboard = new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN,
				KeyEvent.VK_LEFT, KeyEvent.VK_SPACE);
		player.setKeyboard(keyboard);
		assertNotNull(player.keyboard);
		player.removeKeyboard();
		assertNull(player.keyboard);
	}

	@Test
	public void dropBombTest() {
		Player player = this.createEntity();
		assertEquals(1, player.authorizedBombs);
		player.dropBomb();
		assertEquals(0, player.authorizedBombs);
		player.dropBomb();
		assertEquals(0, player.authorizedBombs);
	}

	@Test
	public void addBombTest() {
		Player player = this.createEntity();
		assertEquals(1, player.authorizedBombs);
		player.increaseAuthorizedBomb();
		assertEquals(2, player.authorizedBombs);
	}

	@Test
	public void increaseBombRadiusTest() {
		Player player = this.createEntity();
		assertEquals(1, player.bombRadius);
		player.increaseBombRadius();
		assertEquals(2, player.bombRadius);
	}

	@Test
	public void killTest() {
		Player player = this.createEntity();
		assertTrue(player.isAlive());
		player.kill();
		player.getTimer().stop();
		assertFalse(player.isAlive());
	}

	@Test
	public void speedWithKeyboardTest() {
		Player player = this.createEntity();
		BombermanMoveStrategy keyboard = new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN,
				KeyEvent.VK_LEFT, KeyEvent.VK_SPACE);
		assertEquals(0, player.getDriver().getSpeedVector(player).getSpeed());
		player.setKeyboard(keyboard);
		assertEquals(16, player.getDriver().getSpeedVector(player).getSpeed());
	}

	@Test
	public void isAliveTest() {
		Player player = this.createEntity();
		assertTrue(player.isAlive);
		player.kill();
		player.getTimer().stop();
		assertFalse(player.isAlive);
	}
}