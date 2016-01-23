package bomberman.uid;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import bomberman.level.Level;
import gameframework.assets.Sound;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

public class Main extends GameDefaultImpl {

	public Main(GameData data) {
		super(data);
		try {
			Sound sound = new Sound("/sounds/GameSound.wav");
			sound.setLooping(true);
			sound.play();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < 10; i++) {
			this.data.addLevel(new Level(data));
		}
		GameWindow windows = new GameWindow("Bomberman", data.getCanvas(), data.getConfiguration());
		windows.createGUI();
	}

	public static void main(String[] args) {
		GameConfiguration config = new BombermanConfiguration(21, 21, 32, 1);
		GameData data = new GameData(config);
		Game main = new Main(data);

		main.start();
	}
}
