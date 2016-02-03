package bomberman.game;

import bomberman.entity.bonus.Bonus;
import bomberman.entity.explosion.Bomb;
import bomberman.entity.separation.Box;
import gameframework.game.GameData;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverseDefaultImpl;

public class MockUniverse extends GameUniverseDefaultImpl {

	public static boolean removeBonus;
	public static boolean removeBomb;
	public static boolean removeBox;

	public MockUniverse(GameData data) {
		super(data);
		MockUniverse.removeBonus = false;
		MockUniverse.removeBomb = false;
		MockUniverse.removeBox = false;
	}

	@Override
	public void removeGameEntity(GameEntity gameEntity) {
		if (gameEntity instanceof Bonus)
			MockUniverse.removeBonus = true;
		if (gameEntity instanceof Bomb)
			MockUniverse.removeBomb = true;
		if (gameEntity instanceof Box)
			MockUniverse.removeBox = true;
	}
}