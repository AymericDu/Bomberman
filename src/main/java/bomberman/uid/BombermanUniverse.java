package bomberman.uid;

import gameframework.game.GameEntity;
import gameframework.game.GameUniverseDefaultImpl;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.overlapping.Overlappable;

public class BombermanUniverse extends GameUniverseDefaultImpl {

	public synchronized void removeAllEntities() {
		for (GameEntity gameEntity : this.gameEntities) {
			if (gameEntity instanceof Overlappable) {
				getOverlapProcessor().removeOverlappable((Overlappable) gameEntity);
			}
			if (gameEntity instanceof MoveBlocker) {
				getMoveBlockerChecker().removeMoveBlocker((MoveBlocker) gameEntity);
			}
		}
		this.gameEntities.clear();
	}
}
