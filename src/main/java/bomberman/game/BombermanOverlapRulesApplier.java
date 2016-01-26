package bomberman.game;

import bomberman.entity.bonus.BombBonus;
import bomberman.entity.bonus.BombRadiusBonus;
import bomberman.entity.bonus.Bonus;
import bomberman.entity.bonus.DeathBonus;
import bomberman.entity.explosion.CenterFlame;
import bomberman.entity.explosion.Flame;
import bomberman.entity.explosion.HorizontalFlame;
import bomberman.entity.explosion.VerticalFlame;
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class BombermanOverlapRulesApplier extends OverlapRulesApplierDefaultImpl {

	/**
	 * The function rule kills a player when he touches a Flame
	 * @param player
	 * @param flame
	 */
	public void rule(Player player, Flame flame) {
		player.killed();
	}
	
    /**
     * overlapRule calls the function rule with a HorizontalFlame when a player and a horizontal flame are on the same position
     * @param player
     * @param flame a HorizontalFlame
     */
	public void overlapRule(Player player, HorizontalFlame flame) {
		this.rule(player, flame);
	}

	/**
	 * overlapRule calls the function rule with a VerticalFlame when a player and a vertical flame are on the same position
	 * @param player
	 * @param flame a VerticalFlame
	 */
	public void overlapRule(Player player, VerticalFlame flame) {
		this.rule(player, flame);
	}
	
	/**
	 * overlapRule calls the function rule with a centerFlame when a player and a center flame are on the same position
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
	 * overlapRule calls the function rule with an HorizontalFlame when a horizontal flame and a box are on the same position
	 * @param flame an HorizontalFlame
	 * @param box
	 */
	public void overlapRule(HorizontalFlame flame, Box box) {
		this.rule(flame, box);
	}

	/**
	 * overlapRule calls the function rule with a VerticalFlame when a vertical flame and a box are on the same position
	 * @param flame a VerticalFlame
	 * @param box
	 */
	public void overlapRule(VerticalFlame flame, Box box) {
		this.rule(flame, box);
	}

	/**
	 * rule applies a bonus' effect on a player 
	 * @param player
	 * @param bonus
	 */
	public void rule(Player player, Bonus bonus) {
		bonus.effect(player);
	}

	/**
	 * when a player walks on a bomb bonus, this function calls the function rule with the bomb bonus in parameter
	 * @param player
	 * @param bonus a BombBonus
	 */
	public void overlapRule(Player player, BombBonus bonus) {
		this.rule(player, bonus);
	}

	/**
	 * when a player walks on a bomb radius bonus, this function calls the function rule with the bomb radius bonus in parameter
	 * @param player
	 * @param bonus a BombRadiusBonus
	 */
	public void overlapRule(Player player, BombRadiusBonus bonus) {
		this.rule(player, bonus);
	}
	
	/**
	 * when a player walks on a death bonus, this function calls the function rule with the death bonus in parameter
	 * @param player
	 * @param bonus a DeathBonus
	 */
	public void overlapRule(Player player, DeathBonus bonus) {
		this.rule(player, bonus);
	}
}
