package uid;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class Wall implements GameEntity, MoveBlocker, Drawable {

	protected DrawableImage img;
	protected GameCanvas canvas;
	protected Point pos;
	
	public Wall(GameData data, int x, int y){
		this.canvas = data.getCanvas();
		this.img = new DrawableImage("/resources/level1/limitelvl1.gif",this.canvas);
		this.pos = new Point(x,y);
	}
		
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(pos.x, pos.y);
		return rectangle;
	}

	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.pos.x, this.pos.y);
	}
	

}
