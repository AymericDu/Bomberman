package uid;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class BombermanUniverseViewPort extends GameUniverseViewPortDefaultImpl {
	
		public BombermanUniverseViewPort(GameData data) {
			super(data);
		}

		@Override
		protected URL backgroundImage() {
			return backgroundImage("/images/level/Grass.png");
		}
}
