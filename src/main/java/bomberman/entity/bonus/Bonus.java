package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.NoMovableEntity;
import bomberman.entity.player.Player;
import gameframework.game.GameData;

public abstract class Bonus extends NoMovableEntity {

	/**
	 * Constructor of the bonus
	 * @param data the game's data
	 * @param position the position of the entity
	 * @param urlString the string representing the path to the entity's image
	 */
	public Bonus(GameData data, Point position, String urlString) {
		super(data, position, urlString);
	}

	/**
	 * the bonus' effect when picked up(or stepped on)
	 */
	public void effect(Player player) {
		this.data.getUniverse().removeGameEntity(this);
	}
}
