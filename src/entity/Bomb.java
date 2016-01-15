package entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Timer;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class Bomb implements GameEntity,  MoveBlocker, Drawable, ActionListener {

	protected Timer timer;
	protected GameData data;
	protected GameCanvas canvas;
	protected DrawableImage img;
	protected int radius;
	protected Player player;
	URL url = Bomb.class.getResource("/images/level1/Bomb.gif");

	public Bomb(GameData data, int radius, Player p) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.radius = radius;
		this.img = new DrawableImage(url,this.canvas);
		this.timer = new Timer();
		this.player = p;
	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getHeight());
		rectangle.setLocation((int) player.getPosition().getX(), (int) player.getPosition().getY());
		return rectangle;
	}

	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), (int) player.getPosition().getX(),
				(int) player.getPosition().getY());
	}

	@Override
	public boolean isMovable() {
		return false;
	}
	
	public void startTimer(){
		//BombExplosion task = new BombExplosion(this.data, this.radius);
		//timer.schedule(task, 2000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
}
