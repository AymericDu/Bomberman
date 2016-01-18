package bomberman.uid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;

import bomberman.level.Level;
import gameframework.game.Game;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.game.GameDefaultImpl;
import gameframework.gui.GameWindow;

public class Main extends GameDefaultImpl implements KeyListener{

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

	// NOTHING TO DO HERE
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	// NOTHING TO DO HERE
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		char key =  e.getKeyChar();
			if (key == 'm'){
				this.stopSong();
			}
	}
	
	public static void main(String[] args) {
		GameConfiguration config = new GameConfiguration(23, 31, 32, 8);
		GameData data = new GameData(config);
		Game main = new Main(data);

		main.start();
	}

}
