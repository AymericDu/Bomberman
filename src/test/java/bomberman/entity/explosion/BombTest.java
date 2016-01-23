package bomberman.entity.explosion;

import bomberman.entity.EntityTest;
import bomberman.entity.Player;

public class BombTest extends EntityTest {

	@Override
	public Bomb createEntity() {
		return new Bomb(this.data, this.position, 2, new Player(this.data, this.position));
	}
}
