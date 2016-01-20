package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;

public class RadiusBonus extends Bonus{

	protected int newRadius;
	
	public RadiusBonus(GameData data, Point position, String urlString,int bonusRadius) {
		super(data,position,urlString);
		this.newRadius=bonusRadius;
	}
	
	@Override
	public void effect(Player player) {
		player.addBonusBomb(new Bomb(data, position, newRadius));
	}

}
