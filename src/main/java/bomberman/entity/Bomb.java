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


	public Bomb(GameData data, Point position, int radius) {
		super(data, (Point) position.clone(), "/images/level/Bomb.png");
		this.radius = radius;
		this.timer = new Timer(2000, this);
		this.timer.setRepeats(false);
		this.timer.start();
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
		flamesUp();
		flamesDown();
		flamesLeft();
		flamesRight();
		System.out.println("test");
	}
	
	public void flamesUp(){
		for(int i=0;i<radius;i++){
			Point up=new Point((int)this.getPosition().getX(),(int)this.getPosition().getY()-(i*this.data.getConfiguration().getSpriteSize()));
			//if()
			//test if the object on the position isn't a wall
			new Flame(data, up, "/images/level/Explode.png");
		}
	}
	
	public void flamesDown(){
		for(int i=0;i<radius;i++){
			Point down=new Point((int)this.getPosition().getX(),(int)this.getPosition().getY()+(i*this.data.getConfiguration().getSpriteSize()));
			//if()
			//test if the object on the position isn't a wall
			new Flame(data, down, "/images/level/Explode.png");
		}
	}

	public void flamesLeft(){
		for(int i=0;i<radius;i++){
			Point left=new Point((int)this.getPosition().getX()-(i*this.data.getConfiguration().getSpriteSize()),(int)this.getPosition().getY());
			//if()
			//test if the object on the position isn't a wall
			new Flame(data, left, "/images/level/Explode.png");
		}
	}
	
	public void flamesRight(){
		for(int i=0;i<radius;i++){
			Point right=new Point((int)this.getPosition().getX()+(i*this.data.getConfiguration().getSpriteSize()),(int)this.getPosition().getY());
			//if()
			//test if the object on the position isn't a wall
			new Flame(data, right, "/images/level/Explode.png");
		}
	}
	
	public void startSound(){
		this.clip.play();
	}
	
	public void stopSong() {
		this.clip.stop();
	}
	
}
