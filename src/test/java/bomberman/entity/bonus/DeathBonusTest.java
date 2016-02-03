package bomberman.entity.bonus;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.player.MockPlayer;
import bomberman.entity.player.Player;

public class DeathBonusTest extends BonusTest {

	@Override
	public DeathBonus createEntity() {
		return new DeathBonus(this.data, this.position);
	}

	@Test
	public void effectTest() {
		Bonus bonus = this.createEntity();
		Player player = new MockPlayer(this.data, (Point) this.position.clone());
		assertFalse(MockPlayer.killed);
		bonus.effect(player);
		assertTrue(MockPlayer.killed);
	}
}