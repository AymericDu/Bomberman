package bomberman.entity.player;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.Test;

import bomberman.entity.MovableEntityTest;
import bomberman.game.BombermanMoveStrategy;

public class PlayerTest extends MovableEntityTest {

	@Override
	public Player createEntity() {
		return new Player(this.data, this.position, new String("/images/BombermanSpritePlayer1.png"));
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
	public void dropBombTest() {
		Player player = this.createEntity();
		assertEquals(1, player.authorizedBombs);
		player.dropBomb();
		assertEquals(0, player.authorizedBombs);
		player.dropBomb();
		assertEquals(0, player.authorizedBombs);
	}
	
//	@Test TODO dropBombWhenLockTest
//	public void dropBombWhenLockTest() {
//		Player player = this.createEntity();
//		player.lockAuthorizedBomb.lock();
//		assertEquals(1, player.authorizedBombs);
//		player.dropBomb();
//		assertEquals(1, player.authorizedBombs);
//		player.lockAuthorizedBomb.unlock();
//	}

	@Test
	public void addBombTest() {
		Player player = this.createEntity();
		assertEquals(1, player.authorizedBombs);
		player.increaseAuthorizedBomb();
		assertEquals(2, player.authorizedBombs);
	}
	
//	@Test TODO addBombWhenLockTest
//	public void addBombWhenLockTest() {
//		Player player = this.createEntity();
//		player.lockAuthorizedBomb.lock();
//		assertEquals(1, player.authorizedBombs);
//		player.increaseAuthorizedBomb();
//		assertEquals(1, player.authorizedBombs);
//		player.lockAuthorizedBomb.unlock();
//	}

	@Test
	public void increaseBombRadiusTest(){
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
		player.timer.stop();
		assertFalse(player.isAlive());
	}
	
	@Test
	public void killTestException() throws InterruptedException{
		Player player = this.createEntity();
		Thread.currentThread().interrupt();
		player.kill();
	}

	@Test
	public void speedWithKeyboardTest() {
		Player player = this.createEntity();
		BombermanMoveStrategy keyboard = new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN,
				KeyEvent.VK_LEFT, KeyEvent.VK_SPACE);
		assertEquals(0, player.getDriver().getSpeedVector(player).getSpeed());
		player.setKeyboard(keyboard);
		assertEquals(32, player.getDriver().getSpeedVector(player).getSpeed());
	}
	
	@Test
	public void isAliveTest(){
		Player player = this.createEntity();
		assertTrue(player.isAlive);
		player.kill();
		assertFalse(player.isAlive);
	}
}