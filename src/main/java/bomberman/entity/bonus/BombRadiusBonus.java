package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

public class BombRadiusBonus extends Bonus {

	/**
	 * Constructor of the BombRadiusBonus
	 * @param data the game's data
	 * @param position the position of the entity
	 * @param urlString the string representing the path to the entity's image
	 */
	public BombRadiusBonus(GameData data, Point position) {
		super(data, position, "/images/bonus/BombRadiusBonus.png");
	}

	
	/**
	 * this bonus will increase the player's bombs' radius by one, until he dies
	 */
	@Override
	public void effect(Player player) {
		player.increaseBombRadius();
		super.effect(player);
	}
}
