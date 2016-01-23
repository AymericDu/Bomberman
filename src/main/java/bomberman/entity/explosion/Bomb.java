package bomberman.entity.explosion;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Timer;

import bomberman.entity.Entity;
import bomberman.entity.Player;
import bomberman.uid.Main;
import gameframework.game.GameData;

public class Bomb extends Entity implements ActionListener {

	protected Timer timer;
	protected int radius;
	protected AudioClip clip;
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
		URL url = Main.class.getResource("/sounds/ExplosionSound.wav");
		this.clip = Applet.newAudioClip(url);
	}

	/**
	 * The action performed when a bomb explode
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		startSound();
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
		Point center = new Point((int) this.getPosition().getX(), (int) this.getPosition().getY());
		new Flame(data, center, "/images/explosion/FlameCenter.png");
	}

	/**
	 * Draw the up image for the flame
	 */
	public void flamesUp() {
		for (int i = 1; i <= radius; i++) {
			Point up = new Point((int) this.getPosition().getX(),
					(int) this.getPosition().getY() - (i * this.data.getConfiguration().getSpriteSize()));
			// if()
			// test if the object on the position isn't a wall
			new Flame(data, up, "/images/explosion/FlameVertical.png");
		}
	}

	/**
	 * Draw the down image for the flame
	 */
	public void flamesDown() {
		for (int i = 1; i <= radius; i++) {
			Point down = new Point((int) this.getPosition().getX(),
					(int) this.getPosition().getY() + (i * this.data.getConfiguration().getSpriteSize()));
			// if()
			// test if the object on the position isn't a wall
			new Flame(data, down, "/images/explosion/FlameVertical.png");
		}
	}

	/**
	 * Draw the left image for the flame
	 */
	public void flamesLeft() {
		for (int i = 1; i <= radius; i++) {
			Point left = new Point((int) this.getPosition().getX() - (i * this.data.getConfiguration().getSpriteSize()),
					(int) this.getPosition().getY());
			// if()
			// test if the object on the position isn't a wall
			new Flame(data, left, "/images/explosion/FlameHorizontal.png");
		}
	}

	/**
	 * Draw the right image for the flame
	 */
	public void flamesRight() {
		for (int i = 1; i <= radius; i++) {
			Point right = new Point(
					(int) this.getPosition().getX() + (i * this.data.getConfiguration().getSpriteSize()),
					(int) this.getPosition().getY());
			// if()
			// test if the object on the position isn't a wall
			new Flame(data, right, "/images/explosion/FlameHorizontal.png");
		}
	}

	/**
	 * Start the song
	 */
	public void startSound() {
		this.clip.play();
	}

	/**
	 * Stop the song
	 */
	public void stopSong() {
		this.clip.stop();
	}
}
