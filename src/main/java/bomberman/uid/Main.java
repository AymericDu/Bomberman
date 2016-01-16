package bomberman.uid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import bomberman.level.Level;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

public class Main extends GameDefaultImpl {

	URL url = Main.class.getResource("/sounds/GameSound.wav");
	AudioClip clip = Applet.newAudioClip(url);

	public Main(GameData data) {
		super(data);
		this.data.addLevel(new Level(data));
		this.startSong();
	}

	public void startSong() {
		clip.play();
	}

	public void stopSong() {
		clip.stop();
	}

	public static void main(String[] args) {
		GameConfiguration config = new GameConfiguration(20, 40, 32, 8);
		GameData data = new GameData(config);
		Game main = new Main(data);
		GameWindow windows = new GameWindow("Bomberman", data.getCanvas(), config);
		windows.createGUI();

		main.start();
	}
}
