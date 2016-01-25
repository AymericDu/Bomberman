package bomberman.game;

import java.awt.Point;

import gameframework.game.GameData;

public class ConstructorPoint {
	
	private ConstructorPoint() {
	}

	public static Point create(GameData data, int columnNumber, int rowNumber) {
		int spriteSize = data.getConfiguration().getSpriteSize();
		return new Point(spriteSize * columnNumber, spriteSize * rowNumber);
	}
}
