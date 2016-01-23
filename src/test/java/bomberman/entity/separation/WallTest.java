package bomberman.entity.separation;

import bomberman.entity.BlockerEntityTest;

public class WallTest extends BlockerEntityTest {

	@Override
	public Wall createEntity() {
		return new Wall(this.data, this.position);
	}
}
