package bomberman.uid;

import bomberman.entity.bonus.BombBonus;
import bomberman.entity.bonus.BombRadiusBonus;
import bomberman.entity.explosion.Bomb;
import bomberman.entity.explosion.Flame;
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class BombermanOverlapRulesApplier extends OverlapRulesApplierDefaultImpl {

	public void overlapRule(Player player, Flame flame) {
		player.killed();
	}

	public void overlapRule(Box box, Flame flame) {
		box.destroy();
	}

	public void overlapRule(Bomb bomb, Flame flame) {
		bomb.explode();
	}

	public void overlapRule(Player player, BombBonus bonus) {
		bonus.effect(player);
	}

	public void overlapRule(Player player, BombRadiusBonus bonus) {
		bonus.effect(player);
	}
}
