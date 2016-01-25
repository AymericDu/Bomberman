package bomberman.game;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.motion.MoveStrategyConfigurableKeyboard;

public class BombermanMoveStrategy extends MoveStrategyConfigurableKeyboard {

	protected Player player;
	protected int bombKey;

	/**
	 * Constructor of BombermanMoveStrategy
	 * @param upKey
	 * @param rigthKey
	 * @param downKey
	 * @param leftKey
	 * @param bombKey
	 */
	public BombermanMoveStrategy(int upKey, int rigthKey, int downKey, int leftKey, int bombKey) {
		super(false);
		this.addKeyDirection(upKey, new Point(0, -1));
		this.addKeyDirection(rigthKey, new Point(1, 0));
		this.addKeyDirection(downKey, new Point(0, 1));
		this.addKeyDirection(leftKey, new Point(-1, 0));
		this.bombKey = bombKey;
	}

	/**
	 * setPlayer allows to change Player
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * keyPressed allows to drop a bomb if keycode is equals
	 * to the bombKey else it allow to use super.keyPressed(keyCode);
	 */
	@Override
	protected void keyPressed(int keyCode) {
		if (keyCode == this.bombKey) {
			player.dropBomb();
		} else {
			super.keyPressed(keyCode);
		}
	}
}
