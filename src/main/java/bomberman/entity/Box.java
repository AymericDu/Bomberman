package bomberman.entity;

import java.awt.Point;

import gameframework.game.GameData;

public class Box extends BlockerEntity {
	
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
