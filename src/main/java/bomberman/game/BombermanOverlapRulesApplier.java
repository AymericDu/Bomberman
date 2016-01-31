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
 * BombermanOverlapRulesApplier is made for knowing the effect of an overlap between two overlappable entities
 */
public class BombermanOverlapRulesApplier extends OverlapRulesApplierDefaultImpl {

	/**
	 * The function rule kills a player when he touches a Flame
	 * 
	 * @param player
	 * 				: a player of the game
	 * @param flame
	 * 				: a flame created by a bomb
	 */
	public void rule(Player player, Flame flame) {
		player.kill();
	}
	
    /**
     * overlapRule calls the function rule with a HorizontalFlame when a player and a horizontal flame are on the same position
     *
     * @param player
	 * 				: a player of the game
	 * @param flame
	 * 				: a HorizontalFlame created by a bomb
	 */ 
	public void overlapRule(Player player, HorizontalFlame flame) {
		this.rule(player, flame);
	}

	/**
	 * overlapRule calls the function rule with a VerticalFlame when a player and a vertical flame are on the same position
	 *
     * @param player
	 * 				: a player of the game
	 * @param flame
	 * 				: a VerticalFlame created by a bomb
	 */ 
	public void overlapRule(Player player, VerticalFlame flame) {
		this.rule(player, flame);
	}
	
	/**
	 * overlapRule calls the function rule with a centerFlame when a player and a center flame are on the same position
	 *
     * @param player
	 * 				: a player of the game
	 * @param flame
	 * 				: a CenterFlame created by a bomb
	 */
	public void overlapRule(Player player, CenterFlame flame) {
		this.rule(player, flame);
	}

	/**
	 * rule allows to destroy a box when a flame is on it
	 * 
	 * @param flame
	 * 				: a flame created by a bomb
	 * @param box
	 * 				: a box presents on game's tray 
	 */
	public void rule(Flame flame, Box box) {
		box.destroy();
	}

	/**
	 * overlapRule calls the function rule with an HorizontalFlame when a horizontal flame and a box are on the same position
	 * 
	 * @param flame
	 * 				: an HorizontalFlame created by a bomb
	 * @param box
	 * 				: a box presents on game's tray 
	 */
	public void overlapRule(HorizontalFlame flame, Box box) {
		this.rule(flame, box);
	}

	/**
	 * overlapRule calls the function rule with a VerticalFlame when a vertical flame and a box are on the same position
	 * 
	 * @param flame
	 * 				: a VerticalFlame created by a bomb
	 * @param box
	 * 				: a box presents on game's tray 
	 */
	public void overlapRule(VerticalFlame flame, Box box) {
		this.rule(flame, box);
	}

	/**
	 * rule applies a bonus' effect on a player 
	 * 
	 * @param player
	 * 	 			: a player of the game
	 * @param bonus
	 * 				: a bonus presents on game's tray
	 */
	public void rule(Player player, Bonus bonus) {
		bonus.effect(player);
	}

	/**
	 * When a player walks on a bomb bonus, this function calls the function rule with the bomb bonus in parameter
	 * 
	 * @param player
	 * 	 			: a player of the game
	 * @param bonus
	 * 				: a BombBonus presents on game's tray
	 */
	public void overlapRule(Player player, BombBonus bonus) {
		this.rule(player, bonus);
	}

	/**
	 * When a player walks on a bomb radius bonus
	 * 
	 * @param player
	 * 	 			: a player of the game
	 * @param bonus
	 * 				: a BombRadiusBonus presents on game's tray
	 */
	public void overlapRule(Player player, BombRadiusBonus bonus) {
		this.rule(player, bonus);
	}
	
	/**
	 * When a player walks on a death bonus
	 * 
	 * @param player
	 * 	 			: a player of the game
	 * @param bonus
	 * 				: a DeathBonus presents on game's tray
	 */
	public void overlapRule(Player player, DeathBonus bonus) {
		this.rule(player, bonus);
	}
	
	/**
	 * This function makes a bomb explode when a flame is on it 
	 * 
	 * @param flame
	 * 				: a Flame created by a bomb
	 * @param bomb
	 * 				: a bomb dropped by a player
	 */
	public void rule(Flame flame, Bomb bomb) {
		bomb.explode();
	}

	/**
	 * overlapRule calls the function rule when a horizontal flame touches a bomb
	 * 
	 * @param flame
	 * 				: an HorizontalFlame created by a bomb
	 * @param bomb
	 * 				: a bomb dropped by a player
	 */
	public void overlapRule(HorizontalFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}

	/**
	 * overlapRule calls the function rule when a vertical flame touches a bomb
	 * 
	 * @param flame
	 * 				: a VerticalFlame created by a bomb
	 * @param bomb
	 * 				: a bomb dropped by a player
	 */
	public void overlapRule(VerticalFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}

	/**
	 * overlapRule calls the function rule when a center flame touches a bomb
	 * 
	 * @param flame
	 * 				: a CenterFlame created by a bomb
	 * @param bomb
	 * 				: a bomb dropped by a player
	 */
	public void overlapRule(CenterFlame flame, Bomb bomb) {
		this.rule(flame, bomb);
	}
}