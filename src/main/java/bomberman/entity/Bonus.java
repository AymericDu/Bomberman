package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.overlapping.Overlappable;

public abstract class Bonus implements GameEntity,Overlappable{
	protected GameData data;
	protected Point position;
	protected String url;
	protected GameCanvas canvas;
	protected DrawableImage img;
	
	public Bonus(GameData data, Point position, String urlString) {
		this.data = data;
		this.position=position;
		this.url=urlString;
		this.canvas = data.getCanvas();
		this.img = new DrawableImage(url, this.canvas);
	}
	
	
	/**
	 * the bonus' effect 
	 */
	public abstract void effect(Player player);
	
	public void removeEntity(GameEntity entity){
		//remove an entity (bomb,box,bonus)
		//if we use this to factorize code, this class' name should change
	}
	
	@Override
	public boolean isMovable() {
		return false;
	}

	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);		
	}
	
	@Override
	public Point getPosition() {
		return this.position;
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(this.position);
		return rectangle;
	}

}
