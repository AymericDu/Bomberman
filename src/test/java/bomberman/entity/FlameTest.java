package bomberman.entity;

public class FlameTest extends EntityTest {

	@Override
	public Flame createEntity() {
		return new Flame(this.data, this.position, "/images/level/flameCenter32.png");
	}
}
