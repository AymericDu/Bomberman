package bomberman.entity.explosion;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.game.GameData;

public class MockBomb extends Bomb {

	public static boolean explode;

	public MockBomb(GameData data, Point position, int radius, Player player) {
		super(data, position, radius, player);
		this.timer.stop();
		MockBomb.explode = false;
	}

	@Override
	public void explode() {
		MockBomb.explode = true;
	}
}