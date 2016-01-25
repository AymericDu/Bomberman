package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

public class BombBonus extends Bonus {

	/**
	 * Constructor of the BombBonus
	 * @param data the game's data
	 * @param position the position of the entity
	 * @param urlString the string representing the path to the entity's image
	 */
	public BombBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/BombBonus.png");
	}
	
	/**
	 * This bonus will increase the number of bomb a player can drop at the same time
	 */
	@Override
	public void effect(Player player) {
		player.increaseAuthorizedBomb();
		super.effect(player);
	}
}
