package bomberman.entity;

public class WallTest extends NoMovableEntityTest {

	@Override
	public Wall createNoMovableEntity() {
		return new Wall(this.data, this.position);
	}
}
