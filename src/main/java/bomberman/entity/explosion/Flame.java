package bomberman.entity.explosion;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bomberman.entity.MovableEntity;
import bomberman.game.BombermanLevel;
import gameframework.game.GameData;
import gameframework.motion.MoveStrategyStraightLine;

/**
 * Abstract class which handles all the different flames. A flame kills the
 * players and destroys the boxes.
 */
public abstract class Flame extends MovableEntity implements ActionListener {

	protected Timer timer;

	protected static final int EXPLOSION_TIME = 1000;

	/**
	 * @param shift
	 *            the shift between the position of the explosion and the
	 *            flame's goal
	 */
	public Flame(GameData data, Point position, String imageUrl, int shift) {
		super(data, position, imageUrl);

		this.getDriver().setmoveBlockerChecker(BombermanLevel.walls);
		this.getDriver().setStrategy(new MoveStrategyStraightLine(position, this.createGoal(shift),
				this.data.getConfiguration().getSpriteSize()));

		this.timer = new Timer(Flame.EXPLOSION_TIME, this);
		this.timer.setRepeats(false);
		this.timer.start();
	}

	/**
	 * The action performed after the explosion's time : remove the Flame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.data.getUniverse().removeGameEntity(this);
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// nothing to do
	}

	/**
	 * Return a point representing the flame's goal, which is shifted by shift
	 * from the position of the explosion
	 * 
	 * @param shift
	 *            the shift between the position of the explosion and the
	 *            flame's goal
	 */
	protected abstract Point createGoal(int shift);
}