package bomberman.entity.bonus;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.NoMovableEntityTest;
import bomberman.entity.player.MockPlayer;
import bomberman.game.MockUniverse;

public abstract class BonusTest extends NoMovableEntityTest {

	@Override
	public abstract Bonus createEntity();
	
	@Test
	public void shouldRemoveBonus() {
		Bonus bonus = this.createEntity();
		assertFalse(MockUniverse.removeBonus);
		bonus.effect(new MockPlayer(this.data, (Point) this.position.clone(), new String("/images/BombermanSpritePlayer1.png")));
		assertTrue(MockUniverse.removeBonus);
	}
}
