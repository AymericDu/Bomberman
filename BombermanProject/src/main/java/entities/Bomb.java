package entities;

public class Bomb {

	protected int x;
	protected int y;
	protected int power;

	public Bomb(int x, int y, int power){
	// ou alors un Point p en parametre a voir
	this.x=x;
	this.y=y;
	this.power=power;
	}
	
	public int getPower(){
		return this.power;
	}
}
