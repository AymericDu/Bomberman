package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.Player;
import gameframework.game.GameData;

public class BombBonus extends Bonus {

	protected int newRadius;

	public BombBonus(GameData data, Point position) {
		super(data, position, "/images/level/bombBonus.png");
	}

	@Override
	public void effect(Player player) {
		player.increaseAuthorizedBomb();
		super.effect(player);
	}
}
