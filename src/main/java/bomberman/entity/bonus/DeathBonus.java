package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

/**
 * This class represents the Death bonus, bonus which will kill the player when he steps on it
 */
public class DeathBonus extends Bonus {

	public DeathBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/DeathBonus.png");
	}
	
	/**
	 * the bonus' effect is to kill whoever picks it (or steps on it)
	 * @param player 
	 * 				: the player which will walk on the death bonus
	 */
	@Override
	public void effect(Player player) {
		player.kill();
		super.effect(player);
	}
}