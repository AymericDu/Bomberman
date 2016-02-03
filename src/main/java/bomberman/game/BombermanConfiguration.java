package bomberman.game;

import gameframework.game.GameConfiguration;

/**
 * This class represents the configuration of the bomberman's board.
 */
public class BombermanConfiguration extends GameConfiguration {

	public BombermanConfiguration(int nbRows, int nbColumns, int spriteSize) {
		super(nbRows, nbColumns, spriteSize, 1);
	}

	@Override
	public BombermanOverlapRulesApplier createOverlapRulesApplier() {
		return new BombermanOverlapRulesApplier();
	}
}