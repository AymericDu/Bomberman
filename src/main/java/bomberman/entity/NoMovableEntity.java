package bomberman.entity;

import java.awt.Graphics;
import java.awt.Point;
import java.net.URL;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;

public abstract class NoMovableEntity implements GameEntity {

	protected GameData data;
	protected GameCanvas canvas;
	protected DrawableImage img;
	protected Point position;

	public NoMovableEntity(GameData data, Point position, String urlString) {
		this.data = data;
		this.canvas = data.getCanvas();
		URL url = NoMovableAndBlockerEntity.class.getResource(urlString);
		this.img = new DrawableImage(url, this.canvas);
		this.position = position;
	}

	/**
	 * draw the bomb with the Graphics g, the image and the coordinates of the
	 * bomb.
	 * 
	 * @param g
	 *            : Graphics
	 */
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.position.x, this.position.y);
	}

	/**
	 * return if the bomb is movable or not
	 * 
	 * @return boolean : false
	 */
	@Override
	public boolean isMovable() {
		return false;
	}
	
	public Point getPosition(){
		return this.position;
	}

}
