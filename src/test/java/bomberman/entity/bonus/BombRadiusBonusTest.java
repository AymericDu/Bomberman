package bomberman.entity.bonus;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.player.MockPlayer;
import bomberman.entity.player.Player;

public class BombRadiusBonusTest extends BonusTest {

	@Override
	public BombRadiusBonus createEntity() {
		return new BombRadiusBonus(this.data, this.position);
	}

	@Test
	public void effectTest() {
		BombRadiusBonus bonus = this.createEntity();
		Player player = new MockPlayer(this.data, (Point) this.position.clone());
		assertFalse(MockPlayer.increaseBombRadius);
		bonus.effect(player);
		assertTrue(MockPlayer.increaseBombRadius);
	}
}