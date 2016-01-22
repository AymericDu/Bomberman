package bomberman.entity;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gameframework.game.GameData;

public class Flame extends NoMovableEntity implements ActionListener {

	protected Timer timer;

	public Flame(GameData data, Point position,String imageUrl) {
		super(data, position, imageUrl);
		this.timer = new Timer(1000, this);
		this.timer.setRepeats(false);
		this.timer.start();
		// TODO kill player and destroy box
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.data.getUniverse().removeGameEntity(this);
		}
	

}
