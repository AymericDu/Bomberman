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
		super(data, (Point) position.clone(), "/images/explosion/Bomb.png");
		this.radius = radius;
		this.timer = new Timer(2000, this);
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

	public void explode() {
		this.timer.stop();
		try {
			Sound sound = new Sound("/sounds/ExplosionSound.wav");
			sound.play();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			e1.printStackTrace();
		}
		flamesCenter();
		flamesUp();
		flamesDown();
		flamesLeft();
		flamesRight();
		this.data.getUniverse().removeGameEntity(this);
		this.player.increaseAuthorizedBomb();
	}

	/**
	 * Draw the center image for the flame
	 */
	public void flamesCenter() {
		new Flame(data, (Point) this.position.clone(), "/images/explosion/FlameCenter.png", this.position);
	}

	/**
	 * Draw the up image for the flame
	 */
	public void flamesUp() {
		for (int i = 1; i <= this.radius; i++) {
			Point up = new Point(this.getPosition().x,
					this.getPosition().y - (i * this.data.getConfiguration().getSpriteSize()));
			new Flame(data, (Point) this.position.clone(), "/images/explosion/FlameVertical.png", up);
		}
	}

	/**
	 * Draw the down image for the flame
	 */
	public void flamesDown() {
		for (int i = 1; i <= this.radius; i++) {
			Point down = new Point(this.getPosition().x,
					this.getPosition().y + (i * this.data.getConfiguration().getSpriteSize()));
			new Flame(data, (Point) this.position.clone(), "/images/explosion/FlameVertical.png", down);
		}
	}

	/**
	 * Draw the left image for the flame
	 */
	public void flamesLeft() {
		for (int i = 1; i <= this.radius; i++) {
			Point left = new Point(this.getPosition().x - (i * this.data.getConfiguration().getSpriteSize()),
					this.getPosition().y);
			new Flame(data, (Point) this.position.clone(), "/images/explosion/FlameHorizontal.png", left);
		}
	}

	/**
	 * Draw the right image for the flame
	 */
	public void flamesRight() {
		for (int i = 1; i <= this.radius; i++) {
			Point right = new Point(this.getPosition().x + (i * this.data.getConfiguration().getSpriteSize()),
					this.getPosition().y);
			new Flame(data, (Point) this.position.clone(), "/images/explosion/FlameHorizontal.png", right);
		}
	}
}
