package bomberman.game;

import gameframework.game.GameConfiguration;

public class BombermanConfiguration extends GameConfiguration {

	/**
	 * Constructor of BombermanConfiguration
	 * @param nbRows the number of rows in the game
	 * @param nbColumns the number of columns in the game
	 * @param spriteSize the sprites' size
	 */
	public BombermanConfiguration(int nbRows, int nbColumns, int spriteSize) {
		super(nbRows, nbColumns, spriteSize, 1);
	}

	/**
	 * createOverlapRulesApplier creates a new BombermanOverlapRulesApplier
	 */
	@Override
	public BombermanOverlapRulesApplier createOverlapRulesApplier() {
		return new BombermanOverlapRulesApplier();
	}
}