package bomberman.entity.explosion;

import bomberman.entity.EntityTest;

public class FlameTest extends EntityTest {

	@Override
	public Flame createEntity() {
		return new Flame(this.data, this.position, "/images/explosion/FlameCenter.png");
	}
}
