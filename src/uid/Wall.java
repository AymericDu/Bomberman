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

	/**
	 * create a new Wall
	  * @param data : Gamedata contains informations of the game
	 * @param x : int the abscissa of the Wall
	 * @param y : int the ordinate of the Wall
	 * @param radius : int the radius
	 */
	public Wall(GameData data, int x, int y) {
		this.canvas = data.getCanvas();
		Wall.class.getResource("");
		this.img = new DrawableImage("/resources/level1/limitelvl1.gif", this.canvas);
		this.pos = new Point(x, y);
	}

	/**
	 * give the bounding box of the box
	 * @return Rectangle : the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getWidth());
		rectangle.setLocation(pos.x, pos.y);
		return rectangle;
	}

	/**
	 * draw the bomb with the Graphics g, the image and the coordinates of the bomb.
	 * @param g : Graphics
	 */
	@Override
	public void draw(Graphics g) {
		this.canvas.drawImage(g, this.img.getImage(), this.pos.x, this.pos.y);
	}

	/**
	 * return if the bomb is movable or not
	 * @return boolean : false
	 */
	@Override
	public boolean isMovable() {
		// TODO Auto-generated method stub
		return false;
	}
}
