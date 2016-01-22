package bomberman.entity;

import static org.junit.Assert.assertEquals;

import java.awt.Point;
import java.awt.Rectangle;

import org.junit.Test;

public class FlameTest extends NoMovableEntityTest {
	
	@Override
	public Flame createNoMovableEntity() {
		return new Flame(this.data, this.position,"/images/level/flameCenter32.png");
	}
	
	@Test
	public void getBoundingBoxTest(){
		Flame f = this.createNoMovableEntity();
		Rectangle rectangle = f.getBoundingBox();
		assertEquals(32, rectangle.getWidth(), 1);
		assertEquals(32, rectangle.getHeight(), 1);
		assertEquals(new Point(0,0), rectangle.getLocation());
	}
}
