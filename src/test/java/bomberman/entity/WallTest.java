package bomberman.entity;

public class WallTest extends NoMovableAndBlockerEntityTest {

	@Override
	public Wall createNoMovableEntity() {
		return new Wall(this.data, this.position);
	}
}
