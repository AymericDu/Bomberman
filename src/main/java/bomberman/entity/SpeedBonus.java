package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.SpeedVector;

	

public class SpeedBonus extends Bonus {
	
		protected int newSpeed;
		
	public SpeedBonus(GameData data, Point position, String urlString,int bonusSpeed) {
		super(data, position, urlString);
		this.newSpeed = bonusSpeed;
	}

	@Override
	public void effect(Player player) {
		//player.setSpeedVector(newSpeed);
		player.getKeyboard().setSpeed(newSpeed);
	}

}
