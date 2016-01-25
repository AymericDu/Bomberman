package bomberman.game;

public class MockConfiguration extends BombermanConfiguration {

	public MockConfiguration(int nbRows, int nbColumns, int spriteSize, int nbLives) {
		super(nbRows, nbColumns, spriteSize, nbLives);
	}
	
	@Override
	public BombermanUniverse createUniverse() {
		return new MockUniverse();
	}
}
