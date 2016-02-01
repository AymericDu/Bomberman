package bomberman.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BombermanConfigurationTest {

	@Test
	public void createOverlapRulesApplierTest() {
		BombermanConfiguration configuration = new BombermanConfiguration(1, 1, 1);
		assertEquals(BombermanOverlapRulesApplier.class, configuration.createOverlapRulesApplier().getClass());
	}
}