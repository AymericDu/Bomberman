package uid;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Component;
import java.net.URL;

import entity.Bomb;
import entity.Box;
import entity.Player;
import gameframework.drawing.BackgroundImage;
import gameframework.drawing.DrawableImage;
import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameWindow;

public class Main {

	URL url = Main.class.getResource("/sounds/GameSound.wav");
	AudioClip clip = Applet.newAudioClip(url);
	
	//private GameData data;
	
	public Main() {
		
		GameConfiguration config = new GameConfiguration(40, 40, 0, 1);
		GameCanvasDefaultImpl canvas = new GameCanvasDefaultImpl();
		GameWindow windows = new GameWindow("Bomberman", canvas, config);
		windows.createGUI();
		this.startSong();
		/*
		Player p = new Player(this.data, 1, 1);
		Bomb b = new Bomb(this.data,50, p);
		b.startTimer();
		*/
	}
	
	public void startSong(){
		clip.play();
	}
	
	public void stopSong(){
		clip.stop();
	}

	public static void main(String[] args) throws InterruptedException {
		new Main();	
		
	}
}
