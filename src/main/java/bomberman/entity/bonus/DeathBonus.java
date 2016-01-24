package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

public class DeathBonus extends Bonus {

	public DeathBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/DeathBonus.png");
	}

	@Override
	public void effect(Player player) {
		player.killed();
		super.effect(player);
	}
}

