package bomberman.game;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import gameframework.assets.Sound;

public class BombermanSound {
	
	private BombermanSound() {}
	
	public static void play(String path, boolean isLooping) {
		try {
			Sound sound = new Sound(path);
			sound.setLooping(isLooping);
			sound.play();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException | IllegalArgumentException e) {
			// path wrong or no sound interface
		}		
	}
}
