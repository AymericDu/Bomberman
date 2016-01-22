package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.Player;
import gameframework.game.GameData;

public class BombBonus extends Bonus {

	protected int newRadius;
	
	public BombBonus(GameData data, Point position) {
		super(data, position, "/images/level/Bomb.png");
	}
	
	@Override
	public void effect(Player player) {
		player.addBomb();
	}
}
