package bomberman.uid;

import bomberman.game.BombermanConfiguration;
import bomberman.game.BombermanLevel;
import bomberman.game.BombermanSound;
import bomberman.game.BombermanUniverse;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

public class Bomberman extends GameDefaultImpl {
	
	protected static final int NB_ROWS = 21;
	protected static final int NB_COLUMNS = 21;
	protected static final int SPRITE_SIZE = 32;
	
	public static int pointsPlayer1 = 0;
	public static int pointsPlayer2 = 0;
	
/**
 * Constructor of our game Bomberman
 * @param data our GameData
 */
	public Bomberman(GameData data) {
		super(data);
		
		BombermanSound.play("/sounds/GameSound.wav");
		
		((BombermanUniverse) this.data.getUniverse()).createAllWalls();
		
		for (int i = 0; i < 10; i++) {
			this.data.addLevel(new BombermanLevel(data));
		}
		
		GameWindow windows = new GameWindow("Bomberman", data.getCanvas(), data.getConfiguration());
		windows.createGUI();
	}

	public static void main(String[] args) {
		GameConfiguration config = new BombermanConfiguration(Bomberman.NB_ROWS, Bomberman.NB_COLUMNS, Bomberman.SPRITE_SIZE);
		GameData data = new GameData(config);
		Game main = new Bomberman(data);

		main.start();
	}
}