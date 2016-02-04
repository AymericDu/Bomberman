package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

/**
 * This class represents the bomb bonus which effect is to give another bomb to
 * the player who picked the bonus.
 */
public class BombBonus extends Bonus {

	public BombBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/BombBonus.png");
	}

	/**
	 * This bonus effect is to increase by one the number of bomb a player can
	 * drop at the same time
	 */
	@Override
	public void effect(Player player) {
		player.increaseAuthorizedBomb();
		super.effect(player);
	}
}