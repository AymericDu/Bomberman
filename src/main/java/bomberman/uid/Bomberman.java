package bomberman.uid;

import javax.swing.JOptionPane;

import bomberman.game.BombermanConfiguration;
import bomberman.game.BombermanLevel;
import bomberman.game.BombermanSound;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

/**
 * This class allows two players to play Bomberman. Bomberman is the main class
 * of our game.
 */
public class Bomberman extends GameDefaultImpl {

	protected static final int NB_ROWS = 21;
	protected static final int NB_COLUMNS = 21;
	protected static final int SPRITE_SIZE = 32;
	protected static final int NB_LEVELS = 3;

	public static int pointsPlayer1 = 0;
	public static int pointsPlayer2 = 0;

	public Bomberman(GameData data) {
		super(data);
		BombermanSound.play("/sounds/GameSound.wav", true);
		for (int i = 0; i < NB_LEVELS; i++) {
			this.data.addLevel(new BombermanLevel(data));
		}

		GameWindow windows = new GameWindow("Bomberman", data.getCanvas(), data.getConfiguration());
		windows.createGUI();
	}

	@Override
	public void start() {
		super.start();
		String message;
		if (Bomberman.pointsPlayer1 > Bomberman.pointsPlayer2)
			message = "Player1 wins !";
		else if (Bomberman.pointsPlayer1 < Bomberman.pointsPlayer2)
			message = "Player2 wins !";
		else
			message = "Draw !";
		JOptionPane.showMessageDialog(null, message, "Finished !", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Launch the game Bomberman
	 */
	public static void main(String[] args) {
		GameConfiguration config = new BombermanConfiguration(Bomberman.NB_ROWS, Bomberman.NB_COLUMNS,
				Bomberman.SPRITE_SIZE);
		GameData data = new GameData(config);
		Game main = new Bomberman(data);

		main.start();
	}
}