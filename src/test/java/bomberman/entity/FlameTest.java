package bomberman.entity;

public class FlameTest extends NoMovableEntityTest {

	@Override
	public Flame createNoMovableEntity() {
		return new Flame(this.data, this.position,"/images/level/flameHorizontal32.png");
	}
}
