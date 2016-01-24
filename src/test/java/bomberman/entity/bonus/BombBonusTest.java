package bomberman.entity.bonus;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.player.Player;

import static org.junit.Assert.*;

import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BombBonusTest extends BonusTest {

	@Override
	public BombBonus createEntity() {
		return new BombBonus(this.data, this.position);
	}

	@Test
	public void effectTest() {
		GameConfiguration conf = new GameConfiguration();
		GameData data = new GameData(conf);
		Bonus bonus = this.createEntity();
		Player player = new Player(data, new Point(1,1));
		assertEquals(1, player.getAuthorizedBomb());
		bonus.effect(player);
		assertEquals(2, player.getAuthorizedBomb());
	}
}
