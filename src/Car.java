/**
 * @author OOP Gruppe 187
 */
public abstract class Car implements Runnable {

	private Direction dir;
	private int interval;
	private Strategy s;
	private int x;
	private int y;
	private int points;
	private Track t;
	private int moves;

	/**
	 * Constructor with 6 arguments
	 * 
	 * @param ival
	 *            time the car waits between the moves
	 * @param s
	 *            strategy the car uses to move
	 * @param x
	 *            the x coordinate of the car on the track
	 * @param y
	 *            the y coordinate of the car on the track
	 * @param dir
	 *            the direction the car faces
	 * @param t
	 *            the track the car is placed on
	 */
	public Car(int ival, Strategy s, int x, int y, Direction dir, Track t) {
		this.interval = ival;
		this.s = s;
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.points = 0;
		this.t = t;
		this.moves = 0;
	}

	/**
	 * 
	 */
	protected abstract void drive();

	/**
	 * @return the direction the car faces
	 */
	public Direction getdir() {
		return this.dir;
	}

	/**
	 * @return the number of moves the car made
	 */
	public int getmoves() {
		return this.moves;
	}

	/**
	 * @return the points of the car
	 */
	public int getPoints() {
		return this.points;
	}

	/**
	 * @return the Strategy the car uses to move
	 */
	protected Strategy getStrategy() {
		return this.s;
	}

	/**
	 * @return the track on which the car is placed
	 */
	protected Track getTrack() {
		return this.t;
	}

	/**
	 * @return the x coordinate of the car
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * @return the y coordinate of the car
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * increments the move counter by one
	 */
	public void incmoves() {
		this.moves++;
	}

	/**
	 * notifies the car about a crash
	 * 
	 * @param p
	 *            the points the car gets
	 */
	public void notification(int p) {
		this.points += p;

	}

	/**
	 * main method of the car
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(this.interval);
				this.drive();
			}
			catch (InterruptedException e) {
				return;
			}

		}

	}

	/**
	 * sets the direction of the car to dir
	 * 
	 * @param dir
	 *            the new direction
	 */
	public void setdir(Direction dir) {
		this.dir = dir;
	}

	/**
	 * sets the x coordinate of the car to x
	 * 
	 * @param x
	 *            the new x cooridiante
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * sets the y coordinate of the car to y
	 * 
	 * @param y
	 *            the new y coordinate
	 */
	public void setY(int y) {
		this.y = y;
	}

}
