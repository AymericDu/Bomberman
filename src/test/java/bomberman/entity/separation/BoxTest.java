package bomberman.entity.separation;

import static org.junit.Assert.*;

import org.junit.Test;

import bomberman.entity.UnmovableEntityTest;
import bomberman.game.MockUniverse;

public class BoxTest extends UnmovableEntityTest {

	@Override
	public Box createEntity() {
		return new Box(this.data, this.position);
	}

	@Test
	public void destroyTest() {
		Box box = this.createEntity();
		assertFalse(MockUniverse.removeBox);
		box.destroy();
		assertTrue(MockUniverse.removeBox);
	}
}