package bomberman.game;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import bomberman.entity.bonus.BombBonus;
import bomberman.entity.bonus.BombRadiusBonus;
import bomberman.entity.bonus.DeathBonus;
import bomberman.entity.explosion.CenterFlame;
import bomberman.entity.explosion.HorizontalFlame;
import bomberman.entity.explosion.VerticalFlame;
import bomberman.entity.player.MockPlayer;
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import bomberman.entity.separation.MockBox;
import gameframework.game.GameData;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class BombermanRulesApplierTest extends OverlapRulesApplierDefaultImpl{

	BombermanConfiguration configuration;
	GameData data;
	BombermanOverlapRulesApplier bombermanOverlap;
	Player mockPlayer;
	Box mockBox;
	
	@Before
	public void create(){
		configuration = new BombermanConfiguration(20, 20, 1);
		data = new GameData(configuration);
		bombermanOverlap = configuration.createOverlapRulesApplier();		
		mockPlayer = new MockPlayer(data, new Point(1,1), "/images/BombermanSpritePlayer1.png");
		mockBox = new MockBox(data, new Point(1,2));
	}
	
	@Test
	public void overlapRuleTestPlayerVsHorizontalFlame(){
		HorizontalFlame horizontal = new HorizontalFlame(data, new Point(2,1), 2);
		assertFalse(MockPlayer.killed);
		bombermanOverlap.overlapRule(mockPlayer, horizontal);
		assertTrue(MockPlayer.killed);
	}

	@Test
	public void overlapRuleTestPlayerVsVerticalFlame(){
		VerticalFlame vertical = new VerticalFlame(data, new Point(2,1), 2);
		assertFalse(MockPlayer.killed);
		bombermanOverlap.overlapRule(mockPlayer, vertical);
		assertTrue(MockPlayer.killed);
	}
	
	@Test
	public void overlapRuleTestPlayerVsCenterFlame(){
		CenterFlame center = new CenterFlame(data, new Point(2,1));
		assertFalse(MockPlayer.killed);
		bombermanOverlap.overlapRule(mockPlayer, center);
		assertTrue(MockPlayer.killed);
	}
	
	@Test
	public void overlapRuleTestBoxVsHorizontalFlame(){
		HorizontalFlame horizontal = new HorizontalFlame(data, new Point(2,1), 2);
		assertFalse(MockBox.destroy);
		bombermanOverlap.overlapRule(horizontal,mockBox);
		assertTrue(MockBox.destroy);
	}
	
	@Test
	public void overlapRuleTestBoxVsVerticalFlame(){
		VerticalFlame vertical = new VerticalFlame(data, new Point(2,1), 2);
		assertFalse(MockBox.destroy);
		bombermanOverlap.overlapRule(vertical,mockBox);
		assertTrue(MockBox.destroy);
	}
	
	@Test
	public void overlapRuleTestPlayerVsBombBonus(){
		BombBonus bombBonus = new BombBonus(data, new Point(1,1));
		assertFalse(MockPlayer.increaseAuthorizedBomb);
		bombermanOverlap.overlapRule(mockPlayer, bombBonus);
		assertTrue(MockPlayer.increaseAuthorizedBomb);
	}
	
	@Test
	public void overlapRuleTestPlayerVsBombRadiusBonus(){
		BombRadiusBonus bombRadiusBonus = new BombRadiusBonus(data, new Point(1,1));
		assertFalse(MockPlayer.increaseBombRadius);
		bombermanOverlap.overlapRule(mockPlayer, bombRadiusBonus);
		assertTrue(MockPlayer.increaseBombRadius);
	}
	
	@Test
	public void overlapRuleTestPlayerVsDeathBonus(){
		DeathBonus deathBonus = new DeathBonus(data, new Point(1,1));
		assertFalse(MockPlayer.killed);
		bombermanOverlap.overlapRule(mockPlayer, deathBonus);
		assertTrue(MockPlayer.killed);
	}
}