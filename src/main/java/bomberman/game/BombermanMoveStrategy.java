package bomberman.game;

import java.awt.Point;

import bomberman.entity.player.Player;
import gameframework.motion.MoveStrategyConfigurableKeyboard;

/**
 * BombermanMoveStrategy initialize how the player of the game will control their players
 */
public class BombermanMoveStrategy extends MoveStrategyConfigurableKeyboard {

	protected Player player;
	protected int bombKey;

	/**
	 * Constructor of BombermanMoveStrategy
	 * 
	 * @param upKey
	 * 				: upKey represents with which the keyboard key the player will rise
	 * @param rigthKey
	 * 				: rightKey represents with which the keyboard key the player will go on the right side
	 * @param downKey
	 * 				: downKey represents with which the keyboard key the player will go down
	 * @param leftKey
	 * 				: leftKey represents with which the keyboard key the player will go on the right side
	 * @param bombKey
	 * 				: bombKey represents with which the keyboard key the player will drop his bombs
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
	 * setPlayer allows to change the current Player of the move strategy to a new player in parameter
	 * 
	 * @param player
	 * 				: the player 
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * keyPressed allows the player to drop a bomb if the key code in parameter representing the key pressed is equals
	 * to the key code of the bomb
	 * 
	 * @param keyCode 
	 * 				: the key code of the keyboard
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