package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

public class BombRadiusBonus extends Bonus {

	public BombRadiusBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/BombRadiusBonus.png");
	}

	@Override
	public void effect(Player player) {
		player.increaseBombRadius();
		super.effect(player);
	}
}
