package bomberman.game;

import gameframework.game.GameConfiguration;

/**
 * This class represents the configuration of the game's board 
 */
public class BombermanConfiguration extends GameConfiguration {

	public BombermanConfiguration(int nbRows, int nbColumns, int spriteSize) {
		super(nbRows, nbColumns, spriteSize, 1);
	}

	/**
	 * createOverlapRulesApplier creates a new BombermanOverlapRulesApplier
	 * 
	 * @return a new overlapRulesApplier
	 */
	@Override
	public BombermanOverlapRulesApplier createOverlapRulesApplier() {
		return new BombermanOverlapRulesApplier();
	}
}