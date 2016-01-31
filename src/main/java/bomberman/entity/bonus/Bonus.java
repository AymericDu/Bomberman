package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.NoMovableEntity;
import bomberman.entity.player.Player;
import gameframework.game.GameData;


/**
 * abstract class which defines all the bonuses.
 */
public abstract class Bonus extends NoMovableEntity {

	public Bonus(GameData data, Point position, String urlString) {
		super(data, position, urlString);
	}

	/**
	 * The bonus effect when picked up (or stepped on)
	 * @param player 
	 * 				: the player which will benefit of the bonus
	 */
	public void effect(Player player) {
		this.data.getUniverse().removeGameEntity(this);
	}
}