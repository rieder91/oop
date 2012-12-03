import java.util.ArrayList;
import java.util.Arrays;

/**
 * the Track on which the car is placed
 * 
 * @author OOP Gruppe 187
 */

public class Track {

	private ArrayList<Car> cars;
	private ArrayList<Thread> carThread;
	private int maxx;
	private int maxy;
	private int maxmoves;

	/**
	 * constructor with 3 parameter
	 * 
	 * @param length
	 *            the length of the track
	 * @param height
	 *            the height of the track
	 * @param maxmoves
	 *            the maximum moves one car make bevor the game ends
	 */
	public Track(int length, int height, int maxmoves) {
		this.cars = new ArrayList<Car>();
		this.carThread = new ArrayList<Thread>();
		this.maxx = length;
		this.maxy = height;
		this.maxmoves = maxmoves;
	}

	/**
	 * adds a new car to the track
	 * @param car
	 * 			the new car
	 */
	public void addCar(Car car) {
		this.cars.add(car);
		this.carThread.add(new Thread(car));
	}

	/**
	 * @param c
	 * @param newx
	 * @param newy
	 */
	private void crash(Car c, int newx, int newy) {
		Direction invdir;
		invdir = c.getDir().invert();

		Direction left, right;

		for (Car cc : this.cars) {
			if ((cc.getX() == newx) && (cc.getY() == newy) && (cc != c)) {
				c.notification(1);
				left = cc.getDir().left();
				right = cc.getDir().right();

				if (invdir == cc.getDir()) {
					cc.notification(1);
				}
				if (c.getDir() == cc.getDir()) {
					cc.notification(-1);
				}
				if (c.getDir() == left) {
					cc.notification(-1);
				}
				if (c.getDir() == right) {
					cc.notification(-1);
				}
			}

		}
	}

	/**
	 * moves the car in the given direction
	 * 
	 * @param c
	 *            the car that moves
	 * @param move
	 *            the direction the car wants to move
	 */
	protected void move(Car c, int move) {
		int newx = 0;
		int newy = 0;
		Direction newdir = Direction.North;

		switch (move) {
			case 0:
				newx = c.getX();
				newy = c.getY() + 1;
				newdir = Direction.North;
				break;
			case 1:
				newx = c.getX() + 1;
				newy = c.getY() + 1;
				if (c.getDir() == Direction.North) {
					newdir = Direction.East;
				}
				else {
					newdir = Direction.North;
				}
				break;
			case 2:
				newx = c.getX() + 1;
				newy = c.getY();
				newdir = Direction.East;
				break;
			case 3:
				newx = c.getX() + 1;
				newy = c.getY() - 1;
				if (c.getDir() == Direction.East) {
					newdir = Direction.South;
				}
				else {
					newdir = Direction.East;
				}
				break;
			case 4:
				newx = c.getX();
				newy = c.getY() - 1;
				newdir = Direction.South;
				break;
			case 5:
				newx = c.getX() - 1;
				newy = c.getY() - 1;
				if (c.getDir() == Direction.South) {
					newdir = Direction.West;
				}
				else {
					newdir = Direction.South;
				}
				break;
			case 6:
				newx = c.getX() - 1;
				newy = c.getY();
				newdir = Direction.West;
				break;
			case 7:
				newx = c.getX() - 1;
				newy = c.getY() + 1;
				if (c.getDir() == Direction.West) {
					newdir = Direction.North;
				}
				else {
					newdir = Direction.West;
				}
				break;

		}

		if (!((newx >= 0) && (newx < this.maxx) && (newy >= 0) && (newy < this.maxy))) { return; }

		synchronized (this) {

			c.increaseMoves();
			c.setDir(newdir);
			c.setX(newx);
			c.setY(newy);

			this.crash(c, newx, newy);

			if ((c.getPoints() >= 10) || (c.getMoves() >= this.maxmoves)) {
				this.stop();
			}

		}

	}

	/**
	 * @return the points of every car
	 */
	public String points() {
		StringBuilder s = new StringBuilder();
		Car[] cc = new Car[this.cars.size()];
		cc=this.cars.toArray(cc);
		Arrays.sort(cc);
		s.append("Results ordered by points:\n");
		for (Car c : cc) {
			s.append(c + "\n");
		}
		return s.toString();
	}

	/**
	 * @return the sum off all points
	 */
	public int pointSum() {
		int sum = 0;
		for (Car c : this.cars) {
			sum = sum + c.getPoints();
		}
		return sum;
	}

	/**
	 * starts the game
	 */
	public void start() {
		for (Thread t : this.carThread) {
			t.start();
		}
	}

	/**
	 * stops the game
	 */
	private void stop() {

		this.notifyAll();
		for (Thread t : this.carThread) {
			t.interrupt();
		}

	}
}
