package bomberman.entity.bonus;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.player.Player;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class DeathBonusTest extends BonusTest {

	@Override
	public DeathBonus createEntity() {
		return new DeathBonus(this.data, this.position);
	}
	
	@Test
	public void effectTest() {
		GameConfiguration conf = new GameConfiguration();
		GameData data = new GameData(conf);
		Bonus bonus = this.createEntity();
		Player player = new Player(data, new Point(1,1));
		assertEquals(true, player.isAlive());
		bonus.effect(player);
		assertEquals(false, player.isAlive());
	}
}
