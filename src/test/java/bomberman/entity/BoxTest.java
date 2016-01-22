package bomberman.entity;

public class BoxTest extends BlockerEntityTest {

	@Override
	public Box createEntity() {
		return new Box(this.data, this.position);
	}
}
