package bomberman.entity;

public class BoxTest extends NoMovableAndBlockerEntityTest {

	@Override
	public Box createNoMovableEntity() {
		return new Box(this.data, this.position);
	}
}
