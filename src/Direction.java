/**
 * enum class that has every possible direction a car is able to face
 * 
 * @author OOP Gruppe 187
 */

public enum Direction {
	North, South, East, West;

	/**
	 * inverts the direction
	 * 
	 * @return
	 *         the inverted direction
	 */
	public Direction invert() {
		Direction dir = null;
		switch (this) {
			case West:
				dir = Direction.East;
				break;
			case East:
				dir = Direction.West;
				break;
			case North:
				dir = Direction.South;
				break;
			case South:
				dir = Direction.North;
				break;
		}
		return dir;

	}

	/**
	 * @return the direction on the left
	 */
	public Direction left() {
		Direction dir = null;
		switch (this) {
			case West:
				dir = Direction.South;
				break;
			case East:
				dir = Direction.North;
				break;
			case North:
				dir = Direction.West;
				break;
			case South:
				dir = Direction.East;
				break;
		}
		return dir;
	}

	/**
	 * @return the Direction on the right
	 */
	public Direction right() {
		Direction dir = null;
		switch (this) {
			case West:
				dir = Direction.North;
				break;
			case East:
				dir = Direction.South;
				break;
			case North:
				dir = Direction.East;
				break;
			case South:
				dir = Direction.West;
				break;
		}
		return dir;
	}

	public int toNumber() {
		int num = 0;
		switch (this) {
			case West:
				num = 6;
				break;
			case East:
				num = 2;
				break;
			case North:
				num = 0;
				break;
			case South:
				num = 4;
				break;
		}
		return num;

	}
}
