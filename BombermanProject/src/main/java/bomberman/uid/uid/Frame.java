package uid;

import gameframework.drawing.GameCanvasDefaultImpl;
import gameframework.game.GameConfiguration;
import gameframework.game.GameData;
import gameframework.gui.GameWindow;

public class Frame {

	
	 public static void main(String[] args){
		 GameConfiguration config = new GameConfiguration();
		 GameData data = new GameData(config);
		 GameCanvasDefaultImpl canvas = new GameCanvasDefaultImpl();
		 GameWindow windows = new GameWindow("BombermanProject",canvas,config);
		 
		 windows.createGUI();
	 }
	
}
