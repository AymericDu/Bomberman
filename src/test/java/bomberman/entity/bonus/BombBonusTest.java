package bomberman.entity.bonus;

public class BombBonusTest extends BonusTest {

	@Override
	public BombBonus createEntity() {
		return new BombBonus(this.data, this.position);
	}

	// @Test
	public void effectTest() {
		// TODO effectTest
	}
}
