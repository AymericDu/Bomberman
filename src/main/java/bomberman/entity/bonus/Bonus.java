package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.Entity;
import bomberman.entity.Player;
import gameframework.game.GameData;

public abstract class Bonus extends Entity {

	public Bonus(GameData data, Point position, String urlString) {
		super(data, position, urlString);
	}

	/**
	 * the bonus' effect
	 */
	public void effect(Player player) {
		this.data.getUniverse().removeGameEntity(this);
	}
}
