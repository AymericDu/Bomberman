package bomberman.entity.separation;

import bomberman.entity.NoMovableEntityTest;

public class WallTest extends NoMovableEntityTest {

	@Override
	public Wall createEntity() {
		return new Wall(this.data, this.position);
	}
}
