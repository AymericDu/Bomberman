package bomberman.entity.explosion;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

import bomberman.entity.NoMovableEntity;
import bomberman.entity.player.Player;
import gameframework.assets.Sound;
import gameframework.game.GameData;

public class Bomb extends NoMovableEntity implements ActionListener {

	protected Timer timer;
	protected int radius;
	protected Player player;

	protected static final int COUNTDOWN_TIME = 2000;

	/**
	 * Constructor of the bomb
	 * 
	 * @param data
	 *            : the game data
	 * @param position
	 *            : the position of the bomb
	 * @param radius
	 *            : the radius of the bomb
	 * @param player
	 *            : the player who have the bomb
	 */
	public Bomb(GameData data, Point position, int radius, Player player) {
		super(data, position, "/images/explosion/Bomb.png");
		this.radius = radius;
		this.timer = new Timer(Bomb.COUNTDOWN_TIME, this);
		this.timer.setRepeats(false);
		this.timer.start();
		this.player = player;
	}

	/**
	 * The action performed when a bomb explode
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		explode();
	}

	/**
	 * explode allows to stop the timer and play the song
	 * it explode the bomb else it shows the flame in the game
	 */
	public void explode() {
		this.timer.stop();
		try {
			Sound sound = new Sound("/sounds/ExplosionSound.wav");
			sound.play();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
		}
		for (int i = -this.radius; i <= this.radius; i++) {
				new HorizontalFlame(this.data, (Point) this.position.clone(), i);
				new VerticalFlame(this.data, (Point) this.position.clone(), i);
		}
		new CenterFlame(this.data, this.position);
		this.data.getUniverse().removeGameEntity(this);
		this.player.increaseAuthorizedBomb();
	}
}
