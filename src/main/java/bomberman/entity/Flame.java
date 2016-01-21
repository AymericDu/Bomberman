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

public class Flame extends NoMovableEntity implements ActionListener {

	protected Timer timer;

	public Flame(GameData data, Point position,String imageUrl) {
		super(data, position, imageUrl);
		this.timer = new Timer(1000, this);
		this.timer.setRepeats(false);
		this.timer.start();
		this.data.getUniverse().addGameEntity(this);
		// TODO kill player and destroy box
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO remove the bomb explosion
	}
	

}
