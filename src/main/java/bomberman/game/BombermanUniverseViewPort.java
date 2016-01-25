package bomberman.game;

import java.net.URL;

import gameframework.drawing.GameUniverseViewPortDefaultImpl;
import gameframework.game.GameData;

public class BombermanUniverseViewPort extends GameUniverseViewPortDefaultImpl {

	/**
	 * Constructor of BombermanUniverseViewPort
	 * @param data
	 */
	public BombermanUniverseViewPort(GameData data) {
		super(data);
	}

	/**
	 * backgroundImage return the URL of our background 
	 */
	@Override
	protected URL backgroundImage() {
		return backgroundImage("/images/Background.png");
	}
}
