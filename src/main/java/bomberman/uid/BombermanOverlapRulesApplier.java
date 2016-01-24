package bomberman.uid;

import bomberman.entity.bonus.BombBonus;
import bomberman.entity.bonus.BombRadiusBonus;
import bomberman.entity.bonus.Bonus;
import bomberman.entity.explosion.Bomb;
import bomberman.entity.explosion.CenterFlame;
import bomberman.entity.explosion.Flame;
import bomberman.entity.explosion.HorizontalFlame;
import bomberman.entity.explosion.VerticalFlame;
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class BombermanOverlapRulesApplier extends OverlapRulesApplierDefaultImpl {

	public void rule(Player player, Flame flame) {
		player.killed();
	}

	public void overlapRule(Player player, HorizontalFlame flame) {
		this.rule(player, flame);
	}

	public void overlapRule(Player player, VerticalFlame flame) {
		this.rule(player, flame);
	}

	public void overlapRule(Player player, CenterFlame flame) {
		this.rule(player, flame);
	}

	public void rule(Flame flame, Box box) {
		box.destroy();
	}

	public void overlapRule(HorizontalFlame flame, Box box) {
		this.rule(flame, box);
	}

	public void overlapRule(VerticalFlame flame, Box box) {
		this.rule(flame, box);
	}

	public void overlapRule(CenterFlame flame, Box box) {
		this.rule(flame, box);
	}

	public void rule(Flame flame, Bomb bomb) {
		bomb.explode();
	}

	public void overlapRule(HorizontalFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}

	public void overlapRule(VerticalFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}

	public void overlapRule(CenterFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}

	public void rule(Player player, Bonus bonus) {
		bonus.effect(player);
	}

	public void overlapRule(Player player, BombBonus bonus) {
		this.rule(player, bonus);
	}

	public void overlapRule(Player player, BombRadiusBonus bonus) {
		this.rule(player, bonus);
	}
}
