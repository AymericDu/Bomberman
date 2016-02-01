package bomberman.entity.player;

import java.awt.Point;

import gameframework.game.GameData;

public class MockPlayer extends Player {

	public static boolean increaseAuthorizedBomb;
	public static boolean increaseBombRadius;
	public static boolean killed;

	public MockPlayer(GameData data, Point position) {
		super(data, position, Player.GREEN_PLAYER);
		MockPlayer.increaseAuthorizedBomb = false;
		MockPlayer.increaseBombRadius = false;
		MockPlayer.killed = false;
	}
	
	@Override
	public void increaseAuthorizedBomb() {
		MockPlayer.increaseAuthorizedBomb = true;
	}
	
	@Override
	public void increaseBombRadius() {
		MockPlayer.increaseBombRadius = true;
	}
	
	@Override
	public void kill() {
		MockPlayer.killed = true;
	}
}