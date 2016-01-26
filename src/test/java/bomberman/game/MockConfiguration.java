package bomberman.game;

public class MockConfiguration extends BombermanConfiguration {

	public MockConfiguration(int nbRows, int nbColumns, int spriteSize) {
		super(nbRows, nbColumns, spriteSize);
	}
	
	@Override
	public BombermanUniverse createUniverse() {
		return new MockUniverse();
	}
}
