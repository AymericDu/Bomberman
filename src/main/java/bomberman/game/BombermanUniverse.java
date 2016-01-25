package bomberman.game;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import bomberman.entity.separation.Wall;
import gameframework.game.GameUniverseDefaultImpl;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;

public class BombermanUniverse extends GameUniverseDefaultImpl {

	protected Set<Point> wallPoints;
	protected MoveBlockerChecker blockerWalls;
	
	/**
	 * Constructor of BombermanUniverse
	 */
	public BombermanUniverse() {
		super();
		this.wallPoints = new HashSet<Point>();
		this.blockerWalls = new MoveBlockerCheckerDefaultImpl();
	}

	/**
	 * getBlockerWalls return all the blockers walls present in the game
	 * @return the getBlockerWalls
	 */
	public MoveBlockerChecker getBlockerWalls() {
		return this.blockerWalls;
	}

	/**
	 * getOccupiedPoints return the occupied Points in the game
	 * @return the occupied Points 
	 */
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
	
	/**
	 * createWall create a new Wall in the position give by his parameters
	 * @param columnNumber
	 * @param rowNumber
	 */
	protected void createWall(int columnNumber, int rowNumber) {
		Point point;
		point = ConstructorPoint.create(this.data, rowNumber, columnNumber);
		this.blockerWalls.addMoveBlocker(new Wall(data, point));
		this.wallPoints.add(point);
	}

	/**
	 * createWallsOnEdges create the walls on the edges
	 */
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
