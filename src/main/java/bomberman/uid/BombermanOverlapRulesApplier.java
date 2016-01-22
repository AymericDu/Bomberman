package bomberman.uid;

import bomberman.entity.Box;
import bomberman.entity.Flame;
import bomberman.entity.Player;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class BombermanOverlapRulesApplier extends OverlapRulesApplierDefaultImpl {

	public void overlapRule(Player player, Flame flame) {
		player.kill();
	}
	
	public void overlapRule(Box box, Flame flame) {
		box.destroy();
	}
}
