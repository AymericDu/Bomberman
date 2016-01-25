package bomberman.game;

import gameframework.game.GameConfiguration;

public class BombermanConfiguration extends GameConfiguration {

	/**
	 * Constructor of BombermanConfiguration
	 * @param nbRows
	 * @param nbColumns
	 * @param spriteSize
	 * @param nbLives
	 */
	public BombermanConfiguration(int nbRows, int nbColumns, int spriteSize, int nbLives) {
		super(nbRows, nbColumns, spriteSize, nbLives);
	}

	/**
	 * createOverlapRulesApplier return a new BombermanOverlapRulesApplier
	 */
	@Override
	public BombermanOverlapRulesApplier createOverlapRulesApplier() {
		return new BombermanOverlapRulesApplier();
	}

	/**
	 * BombermanOverlapRulesApplier return a new BombermanUniverse
	 */
	@Override
	public BombermanUniverse createUniverse() {
		return new BombermanUniverse();
	}
}
