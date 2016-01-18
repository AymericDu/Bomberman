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

public class BombExplosion extends NoMovableEntity implements ActionListener {

	protected Timer timer;
	protected AudioClip clip;
	protected boolean exploded;

	public BombExplosion(GameData data, Point position) {
		super(data, position, "/images/level/Explode.png");
		this.timer = new Timer(1000, this);
		this.timer.setRepeats(false);
		this.timer.start();
		this.exploded = false;
		URL url = Main.class.getResource("/sounds/ExplosionSound.wav");
		this.clip = Applet.newAudioClip(url);
		// TODO kill player and destroy box
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO remove the bomb explosion
		this.exploded = true;
		startSound();
	}
	
	public boolean bombIsExploded(Bomb b){
		if (this.exploded == true){
			return true;
		}
		else 
			return false;
	}
	
	public void startSound(){
		this.clip.play();
	}
	
	public void stopSong() {
		this.clip.stop();
	}
}
