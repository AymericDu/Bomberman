package bomberman.uid;

import gameframework.game.GameConfiguration;
import gameframework.motion.overlapping.OverlapRulesApplier;

public class BombermanConfiguration extends GameConfiguration {

	public BombermanConfiguration(int nbRows, int nbColumns, int spriteSize, int nbLives) {
		super(nbRows, nbColumns, spriteSize, nbLives);
	}

	@Override
	public OverlapRulesApplier createOverlapRulesApplier() {
		return new BombermanOverlapRulesApplier();
	}
}
