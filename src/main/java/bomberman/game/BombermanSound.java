package bomberman.game;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import gameframework.assets.Sound;

/**
 * BombermanSound allows the game to play a song
 */
public class BombermanSound {

	private BombermanSound() {
	}

	/**
	 * Play a song in the game
	 * 
	 * @param path
	 *            the path to the song
	 * @param isLooping
	 *            choose if the song will loop or not
	 */
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