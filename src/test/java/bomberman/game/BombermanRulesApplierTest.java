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
import bomberman.entity.explosion.Flame;
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
	Player mockPlayer;
	Box mockBox;

	Flame flame;
	BombermanOverlapRulesApplier bombermanOverlap;
	HorizontalFlame horizontal;
	VerticalFlame vertical;
	CenterFlame center;
	Bomb bomb;
	BombBonus bombBonus;
	BombRadiusBonus bombRadiusBonus;
	DeathBonus deathBonus;
	
	@Before
	public void create(){
		configuration = new BombermanConfiguration(20, 20, 1);
		data = new GameData(configuration);
		mockPlayer = new MockPlayer(data, new Point(1,1), "/images/BombermanSpritePlayer1.png");
		mockBox = new MockBox(data, new Point(1,2));
		
		
		horizontal = new HorizontalFlame(data, new Point(2,1), 2);
		vertical = new VerticalFlame(data, new Point(2,1), 2);
		center = new CenterFlame(data, new Point(2,1));
		bombermanOverlap = configuration.createOverlapRulesApplier();
		bomb =  new Bomb(data, new Point(1,1), 2, mockPlayer);
		bombBonus = new BombBonus(data, new Point(1,1));
		bombRadiusBonus = new BombRadiusBonus(data, new Point(1,1));
		deathBonus = new DeathBonus(data, new Point(1,1));
		
	}
	
	@Test
	public void overlapRuleTestPlayerVsHorizontalFlame(){
		assertFalse(MockPlayer.killed);
		bombermanOverlap.overlapRule(mockPlayer, horizontal);
		assertTrue(MockPlayer.killed);
	}

	@Test
	public void overlapRuleTestPlayerVsVerticalFlame(){
		assertFalse(MockPlayer.killed);
		bombermanOverlap.overlapRule(mockPlayer, vertical);
		assertTrue(MockPlayer.killed);
	}
	
	@Test
	public void overlapRuleTestPlayerVsCenterFlame(){
		assertFalse(MockPlayer.killed);
		bombermanOverlap.overlapRule(mockPlayer, center);
		assertTrue(MockPlayer.killed);
	}
	
	@Test
	public void overlapRuleTestBoxVsHorizontalFlame(){
		assertFalse(MockBox.destroy);
		bombermanOverlap.overlapRule(horizontal,mockBox);
		assertTrue(MockBox.destroy);
	}
	
	@Test
	public void overlapRuleTestBoxVsVerticalFlame(){
		assertFalse(MockBox.destroy);
		bombermanOverlap.overlapRule(vertical,mockBox);
		assertTrue(MockBox.destroy);
	}
	
	@Test
	public void overlapRuleTestPlayerVsBombBonus(){
		assertFalse(MockPlayer.increaseAuthorizedBomb);
		bombermanOverlap.overlapRule(mockPlayer, bombBonus);
		assertTrue(MockPlayer.increaseAuthorizedBomb);
	}
	
	@Test
	public void overlapRuleTestPlayerVsBombRadiusBonus(){
		assertFalse(MockPlayer.increaseBombRadius);
		bombermanOverlap.overlapRule(mockPlayer, bombRadiusBonus);
		assertTrue(MockPlayer.increaseBombRadius);
	}
	
	@Test
	public void overlapRuleTestPlayerVsDeathBonus(){
		assertFalse(MockPlayer.killed);
		bombermanOverlap.overlapRule(mockPlayer, deathBonus);
		assertTrue(MockPlayer.killed);
	}
}