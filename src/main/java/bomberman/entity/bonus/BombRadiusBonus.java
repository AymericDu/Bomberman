package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.Player;
import gameframework.game.GameData;

public class BombRadiusBonus extends Bonus {

	public BombRadiusBonus(GameData data, Point position, String urlString) {
		super(data, position, urlString);
	}

	@Override
	public void effect(Player player) {
		player.doubleBombRadius();
	}
}
