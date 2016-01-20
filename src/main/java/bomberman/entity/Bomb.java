package bomberman.entity;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import gameframework.game.GameData;

public class Bomb extends NoMovableEntity implements ActionListener {

	protected Timer timer;
	protected int radius;

	public Bomb(GameData data, Point position, int radius) {
		super(data, position, "/images/level/Bomb.png");
		this.radius = radius;
		this.timer = new Timer(2000, this);
		this.timer.setRepeats(false);
		this.timer.start();
	}
	
	/**
	 * Drop a new bomb 
	 * @param position the position where the bomb is dropped
	 * @return a new bomb 
	 */
	public void dropBomb(Point position, Bomb b){
		this.data.getUniverse().addGameEntity(b);
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
		// TODO Auto-generated method stub	
	}

}
