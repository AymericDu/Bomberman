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
	BombermanOverlapRulesApplier b;
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
		player = new Player(data, new Point(1,1));
		horizontal = new HorizontalFlame(data, new Point(2,1), 2);
		vertical = new VerticalFlame(data, new Point(2,1), 2);
		center = new CenterFlame(data, new Point(2,1));
		b = configuration.createOverlapRulesApplier();
		box = new Box(data, new Point(1,2));
		bomb =  new Bomb(data, new Point(1,1), 2, player);
		bombBonus = new BombBonus(data, new Point(1,1));
		bombRadiusBonus = new BombRadiusBonus(data, new Point(1,1));
		deathBonus = new DeathBonus(data, new Point(1,1));
	}
	
	@Test
	public void overlapRuleTestPlayerVsHorizontalFlame(){
		assertTrue(player.isAlive());
		b.overlapRule(player, horizontal);
		assertFalse(player.isAlive());
	}

	@Test
	public void overlapRuleTestPlayerVsVerticalFlame(){
		assertTrue(player.isAlive());
		b.overlapRule(player, vertical);
		assertFalse(player.isAlive());
	}
	
	@Test
	public void overlapRuleTestPlayerVsCenterFlame(){
		assertTrue(player.isAlive());
		b.overlapRule(player, center);
		assertFalse(player.isAlive());
	}
	
	//TODO check if the bomb is exploded or not
	@Test
	public void overlapRuleTestBoxVsHorizontalFlame(){
		assertNotNull(box);
		b.overlapRule(horizontal,box);	
	}
	
}
