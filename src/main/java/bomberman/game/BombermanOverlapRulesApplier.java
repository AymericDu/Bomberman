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

public class BombermanOverlapRulesApplier extends OverlapRulesApplierDefaultImpl {

	/**
	 * rule allow to kill a player when a Flame is on him
	 * @param player
	 * @param flame
	 */
	public void rule(Player player, Flame flame) {
		player.killed();
	}
	
    /**
     * overlapRule permit to use the function rule with a HorizontalFlame
     * @param player
     * @param flame a HorizontalFlame
     */
	public void overlapRule(Player player, HorizontalFlame flame) {
		this.rule(player, flame);
	}

	/**
	 * overlapRule permit to use the function rule with a VerticalFlame
	 * @param player
	 * @param flame a VerticalFlame
	 */
	public void overlapRule(Player player, VerticalFlame flame) {
		this.rule(player, flame);
	}

	/**
	 * overlapRule permit to use the function rule with a CenterFlame
	 * @param player
	 * @param flame a CenterFlame
	 */
	public void overlapRule(Player player, CenterFlame flame) {
		this.rule(player, flame);
	}

	/**
	 * rule allows to destroy a box when a flame is on it
	 * @param flame
	 * @param box
	 */
	public void rule(Flame flame, Box box) {
		box.destroy();
	}

	/**
	 * overlapRule permit to use the function rule with an HorizontalFlame
	 * @param flame an HorizontalFlame
	 * @param box
	 */
	public void overlapRule(HorizontalFlame flame, Box box) {
		this.rule(flame, box);
	}

	/**
	 * overlapRule permit to use the function rule with a VerticalFlame
	 * @param flame a VerticalFlame
	 * @param box
	 */
	public void overlapRule(VerticalFlame flame, Box box) {
		this.rule(flame, box);
	}

	/**
	 * overlapRule permit to use the function rule with a CenterFlame
	 * @param flame a CenterFlame
	 * @param box
	 */
	public void overlapRule(CenterFlame flame, Box box) {
		this.rule(flame, box);
	}

	/**
	 * rule allows to explode a bomb when a flame is on it 
	 * @param flame
	 * @param bomb
	 */
	public void rule(Flame flame, Bomb bomb) {
		bomb.explode();
	}

	/**
	 * overlapRule permit to use the function rule with an HorizontalFlame
	 * @param flame an HorizontalFlame
	 * @param bomb
	 */
	public void overlapRule(HorizontalFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}

	/**
	 * overlapRule permit to use the function rule with a VerticalFlame
	 * @param flame a VerticalFlame
	 * @param bomb
	 */
	public void overlapRule(VerticalFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}

	/**
	 * overlapRule permit to use the function rule with a CenterFlame
	 * @param flame a CenterFlame
	 * @param bomb
	 */
	public void overlapRule(CenterFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}

	/**
	 * rule allow to give a bonus to give a bonus to a player 
	 * @param player
	 * @param bonus
	 */
	public void rule(Player player, Bonus bonus) {
		bonus.effect(player);
	}

	/**
	 * overlapRule permit to use the function rule with a BombBonus
	 * @param player
	 * @param bonus a BombBonus
	 */
	public void overlapRule(Player player, BombBonus bonus) {
		this.rule(player, bonus);
	}

	/**
	 * overlapRule permit to use the function rule with a BombRadiusBonus
	 * @param player
	 * @param bonus a BombRadiusBonus
	 */
	public void overlapRule(Player player, BombRadiusBonus bonus) {
		this.rule(player, bonus);
	}
	
	/**
	 * overlapRule permit to use the function rule with a DeathBonus
	 * @param player
	 * @param bonus a DeathBonus
	 */
	public void overlapRule(Player player, DeathBonus bonus) {
		this.rule(player, bonus);
	}
}
