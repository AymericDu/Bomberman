package bomberman.game;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import bomberman.entity.bonus.BombBonus;
import bomberman.entity.bonus.BombRadiusBonus;
import bomberman.entity.bonus.DeathBonus;
import bomberman.entity.explosion.Bomb;
import bomberman.entity.explosion.CenterFlame;
import bomberman.entity.explosion.HorizontalFlame;
import bomberman.entity.explosion.MockBomb;
import bomberman.entity.explosion.VerticalFlame;
import bomberman.entity.player.MockPlayer;
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import bomberman.entity.separation.MockBox;
import gameframework.game.GameData;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class BombermanOverlapRulesApplierTest extends OverlapRulesApplierDefaultImpl {

	protected GameData data;
	protected BombermanOverlapRulesApplier bombermanOverlapRules;

	@Before
	public void create() {
		this.data = new GameData(new BombermanConfiguration(20, 20, 1));
		this.bombermanOverlapRules = new BombermanOverlapRulesApplier();
	}

	@Test
	public void overlapRuleWithPlayerVsHorizontalFlameTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		HorizontalFlame flame = new HorizontalFlame(this.data, new Point(0, 0), 0);
		assertFalse(MockPlayer.killed);
		this.bombermanOverlapRules.overlapRule(player, flame);
		assertTrue(MockPlayer.killed);
	}

	@Test
	public void overlapRuleWithPlayerVsVerticalFlameTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		VerticalFlame flame = new VerticalFlame(this.data, new Point(0, 0), 0);
		assertFalse(MockPlayer.killed);
		this.bombermanOverlapRules.overlapRule(player, flame);
		assertTrue(MockPlayer.killed);
	}

	@Test
	public void overlapRuleWithPlayerVsCenterFlameTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		CenterFlame flame = new CenterFlame(this.data, new Point(0, 0));
		assertFalse(MockPlayer.killed);
		this.bombermanOverlapRules.overlapRule(player, flame);
		assertTrue(MockPlayer.killed);
	}

	@Test
	public void overlapRuleWithBoxVsHorizontalFlameTest() {
		Box box = new MockBox(this.data, new Point(0, 0));
		HorizontalFlame flame = new HorizontalFlame(this.data, new Point(0, 0), 0);
		assertFalse(MockBox.destroy);
		this.bombermanOverlapRules.overlapRule(flame, box);
		assertTrue(MockBox.destroy);
	}

	@Test
	public void overlapRuleWithBoxVsVerticalFlameTest() {
		Box box = new MockBox(this.data, new Point(0, 0));
		VerticalFlame flame = new VerticalFlame(this.data, new Point(0, 0), 0);
		assertFalse(MockBox.destroy);
		this.bombermanOverlapRules.overlapRule(flame, box);
		assertTrue(MockBox.destroy);
	}

	@Test
	public void overlapRuleWithPlayerVsBombBonusTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		BombBonus bonus = new BombBonus(this.data, new Point(0, 0));
		assertFalse(MockPlayer.increaseAuthorizedBomb);
		this.bombermanOverlapRules.overlapRule(player, bonus);
		assertTrue(MockPlayer.increaseAuthorizedBomb);
	}

	@Test
	public void overlapRuleWithPlayerVsBombRadiusBonusTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		BombRadiusBonus bonus = new BombRadiusBonus(this.data, new Point(0, 0));
		assertFalse(MockPlayer.increaseBombRadius);
		this.bombermanOverlapRules.overlapRule(player, bonus);
		assertTrue(MockPlayer.increaseBombRadius);
	}

	@Test
	public void overlapRuleWithPlayerVsDeathBonusTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		DeathBonus bonus = new DeathBonus(this.data, new Point(0, 0));
		assertFalse(MockPlayer.killed);
		bombermanOverlapRules.overlapRule(player, bonus);
		assertTrue(MockPlayer.killed);
	}

	@Test
	public void overlapRuleWithHorizontalFlameVsBombTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		Bomb bomb = new MockBomb(this.data, new Point(0, 0), 0, player);
		HorizontalFlame flame = new HorizontalFlame(this.data, new Point(0, 0), 0);
		assertFalse(MockBomb.explode);
		bombermanOverlapRules.overlapRule(flame, bomb);
		assertTrue(MockBomb.explode);
	}

	@Test
	public void overlapRuleWithVerticalFlameVsBombTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		Bomb bomb = new MockBomb(this.data, new Point(0, 0), 0, player);
		VerticalFlame flame = new VerticalFlame(this.data, new Point(0, 0), 0);
		assertFalse(MockBomb.explode);
		bombermanOverlapRules.overlapRule(flame, bomb);
		assertTrue(MockBomb.explode);
	}

	@Test
	public void overlapRuleWithCenterFlameVsBombTest() {
		Player player = new MockPlayer(this.data, new Point(0, 0));
		Bomb bomb = new MockBomb(this.data, new Point(0, 0), 0, player);
		CenterFlame flame = new CenterFlame(this.data, new Point(0, 0));
		assertFalse(MockBomb.explode);
		bombermanOverlapRules.overlapRule(flame, bomb);
		assertTrue(MockBomb.explode);
	}
}