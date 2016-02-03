package bomberman.entity.explosion;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.UnmovableEntityTest;
import bomberman.entity.player.MockPlayer;
import bomberman.game.MockUniverse;

public class BombTest extends UnmovableEntityTest {

	@Override
	public Bomb createEntity() {
		Bomb bomb = new Bomb(this.data, this.position, 2, new MockPlayer(this.data, (Point) this.position.clone()));
		bomb.timer.stop();
		return bomb;
	}

	@Test
	public void explodeTest() {
		Bomb bomb = this.createEntity();
		assertFalse(MockPlayer.increaseAuthorizedBomb);
		bomb.explode();
		assertTrue(MockPlayer.increaseAuthorizedBomb);
	}

	@Test
	public void shouldRemoveBomb() {
		Bomb bomb = this.createEntity();
		assertFalse(MockUniverse.removeBomb);
		bomb.explode();
		assertTrue(MockUniverse.removeBomb);
	}

	@Test
	public void calculatePositionTest() {
		Bomb bomb = new Bomb(this.data, new Point(16, 24), 0, new MockPlayer(this.data, this.position));
		assertEquals(new Point(0, 0), bomb.getPosition());
	}
}