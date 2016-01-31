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
 */
public abstract class Flame extends MovableEntity implements ActionListener {

	protected Timer timer;

	protected static final int EXPLOSION_TIME = 1000;

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
	 * The action performed after the explosion's time : remove the Flame
	 * @param e
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
	 * createGoal returns a point representing the flame's expansion 
	 * 
	 * @param moving
	 * 				: the expansion level from the explosion	
	 * @return a Point
	 */
	public abstract Point createGoal(int moving);
}