package bomberman.entity.explosion;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Timer;

import bomberman.entity.Entity;
import bomberman.entity.Player;
import gameframework.assets.Sound;
import gameframework.game.GameData;

public class Bomb extends Entity implements ActionListener {

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
		Point center = new Point((int) this.getPosition().getX(), (int) this.getPosition().getY());
		new Flame(data, center, "/images/explosion/FlameCenter.png");
	}

	/**
	 * Draw the up image for the flame
	 */
	public void flamesUp() {
		boolean blocked=false;
		int i=0;
		while(i<radius && !blocked){
			i++;
			Point up = new Point((int) this.getPosition().getX(),
					(int) this.getPosition().getY() - (i * this.data.getConfiguration().getSpriteSize()));
			Flame f=new Flame(data, up, "/images/explosion/FlameVertical.png");
			if (f.isBlocked()){
				this.data.getUniverse().removeGameEntity(f);
				blocked=true;
			}
		}
	}

	/**
	 * Draw the down image for the flame
	 */
	public void flamesDown() {
		boolean blocked=false;
		int i=0;
		while(i<radius && !blocked){
			i++;
			Point down = new Point((int) this.getPosition().getX(),
					(int) this.getPosition().getY() + (i * this.data.getConfiguration().getSpriteSize()));
			Flame f=new Flame(data, down, "/images/explosion/FlameVertical.png");
			if (f.isBlocked()){
				this.data.getUniverse().removeGameEntity(f);
				blocked=true;
			}
		}
	}

	/**
	 * Draw the left image for the flame
	 */
	public void flamesLeft() {
		boolean blocked=false;
		int i=0;
		while(i<radius && !blocked){
			i++;
			Point left = new Point((int) this.getPosition().getX() - (i * this.data.getConfiguration().getSpriteSize()),
					(int) this.getPosition().getY());
			Flame f=new Flame(data, left, "/images/explosion/FlameHorizontal.png");
			if (f.isBlocked()){
				this.data.getUniverse().removeGameEntity(f);
				blocked=true;
			}
		}
	}

	/**
	 * Draw the right image for the flame
	 */
	public void flamesRight() {
		boolean blocked=false;
		int i=0;
		while(i<radius && !blocked){
			i++;
			Point right = new Point(
					(int) this.getPosition().getX() + (i * this.data.getConfiguration().getSpriteSize()),
					(int) this.getPosition().getY());
			Flame f=new Flame(data, right, "/images/explosion/FlameHorizontal.png");
			if (f.isBlocked()){
				this.data.getUniverse().removeGameEntity(f);
				blocked=true;
			}
		}
	}
}
