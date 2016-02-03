package bomberman.entity.bonus;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.player.MockPlayer;
import bomberman.entity.player.Player;

public class BombBonusTest extends BonusTest {

	@Override
	public BombBonus createEntity() {
		return new BombBonus(this.data, this.position);
	}

	@Test
	public void effectTest() {
		BombBonus bonus = this.createEntity();
		Player player = new MockPlayer(this.data, (Point) this.position.clone());
		assertFalse(MockPlayer.increaseAuthorizedBomb);
		bonus.effect(player);
		assertTrue(MockPlayer.increaseAuthorizedBomb);
	}
}