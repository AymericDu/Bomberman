package bomberman.uid;

import bomberman.game.BombermanConfiguration;
import bomberman.game.BombermanLevel;
import bomberman.game.BombermanSound;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

/**
 * This class allows two players to play Bomberman
 * Bomberman is the main class of our game
 */
public class Bomberman extends GameDefaultImpl {
	
	protected static final int NB_ROWS = 21;
	protected static final int NB_COLUMNS = 21;
	protected static final int SPRITE_SIZE = 32;
	
	public static int pointsPlayer1 = 0;
	public static int pointsPlayer2 = 0;
	
	public Bomberman(GameData data) {
		super(data);
		BombermanSound.play("/sounds/GameSound.wav", true);
		for (int i = 0; i < 10; i++) {
			this.data.addLevel(new BombermanLevel(data));
		}
		
		GameWindow windows = new GameWindow("Bomberman", data.getCanvas(), data.getConfiguration());
		windows.createGUI();
	}

	/**
	 * launches the game Bomberman
	*/
	public static void main(String[] args) {
		GameConfiguration config = new BombermanConfiguration(Bomberman.NB_ROWS, Bomberman.NB_COLUMNS, Bomberman.SPRITE_SIZE);
		GameData data = new GameData(config);
		Game main = new Bomberman(data);

		main.start();
	}
}