package bomberman.entity;

public class WallTest extends BlockerEntityTest {

	@Override
	public Wall createEntity() {
		return new Wall(this.data, this.position);
	}
}
