package bomberman.entity;

public class BombExplosionTest extends NoMovableAndBlockerEntityTest {

	@Override
	public BombExplosion createNoMovableEntity() {
		return new BombExplosion(this.data, this.position);
	}
}
