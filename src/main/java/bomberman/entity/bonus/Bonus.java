package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.UnmovableEntity;
import bomberman.entity.player.Player;
import gameframework.game.GameData;

/**
 * This abstract class which defines all the bonuses. The bonus is picked up by
 * the player.
 */
public abstract class Bonus extends UnmovableEntity {

	public Bonus(GameData data, Point position, String urlString) {
		super(data, position, urlString);
	}

	/**
	 * The bonus effect when this bonus is picked up
	 * 
	 * @param player
	 *            the player which will benefit of the bonus
	 */
	public void effect(Player player) {
		this.data.getUniverse().removeGameEntity(this);
	}
}