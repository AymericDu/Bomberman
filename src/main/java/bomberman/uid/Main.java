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

	protected AudioClip clip;

	public Main(GameData data) {
		super(data);
		URL url = Main.class.getResource("/sounds/GameSound.wav");
		this.clip = Applet.newAudioClip(url);
		this.data.addLevel(new Level(data));
		this.startSong();
		GameWindow windows = new GameWindow("Bomberman", data.getCanvas(), data.getConfiguration());
		windows.createGUI();
	}

	public void startSong() {
		this.clip.play();
	}

	public void stopSong() {
		this.clip.stop();
	}

	public static void main(String[] args) {
		GameConfiguration config = new GameConfiguration(20, 40, 32, 8);
		GameData data = new GameData(config);
		Game main = new Main(data);

		main.start();
	}
}
