package bomberman.uid;

import gameframework.game.GameUniverseDefaultImpl;

public class BombermanUniverse extends GameUniverseDefaultImpl {

	public void removeAllEntities() {
		this.gameEntities.clear();
	}
}
