package bomberman.game;

import java.awt.Point;

import gameframework.game.GameData;

public class ConstructorPoint {
	
	/**
	 * Constructor of ConstructorPoint.
	 */
	private ConstructorPoint() {
	}

	/**
	 * create allows to create a point 
	 * @param data
	 * @param columnNumber 
	 * @param rowNumber
	 * @return a Point
	 */
	public static Point create(GameData data, int columnNumber, int rowNumber) {
		int spriteSize = data.getConfiguration().getSpriteSize();
		return new Point(spriteSize * columnNumber, spriteSize * rowNumber);
	}
}
