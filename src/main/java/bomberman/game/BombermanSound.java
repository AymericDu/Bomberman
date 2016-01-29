package bomberman.game;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import gameframework.assets.Sound;

public class BombermanSound {
	
	private BombermanSound() {}
	
	public static void play(String path) {
		try {
			Sound sound = new Sound(path);
			sound.setLooping(true);
			sound.play();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | IllegalArgumentException e) {
			// path wrong or no sound interface
		}		
	}
}
