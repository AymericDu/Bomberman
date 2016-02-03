package bomberman.game;

import bomberman.entity.bonus.BombBonus;
import bomberman.entity.bonus.BombRadiusBonus;
import bomberman.entity.bonus.Bonus;
import bomberman.entity.bonus.DeathBonus;
import bomberman.entity.explosion.Bomb;
import bomberman.entity.explosion.CenterFlame;
import bomberman.entity.explosion.Flame;
import bomberman.entity.explosion.HorizontalFlame;
import bomberman.entity.explosion.VerticalFlame;
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

/**
 * BombermanOverlapRulesApplier is made for knowing the effect of an overlap
 * between two overlappable entities
 */
public class BombermanOverlapRulesApplier extends OverlapRulesApplierDefaultImpl {

	/**
	 * Kill the player when he touches a Flame
	 */
	protected void rule(Player player, Flame flame) {
		player.kill();
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

	/**
	 * Destroy the box when a flame is on it
	 */
	protected void rule(Flame flame, Box box) {
		box.destroy();
	}

	public void overlapRule(HorizontalFlame flame, Box box) {
		this.rule(flame, box);
	}

	public void overlapRule(VerticalFlame flame, Box box) {
		this.rule(flame, box);
	}

	/**
	 * Apply the bonus effect on the player
	 */
	protected void rule(Player player, Bonus bonus) {
		bonus.effect(player);
	}

	public void overlapRule(Player player, BombBonus bonus) {
		this.rule(player, bonus);
	}

	public void overlapRule(Player player, BombRadiusBonus bonus) {
		this.rule(player, bonus);
	}

	public void overlapRule(Player player, DeathBonus bonus) {
		this.rule(player, bonus);
	}

	/**
	 * Make the bomb explode when the flame is on it
	 */
	protected void rule(Flame flame, Bomb bomb) {
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
}