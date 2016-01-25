package bomberman.entity.explosion;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.NoMovableEntityTest;
import bomberman.entity.player.MockPlayer;
import bomberman.game.MockUniverse;

public class BombTest extends NoMovableEntityTest {

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
}
