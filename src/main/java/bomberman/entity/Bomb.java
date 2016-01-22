package bomberman.entity;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.Timer;

import bomberman.uid.Main;
import gameframework.game.GameData;

public class Bomb extends NoMovableEntity implements ActionListener {

	protected Timer timer;
	protected int radius;
	protected AudioClip clip;
	protected Player player;


	public Bomb(GameData data, Point position, int radius,Player player) {
		super(data, (Point) position.clone(), "/images/level/Bomb.png");
		this.radius = radius;
		this.timer = new Timer(2000, this);
		this.timer.setRepeats(false);
		this.timer.start();
		this.player=player;
		URL url = Main.class.getResource("/sounds/ExplosionSound.wav");
		this.clip = Applet.newAudioClip(url);
	}
	

	/**
	 * give the radius of the current bomb
	 * 
	 * @return int : the radius of the bomb
	 */
	public int getRadius() {
		return this.radius;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		startSound();
		flamesCenter();
		flamesUp();
		flamesDown();
		flamesLeft();
		flamesRight();
		this.data.getUniverse().removeGameEntity(this);
		this.player.addBomb();
	}
	
	private void flamesCenter() {
		Point center=new Point((int)this.getPosition().getX(),(int)this.getPosition().getY());
		new Flame(data, center, "/images/level/flameCenter32.png");
		
	}


	public void flamesUp(){
		for(int i=1;i<=radius;i++){
			Point up=new Point((int)this.getPosition().getX(),(int)this.getPosition().getY()-(i*this.data.getConfiguration().getSpriteSize()));
			//if()
			//test if the object on the position isn't a wall
			new Flame(data, up, "/images/level/flameVertical32.png");
		}
	}
	
	public void flamesDown(){
		for(int i=1;i<=radius;i++){
			Point down=new Point((int)this.getPosition().getX(),(int)this.getPosition().getY()+(i*this.data.getConfiguration().getSpriteSize()));
			//if()
			//test if the object on the position isn't a wall
			new Flame(data, down, "/images/level/flameVertical32.png");
		}
	}

	public void flamesLeft(){
		for(int i=1;i<=radius;i++){
			Point left=new Point((int)this.getPosition().getX()-(i*this.data.getConfiguration().getSpriteSize()),(int)this.getPosition().getY());
			//if()
			//test if the object on the position isn't a wall
			new Flame(data, left, "/images/level/flameHorizontal32.png");
		}
	}
	
	public void flamesRight(){
		for(int i=1;i<=radius;i++){
			Point right=new Point((int)this.getPosition().getX()+(i*this.data.getConfiguration().getSpriteSize()),(int)this.getPosition().getY());
			//if()
			//test if the object on the position isn't a wall
			new Flame(data, right, "/images/level/flameHorizontal32.png");
		}
	}
	
	public void startSound(){
		this.clip.play();
	}
	
	public void stopSong() {
		this.clip.stop();
	}
	
}
