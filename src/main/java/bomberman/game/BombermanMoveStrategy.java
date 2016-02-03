package bomberman.game;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.motion.MoveStrategyConfigurableKeyboard;

/**
 * BombermanMoveStrategy initializes how the user will control his player
 * (bomberman)
 */
public class BombermanMoveStrategy extends MoveStrategyConfigurableKeyboard {

	protected Player player;
	protected int bombKey;

	public BombermanMoveStrategy(int upKey, int rigthKey, int downKey, int leftKey, int bombKey) {
		super(false);
		this.addKeyDirection(upKey, new Point(0, -1));
		this.addKeyDirection(rigthKey, new Point(1, 0));
		this.addKeyDirection(downKey, new Point(0, 1));
		this.addKeyDirection(leftKey, new Point(-1, 0));
		this.bombKey = bombKey;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode == this.bombKey) {
			this.player.dropBomb();
		} else {
			super.keyPressed(keyCode);
		}
	}
}