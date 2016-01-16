package bomberman.entity;

public class BombExplosionTest extends NoMovableEntityTest {

	@Override
	public BombExplosion createNoMovableEntity() {
		return new BombExplosion(this.data, this.position);
	}
}
