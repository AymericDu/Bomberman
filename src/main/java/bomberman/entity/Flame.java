package bomberman.entity;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gameframework.game.GameData;

public class Flame extends NoMovableEntity implements ActionListener {

	protected Timer timer;

	/**
	 * Constructor of Flame
	 * @param data the GameData
	 * @param position of the flame
	 * @param imageUrl of the flame
	 */
	public Flame(GameData data, Point position,String imageUrl) {
		super(data, position, imageUrl);
		this.timer = new Timer(1000, this);
		this.timer.setRepeats(false);
		this.timer.start();
		this.data.getUniverse().addGameEntity(this);
		// TODO kill player and destroy box
	}
	
	/**
	 * actionPerformed allows to remove the Flame
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.data.getUniverse().removeGameEntity(this);
	}
}
