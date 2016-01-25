package bomberman.uid;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import bomberman.ConstructorPoint;
import bomberman.entity.separation.Wall;
import gameframework.game.GameUniverseDefaultImpl;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;

public class BombermanUniverse extends GameUniverseDefaultImpl {

	protected Set<Point> wallPoints;
	protected MoveBlockerChecker blockerWalls;
	
	public BombermanUniverse() {
		super();
		this.wallPoints = new HashSet<Point>();
		this.blockerWalls = new MoveBlockerCheckerDefaultImpl();
	}

	public MoveBlockerChecker getBlockerWalls() {
		return this.blockerWalls;
	}

	public Set<Point> getOccupiedPoints() {
		return this.wallPoints;
	}

	/**
	 * Creation of all the walls
	 */
	public void createAllWalls() {
		this.createWallsOnEdges();
		this.createWallsOnBoard();
	}
	
	protected void createWall(int columnNumber, int rowNumber) {
		Point point;
		point = ConstructorPoint.create(this.data, rowNumber, columnNumber);
		this.blockerWalls.addMoveBlocker(new Wall(data, point));
		this.wallPoints.add(point);
	}

	protected void createWallsOnEdges() {
		int rows = this.data.getConfiguration().getNbRows();
		int columns = this.data.getConfiguration().getNbColumns();
		for (int x = 0; x < columns; x++) {
			this.createWall(0, x);
			this.createWall(rows - 1, x);
		}
		for (int y = 1; y < rows - 1; y++) {
			this.createWall(y, 0);
			this.createWall(y, columns - 1);
		}
	}

	/**
	 * Creation of on-board walls
	 */
	protected void createWallsOnBoard() {
		int rows = this.data.getConfiguration().getNbRows();
		int columns = this.data.getConfiguration().getNbColumns();
		for (int x = 2; x < columns - 2; x = x + 2) {
			for (int y = 2; y < rows - 2; y = y + 2) {
				createWall(y, x);
			}
		}
	}
}
