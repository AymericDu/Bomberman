package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;

public class ExtraBombsBonus extends Bonus{

	
	protected int extraBombs;
	
	
	public ExtraBombsBonus(GameData data, Point position, String urlString,int extraBombsBonus) {
		super(data,position,urlString);
		this.extraBombs=extraBombsBonus;
	}
	
	@Override
	public void effect(Player player) {
		for (int i = 0; i < this.extraBombs; i++) {
			player.addBomb(new Bomb(data, position,2));
		}
	}

}