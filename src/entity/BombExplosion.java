package entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.TimerTask;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class BombExplosion extends TimerTask implements GameEntity, MoveBlocker, Drawable {

	protected GameData data;
	protected Point position;
	protected GameCanvas canvas;
	protected DrawableImage img;
	
	public BombExplosion(GameData data){
		this.data = data;
		this.canvas = data.getCanvas();
		this.img = new DrawableImage("/images/level1/explode.gif", this.canvas);
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

	@Override
	public void run() {
		System.out.println("bonjour je m'appel pierre");
	}

}
