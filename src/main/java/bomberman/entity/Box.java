package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

public class Box extends GameMovable implements GameEntity, Overlappable, MoveBlocker {

	protected GameData data;
	protected GameCanvas canvas;
	protected DrawableImage img;
	
	/**
	 * Constructor of Box
	 * @param data the gameData
	 * @param position the position
	 */
	public Box(GameData data, Point position) {
		this.data = data;
		this.canvas = data.getCanvas();
		URL url = NoMovableAndBlockerEntity.class.getResource("/images/level/Box.png");
		this.img = new DrawableImage(url, this.canvas);
		this.position = position;
		this.data.getUniverse().addGameEntity(this);
	}
	
	public void destroy(){
		this.data.getUniverse().removeGameEntity(this);
	}

	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(this.position);
		return rectangle;
	}

	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);
	}
}
