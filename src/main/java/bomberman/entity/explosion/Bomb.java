package bomberman.entity.explosion;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import bomberman.entity.UnmovableEntity;
import bomberman.entity.player.Player;
import bomberman.game.BombermanSound;
import gameframework.game.GameData;

/**
 * Class representing the object bomb which is an UnmovableEntity.
 * The bomb,when dropped by a player, explodes after 2 seconds causing the creation of flames in various directions.
 */
public class Bomb extends UnmovableEntity implements ActionListener {

	protected Timer timer;
	protected int radius;
	protected Player player;

	protected static final int COUNTDOWN_TIME = 2000;

	public Bomb(GameData data, Point position, int radius, Player player) {
		super(data, Bomb.calculatePosition(data, position), "/images/explosion/Bomb.png");
		this.radius = radius;
		this.timer = new Timer(Bomb.COUNTDOWN_TIME, this);
		this.timer.setRepeats(false);
		this.timer.start();
		this.player = player;
	}

	/**
	 * The action performed after the countdown : the bomb explodes
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		explode();
	}

	/**
	 * This method launches the explosion's sound and creates flames in every directions (when possible) starting where the bomb was dropped
	 * It also allows the player to drop a new bomb
	 */
	public void explode() {
		this.timer.stop();
		
		BombermanSound.play("/sounds/ExplosionSound.wav", false);
		
		for (int i = -this.radius; i <= this.radius; i++) {
			if (i != 0) {
				new HorizontalFlame(this.data, (Point) this.position.clone(), i);
				new VerticalFlame(this.data, (Point) this.position.clone(), i);
			}
		}
		new CenterFlame(this.data, this.position);
		
		this.data.getUniverse().removeGameEntity(this);
		this.player.increaseAuthorizedBomb();
	}

	protected static Point calculatePosition(GameData data, Point position) {
		int spriteSize = data.getConfiguration().getSpriteSize();
		return new Point(position.x - (position.x % spriteSize), position.y - (position.y % spriteSize));
	}
}