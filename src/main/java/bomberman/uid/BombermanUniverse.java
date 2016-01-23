package bomberman.uid;

import gameframework.game.GameUniverseDefaultImpl;

public class BombermanUniverse extends GameUniverseDefaultImpl {

	public synchronized void removeAllEntities() {
		this.gameEntities.clear();
	}
}
