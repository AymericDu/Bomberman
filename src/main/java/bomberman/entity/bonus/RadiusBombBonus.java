package bomberman.entity.bonus;

import java.awt.Point;

import bomberman.entity.Player;
import gameframework.game.GameData;

public class RadiusBombBonus extends Bonus {

	protected int newRadius;
	
	public RadiusBombBonus(GameData data, Point position, String urlString,int bonusRadius) {
		super(data,position,urlString);
		this.newRadius=bonusRadius;
	}
	
	@Override
	public void effect(Player player) {
		player.addBomb();
	}
}
