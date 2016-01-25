package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

public class DeathBonus extends Bonus {

	/**
	 * Constructor of the death bonus
	 * @param data the game's data
	 * @param position the position of the entity
	 * @param urlString the string representing the path to the entity's image
	 */
	public DeathBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/DeathBonus.png");
	}
	
	/**
	 * the bonus will kill whoever pick it(or step on it)
	 */
	@Override
	public void effect(Player player) {
		player.killed();
		super.effect(player);
	}
}

