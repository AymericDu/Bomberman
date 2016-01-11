package entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class BombTest {

	protected Bomb b;
	
	public void create(){
		Bomb b = new Bomb(1,1,2);
	}
	
	@Test
	public void test() {
		assertEquals(2, b.getPower());
		//passe pas NullPointerException ??? 
	}

}
