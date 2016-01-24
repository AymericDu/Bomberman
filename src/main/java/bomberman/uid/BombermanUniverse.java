package bomberman.uid;

import java.awt.Point;
import java.util.HashSet;
import java.util.Set;

import bomberman.entity.separation.Wall;
import gameframework.game.GameEntity;
import gameframework.game.GameUniverseDefaultImpl;
import gameframework.motion.blocking.MoveBlocker;
import gameframework.motion.blocking.MoveBlockerChecker;
import gameframework.motion.blocking.MoveBlockerCheckerDefaultImpl;
import gameframework.motion.overlapping.Overlappable;

public class BombermanUniverse extends GameUniverseDefaultImpl {

	protected int rows;
	protected int columns;
	protected Set<Point> wallPoints;
	protected MoveBlockerChecker blockerWalls;

	public synchronized void removeAllEntities() {
		for (GameEntity gameEntity : this.gameEntities) {
			if (gameEntity instanceof Overlappable) {
				getOverlapProcessor().removeOverlappable((Overlappable) gameEntity);
			}
			if (gameEntity instanceof MoveBlocker) {
				getMoveBlockerChecker().removeMoveBlocker((MoveBlocker) gameEntity);
			}
		}
		this.gameEntities.clear();
	}

	/**
	 * createPoint allows to create a new point
	 * 
	 * @param columnNumber
	 *            the number of columns
	 * @param rowNumber
	 *            the number of rows
	 * @return a new Point
	 */
	protected Point createPoint(int columnNumber, int rowNumber) {
		int spriteSize = this.data.getConfiguration().getSpriteSize();
		return new Point(spriteSize * columnNumber, spriteSize * rowNumber);
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
	protected void createWalls() {
		this.rows = this.data.getConfiguration().getNbRows();
		this.columns = this.data.getConfiguration().getNbColumns();
		this.wallPoints = new HashSet<Point>();
		this.blockerWalls = new MoveBlockerCheckerDefaultImpl();
		createLeftAndRightWalls();
		createBottomAndTopWalls();
		createWallsOnBoard();
	}

	/**
	 * Creation of left and right walls
	 */
	protected void createLeftAndRightWalls() {
		Point point;
		for (int y = 0; y < this.rows; y++) {
			for (int x = 0; x < this.columns; x = x + this.columns - 1) {
				point = this.createPoint(x, y);
				this.blockerWalls.addMoveBlocker(new Wall(data, point));
				this.wallPoints.add(point);
			}
		}
	}

	/**
	 * Creation of bottom and top walls
	 */
	protected void createBottomAndTopWalls() {
		Point point;
		for (int x = 1; x < this.columns - 1; x++) {
			for (int y = 0; y < this.rows; y = y + this.rows - 1) {
				point = this.createPoint(x, y);
				this.blockerWalls.addMoveBlocker(new Wall(data, point));
				this.wallPoints.add(point);
			}
		}
	}

	/**
	 * Creation of on-board walls
	 */
	protected void createWallsOnBoard() {
		Point point;
		for (int x = 2; x < columns - 2; x = x + 2) {
			for (int y = 2; y < rows - 2; y = y + 2) {
				point = this.createPoint(x, y);
				this.blockerWalls.addMoveBlocker(new Wall(data, point));
				this.wallPoints.add(point);
			}
		}
	}
}
