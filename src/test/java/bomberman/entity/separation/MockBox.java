package bomberman.entity.separation;

import java.awt.Point;

import gameframework.game.GameData;

public class MockBox extends Box {

	public static boolean destroy;

	public MockBox(GameData data, Point position) {
		super(data, position);
		MockBox.destroy = false;
	}

	@Override
	public void destroy() {
		MockBox.destroy = true;
	}
}