package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

/**
 * This class represents the bomb's radius bonus which effect is to increase the
 * player's bombs radius.
 */
public class BombRadiusBonus extends Bonus {

	public BombRadiusBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/BombRadiusBonus.png");
	}

	/**
	 * This bonus effect is to increase the bomb radius of the player by one
	 */
	@Override
	public void effect(Player player) {
		player.increaseBombRadius();
		super.effect(player);
	}
}