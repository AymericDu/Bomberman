package bomberman.entity.separation;

import bomberman.entity.NoMovableEntityTest;

public class BoxTest extends NoMovableEntityTest {

	@Override
	public Box createEntity() {
		return new Box(this.data, this.position);
	}
}
