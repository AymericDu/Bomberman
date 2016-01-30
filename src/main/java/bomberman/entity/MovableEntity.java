package bomberman.entity;

import java.awt.Point;

import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvas;
import gameframework.game.GameData;
import gameframework.motion.GameMovable;
import gameframework.motion.GameMovableDriver;
import gameframework.motion.SpeedVector;

public class MovableEntity extends Entity {

	//protected GameData data;
	//protected GameCanvas canvas;
	//protected DrawableImage image;
	protected GameMovable gameMovable;

	
	public MovableEntity(GameData data, Point position, String urlString) {
		super(data,position,urlString);
		this.gameMovable=new BombermanGameMovable();
		this.data.getUniverse().addGameEntity(this);
	}
	
	/**
	 * isMovable returns true because by definition a MovableEntity can move
	 * @return true
	 */
	@Override
	public boolean isMovable() {
		return true;
	}
	
	public GameMovableDriver getDriver(){
		return this.gameMovable.getDriver();
	}
	
	public void setDriver(GameMovableDriver driver) {
		this.gameMovable.setDriver(driver);
	}
	
	public void setPosition(Point p) {
		this.gameMovable.setPosition(p);
	}
	
	public void setSpeedVector(SpeedVector speedVector) {
		this.gameMovable.setSpeedVector(speedVector);
	}

	public SpeedVector getSpeedVector() {
		return this.gameMovable.getSpeedVector();
	}
	
	public void oneStepMove() {
		this.gameMovable.oneStepMove();
	}
	
	public void oneStepMoveAddedBehavior(){
		this.gameMovable.oneStepMoveAddedBehavior();
	}
	
}
