package entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class Box implements GameEntity, MoveBlocker, Drawable {

	protected GameData data;
	protected Point position;
	protected GameCanvas canvas;
	protected DrawableImage img;

	URL url = Bomb.class.getResource("/images/level1/Box.gif");

	public Box(GameData data, int x, int y) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.position = new Point(x, y);
		this.img = new DrawableImage(url, this.canvas);
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
		// TODO Auto-generated method stub
		return false;
	}

}
