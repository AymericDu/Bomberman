package uid;

import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameWindow;

public class Main {

	public Main() {
		GameConfiguration config = new GameConfiguration(40, 40, 0, 1);
		GameCanvasDefaultImpl canvas = new GameCanvasDefaultImpl();
		GameWindow windows = new GameWindow("Bomberman", canvas, config);
		windows.createGUI();
	}

	public static void main(String[] args) {
		new Main();
	}

}
