package entity;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BombTest {

	protected Bomb b;

	public Bomb create() {
		return new Bomb(1, 1, 2);
 
	}

	@Test
	public void test() {
		Bomb b = this.create();
		assertEquals(2, b.getPower());
	}

}
