package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

public class BombBonus extends Bonus {

	public BombBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/BombBonus.png");
	}

	@Override
	public void effect(Player player) {
		player.increaseAuthorizedBomb();
		super.effect(player);
	}
}
