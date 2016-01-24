package bomberman.entity.bonus;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

import bomberman.entity.player.Player;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;

public class BombRadiusBonusTest extends BonusTest {

	@Override
	public BombRadiusBonus createEntity() {
		return new BombRadiusBonus(this.data, this.position);
	}
	
	@Test
	public void effectTest() {
		GameConfiguration conf = new GameConfiguration();
		GameData data = new GameData(conf);
		Bonus bonus = this.createEntity();
		Player player = new Player(data, new Point(1,1));
		assertEquals(1, player.getBombsRadius());
		bonus.effect(player);
		assertEquals(2, player.getBombsRadius());
	}
}
