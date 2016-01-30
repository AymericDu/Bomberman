package bomberman.entity;

import java.awt.Point;
import java.awt.Rectangle;
import java.net.URL;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriver;
import gameframework.motion.GameMovableDriverDefaultImpl;

public class BombermanGameMovable extends GameMovable {

	protected GameData data;
	protected GameCanvas canvas;
	protected DrawableImage image;
	protected Point position;
	
	public BombermanGameMovable(){
		this(new GameMovableDriverDefaultImpl());
	}

	public BombermanGameMovable(GameMovableDriver driver){
		moveDriver = driver;
	}
	
	public BombermanGameMovable(GameData data, Point position, String urlString){
		this.data = data;
		this.canvas = data.getCanvas();
		URL url = NoMovableEntity.class.getResource(urlString);
		this.image = new DrawableImage(url, this.canvas);
		this.position = position;
		//this.data.getUniverse().addGameEntity((GameEntity) this);
	}
	
	/**
	 * Give the bounding box of the box
	 * 
	 * @return Rectangle : the bounding box
	 */
	@Override
	public Rectangle getBoundingBox() {
		Rectangle rectangle = new Rectangle(this.image.getWidth(), this.image.getWidth());
		rectangle.setLocation(this.position);
		return rectangle;
	}
	
	@Override
	public void oneStepMoveAddedBehavior() {
		// TODO Auto-generated method stub
		
	}

}
