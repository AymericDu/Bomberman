package bomberman.game;

import gameframework.game.GameUniverse;

public class MockConfiguration extends BombermanConfiguration {

	public MockConfiguration(int nbRows, int nbColumns, int spriteSize) {
		super(nbRows, nbColumns, spriteSize);
	}
	
	@Override
	public GameUniverse createUniverse() {
		return new MockUniverse();
	}
}