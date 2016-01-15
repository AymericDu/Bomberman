package uid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.gui.GameWindow;

public class Main {

	public Main() {
		GameConfiguration config = new GameConfiguration(40, 40, 0, 1);
		GameCanvasDefaultImpl canvas = new GameCanvasDefaultImpl();
		GameWindow windows = new GameWindow("Bomberman", canvas, config);
		windows.createGUI();
	}

	public static void main(String[] args) throws InterruptedException {
		new Main();
		
		URL url = Main.class.getResource("/sounds/GameSound.wav");
		AudioClip clip = Applet.newAudioClip(url);
		clip.play();
		Thread.sleep(1000);
		clip.stop();
	}
}
