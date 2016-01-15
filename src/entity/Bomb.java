package entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

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
	protected Point position;
	protected int radius;

	public Bomb(GameData data, int x, int y, int radius) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.position = new Point(x,y);
		this.radius = radius;
		this.img = new DrawableImage("/images/level1/caisselvl1.gif",this.canvas);
		this.timer = new Timer();
	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getHeight());
		rectangle.setLocation(position.x, position.y);		
		return rectangle;
	}

	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);
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
