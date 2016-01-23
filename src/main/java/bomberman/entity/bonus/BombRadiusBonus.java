package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.Player;
import gameframework.game.GameData;

public class BombRadiusBonus extends Bonus {

	public BombRadiusBonus(GameData data, Point position) {
		super(data, position, "/images/level/Bomb.png");
		// TODO change image
	}

	@Override
	public void effect(Player player) {
		player.increaseBombRadius();
	}
}
