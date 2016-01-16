package bomberman.entity;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.net.URL;
import java.util.TimerTask;

import gameframework.drawing.Drawable;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.blocking.MoveBlocker;

public class BombExplosion extends TimerTask implements GameEntity, MoveBlocker, Drawable {

	protected GameData data;
	protected GameCanvas canvas;
	protected DrawableImage img;
	protected Player player;

	URL url = BombExplosion.class.getResource("/images/level/Explode.png");

	/**
	 * create a new BombExplosion
	 * 
	 * @param data
	 *            : GameData who contains informations of the game
	 */
	public BombExplosion(GameData data, Player p) {
		this.data = data;
		this.canvas = data.getCanvas();
		this.img = new DrawableImage(url, this.canvas);
		this.player = p;
	}

	/**
	 * give the bounding box of the bomb
	 * 
	 * @return Rectangle : the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.img.getWidth(), this.img.getHeight());
		rectangle.setLocation((int) player.getPosition().getX(), (int) player.getPosition().getY());
		return rectangle;
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
		this.canvas.drawImage(g, this.img.getImage(), (int) player.getPosition().getX(),
				(int) player.getPosition().getY());
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

	/**
	 * remove life to a character, destroy destructibles entity or nothing
	 */
	@Override
	public void run() {
		System.out.println("bonjour je m'appel pierre");
	}

}
