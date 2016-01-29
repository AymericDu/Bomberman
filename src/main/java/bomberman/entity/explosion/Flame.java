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
 * Abstract class which handles all the different flames.
 *
 */
public abstract class Flame extends MovableEntity implements ActionListener {

	protected Timer timer;

	protected static final int EXPLOSION_TIME = 1000;

	/**
	 * Constructor of Flame
	 * 
	 * @param data
	 *            the GameData
	 * @param position
	 *            of the flame
	 * @param imageUrl
	 *            of the flame
	 */
	public Flame(GameData data, Point position, String imageUrl, int moving) {
		super(data, position, imageUrl);

		this.getDriver().setmoveBlockerChecker(BombermanLevel.walls);
		this.getDriver().setStrategy(new MoveStrategyStraightLine(position, this.createGoal(moving),
				this.data.getConfiguration().getSpriteSize()));

		this.timer = new Timer(Flame.EXPLOSION_TIME, this);
		this.timer.setRepeats(false);
		this.timer.start();
	}

	/**
	 * actionPerformed allows to remove the Flame
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
	 * createGoal create a Point with an int
	 * @param moving
	 * @return a Point
	 */
	public abstract Point createGoal(int moving);
}
