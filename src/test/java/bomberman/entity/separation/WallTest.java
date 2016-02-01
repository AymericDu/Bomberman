package bomberman.entity.separation;

import bomberman.entity.UnmovableEntityTest;

public class WallTest extends UnmovableEntityTest {

	@Override
	public Wall createEntity() {
		return new Wall(this.data, this.position);
	}
}