package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

/**
 * This class represents the Death bonus, bonus which will kill the player when
 * he steps on it
 */
public class DeathBonus extends Bonus {

	public DeathBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/DeathBonus.png");
	}

	/**
	 * The bonus effect is to kill the player picks it
	 */
	@Override
	public void effect(Player player) {
		player.kill();
		super.effect(player);
	}
}