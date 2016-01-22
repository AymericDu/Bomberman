package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;
import gameframework.motion.overlapping.Overlappable;

public class Box extends NoMovableAndBlockerEntity implements Overlappable {
	
	/**
	 * Constructor of Box
	 * @param data the gameData
	 * @param position the position
	 */
	public Box(GameData data, Point position) {
		super(data, position, "/images/level/Box.png");
	}
	
	public void destroy(){
		this.data.getUniverse().removeGameEntity(this);
	}
}
