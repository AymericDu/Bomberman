package bomberman.entity;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gameframework.game.GameData;

public class BombExplosion extends NoMovableEntity implements ActionListener {

	protected Timer timer;

	public BombExplosion(GameData data, Point position) {
		super(data, position, "/images/level/Explode.png");
		this.timer = new Timer(1000, this);
		this.timer.setRepeats(false);
		this.timer.start();
		// TODO kill player and destroy box
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO remove the bomb explosion
	}
}
