package bomberman.entity.separation;

import bomberman.entity.BlockerEntityTest;

public class BoxTest extends BlockerEntityTest {

	@Override
	public Box createEntity() {
		return new Box(this.data, this.position);
	}
}
