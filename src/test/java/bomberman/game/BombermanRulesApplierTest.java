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
import bomberman.entity.player.Player;
import bomberman.entity.separation.Box;
import gameframework.game.GameData;
import gameframework.motion.overlapping.OverlapRulesApplierDefaultImpl;

public class BombermanRulesApplierTest extends OverlapRulesApplierDefaultImpl{

	BombermanConfiguration configuration;
	GameData data;
	Player player;
	Flame flame;
	BombermanOverlapRulesApplier bombermanOverlap;
	HorizontalFlame horizontal;
	VerticalFlame vertical;
	CenterFlame center;
	Box box;
	Bomb bomb;
	BombBonus bombBonus;
	BombRadiusBonus bombRadiusBonus;
	DeathBonus deathBonus;
	
	@Before
	public void create(){
		configuration = new BombermanConfiguration(20, 20, 1);
		data = new GameData(configuration);
		player = new Player(data, new Point(1,1), new String("/images/BombermanSpritePlayer1.png"));
		horizontal = new HorizontalFlame(data, new Point(2,1), 2);
		vertical = new VerticalFlame(data, new Point(2,1), 2);
		center = new CenterFlame(data, new Point(2,1));
		bombermanOverlap = configuration.createOverlapRulesApplier();
		box = new Box(data, new Point(1,2));
		bomb =  new Bomb(data, new Point(1,1), 2, player);
		bombBonus = new BombBonus(data, new Point(1,1));
		bombRadiusBonus = new BombRadiusBonus(data, new Point(1,1));
		deathBonus = new DeathBonus(data, new Point(1,1));
	}
	
	@Test
	public void overlapRuleTestPlayerVsHorizontalFlame(){
		assertTrue(player.isAlive());
		bombermanOverlap.overlapRule(player, horizontal);
		assertFalse(player.isAlive());
	}

	@Test
	public void overlapRuleTestPlayerVsVerticalFlame(){
		assertTrue(player.isAlive());
		bombermanOverlap.overlapRule(player, vertical);
		assertFalse(player.isAlive());
	}
	
	@Test
	public void overlapRuleTestPlayerVsCenterFlame(){
		assertTrue(player.isAlive());
		bombermanOverlap.overlapRule(player, center);
		assertFalse(player.isAlive());
	}
	
	@Test
	public void overlapRuleTestBoxVsHorizontalFlame(){
		assertFalse(MockUniverse.removeBox);
		bombermanOverlap.overlapRule(horizontal,box);
		//assertTrue(MockUniverse.removeBox);
	}
	
	@Test
	public void overlapRuleTestBoxVsVerticalFlame(){
		assertFalse(MockUniverse.removeBox);
		bombermanOverlap.overlapRule(vertical,box);
		//assertTrue(MockUniverse.removeBox);
	}
	
	@Test
	public void overlapRuleTestPlayerVsBombBonus(){
		assertEquals( 1,player.getAuthorizedBombs());
		bombermanOverlap.overlapRule(player, bombBonus);
		assertEquals( 2,player.getAuthorizedBombs());
	}
	
	@Test
	public void overlapRuleTestPlayerVsBombRadiusBonus(){
		assertEquals( 1,player.getRadius());
		bombermanOverlap.overlapRule(player, bombRadiusBonus);
		assertEquals( 2,player.getRadius());
	}
	
	@Test
	public void overlapRuleTestPlayerVsDeathBonus(){
		assertTrue(player.isAlive());
		bombermanOverlap.overlapRule(player, deathBonus);
		assertFalse(player.isAlive());
	}
}