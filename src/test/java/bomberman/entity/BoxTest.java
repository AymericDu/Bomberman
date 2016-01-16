package bomberman.entity;

public class BoxTest extends NoMovableEntityTest {

	@Override
	public Box createNoMovableEntity() {
		return new Box(this.data, this.position);
	}
}
