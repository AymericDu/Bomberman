package bomberman.entity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import org.junit.Test;

import bomberman.uid.BombermanMoveStrategy;

public class PlayerTest extends EntityTest {

	@Override
	public Player createEntity() {
		return new Player(this.data, this.position);
	}
	
	@Override
	@Test
	public void getBoundingBoxTest() {
		Entity entity = this.createEntity();
		Rectangle rectangle = entity.getBoundingBox();
		assertEquals(20, rectangle.getWidth(), 0);
		assertEquals(20, rectangle.getHeight(), 0);
		assertEquals(this.position, rectangle.getLocation());
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
	public void dropBombTest(){
		Player player = this.createEntity();
		assertEquals(1, player.authorizedBombs);
		player.dropBomb();
		assertEquals(0, player.authorizedBombs);
		player.dropBomb();
		assertEquals(0, player.authorizedBombs);
	}
	
	@Test
	public void addBombTest(){
		Player player = this.createEntity();
		assertEquals(1, player.authorizedBombs);
		player.addBomb();
		assertEquals(2, player.authorizedBombs);
	}

	// @Test
	public void killTest() {
		// TODO killTest
	}
}
