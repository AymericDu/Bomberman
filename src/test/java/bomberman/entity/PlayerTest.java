package bomberman.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.awt.event.KeyEvent;

import org.junit.Test;

import bomberman.uid.BombermanMoveStrategy;

public class PlayerTest extends EntityTest {

	@Override
	public Player createEntity() {
		return new Player(this.data, this.position);
	}

	// @Test
	public void oneStepMoveAddedBehaviorTest() {
		// oneStepMoveAddedBehaviorTest
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

	@Test
	public void addBombTest() {
		Player player = this.createEntity();
		assertEquals(1, player.authorizedBombs);
		player.increaseAuthorizedBomb();
		assertEquals(2, player.authorizedBombs);
	}

	@Test
	public void increaseBombRadiusTest(){
		Player player = this.createEntity();
		assertEquals(1,player.bombRadius);
		player.increaseBombRadius();
		assertEquals(2,player.bombRadius);
	}
	
	// @Test
	public void killTest() {
		//Player player = this.createEntity();
	}

	@Test
	public void speedWithKeyboardTest() {
		Player player = this.createEntity();
		BombermanMoveStrategy keyboard = new BombermanMoveStrategy(KeyEvent.VK_UP, KeyEvent.VK_RIGHT, KeyEvent.VK_DOWN,
				KeyEvent.VK_LEFT, KeyEvent.VK_SPACE);
		assertEquals(0, player.getSpeedVector().getSpeed());
		player.setKeyboard(keyboard);
		assertEquals(0, player.getSpeedVector().getSpeed());
	}
}
