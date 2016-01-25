package bomberman.game;

import gameframework.game.GameConfiguration;

public class BombermanConfiguration extends GameConfiguration {

	public BombermanConfiguration(int nbRows, int nbColumns, int spriteSize, int nbLives) {
		super(nbRows, nbColumns, spriteSize, nbLives);
	}

	@Override
	public BombermanOverlapRulesApplier createOverlapRulesApplier() {
		return new BombermanOverlapRulesApplier();
	}

	@Override
	public BombermanUniverse createUniverse() {
		return new BombermanUniverse();
	}
}
