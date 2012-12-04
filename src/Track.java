import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Befinden sich bereits Autos auf dem Feld, so gibt es einen Zusammenstoﬂ.
 * 
 * Fuer jedes Auto, das man von vorne trifft, gibt es einen Bonuspunkt,
 * wird man von einem anderen Auto hinten, links oder rechts getroffen, so gibt es einen Minuspunkt.
 * Ziel ist es moeglichst viele Punkte zu sammeln.
 * 
 * Wenn ein Auto die Maximalpunktezahl (10) erreicht hat,
 * oder ein Auto eine Maximalzahl an Feldwechseln ausgefuehrt hat,
 * geben Sie von allen Autos die Punktezahl aus und beenden alle Threads.
 * 
 * Verwenden Sie Thread.interrupt() um einen Thread zu unterbrechen,
 * geben Sie den Namen und den Punktestand aus, und beenden Sie den Thread.
 * the Track on which the car is placed
 * 
 * Die Autos bewegen sich mit unterschiedlichen moeglichst einfachen Strategien weiter,
 * z.B. zufaellig, oder im Kreis oder in Schlangenlinien im Kreis, aber nie ueber die Fahrbahn hinaus.
 * 
 * @author OOP Gruppe 187
 */

public class Track {

	private ArrayList<Car> cars;
	private ArrayList<Thread> carThread;
	private int maxx;
	private int maxy;
	private int maxmoves;
	private Boolean usedFields[][];
	private AtomicBoolean gameEnded;

	private ArrayList<Car> lastCars;

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
		this.usedFields = new Boolean[this.maxx][this.maxy];
		this.gameEnded = new AtomicBoolean(false);

		this.lastCars = new ArrayList<Car>();

		for (int i = 0; i < this.maxx; i++) {
			for (int j = 0; j < this.maxy; j++) {
				this.usedFields[i][j] = new Boolean(false);
			}
		}
	}

	/**
	 * adds a new car to the track
	 * 
	 * @param car
	 *            the new car
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
	private ArrayList<Car> crash(Car c, int newx, int newy) {
		Direction invdir;
		ArrayList<Car> crashedCars = new ArrayList<Car>();
		invdir = c.getDir().invert();

		Direction left, right;

		for (Car cc : this.cars) {
			if ((cc.getX() == newx) && (cc.getY() == newy) && (cc != c)) {
				c.notification(1);
				left = cc.getDir().left();
				right = cc.getDir().right();

				if (invdir == cc.getDir()) {
					c.notification(1);
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

				crashedCars.add(cc);
			}

		}
		return crashedCars;
	}

	protected AtomicBoolean getGameEnded() {
		return this.gameEnded;
	}

	protected ArrayList<Car> getLastCars() {
		return this.lastCars;
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
		// System.out.println("Attempt to move with moves: " + c.getMoves());

		int newx = 0;
		int newy = 0;
		Direction newdir = Direction.North;

		int previousX = c.getX();
		int previousY = c.getY();

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

		// check if the new coordinates are inside the game area
		if (!((newx >= 0) && (newx < this.maxx) && (newy >= 0) && (newy < this.maxy))) {
			c.increaseMoves();
			if (c.getMoves() >= this.maxmoves) {
				if (this.gameEnded.compareAndSet(false, true)) {
					this.stop();
				}
			}
			return;
		}

		// sort fields to prevent deadlock
		if (previousX < newx) {
			int tempX = newx;
			newx = previousX;
			previousX = tempX;
		}

		if (previousY < newy) {
			int tempY = newy;
			newy = previousY;
			previousY = tempY;
		}

		synchronized (this.usedFields[previousX][previousY]) {
			synchronized (this.usedFields[newx][newy]) {
				ArrayList<Car> crashedCars;
				c.increaseMoves();
				c.setDir(newdir);
				c.setX(newx);
				c.setY(newy);
				crashedCars = this.crash(c, newx, newy);

				/*
				 * TODO: if the game has ended and another thread already called the 5 methods above
				 * we need to roll the changes back
				 * ALTERNATIVE:
				 * throw interrupted exception and catch it here!
				 */

				if ((c.getPoints() >= 10) || (c.getMoves() >= this.maxmoves)) {
					if (this.gameEnded.compareAndSet(false, true)) {
						this.lastCars.add(c);
						this.lastCars.addAll(crashedCars);
						this.stop();
					}
				}
			}
		}
	}

	/**
	 * @return the points of every car
	 */
	public String points() {
		StringBuilder s = new StringBuilder();
		Car[] cc = new Car[this.cars.size()];
		cc = this.cars.toArray(cc);
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
	private synchronized void stop() {

		this.notifyAll();
		for (Thread t : this.carThread) {
			t.interrupt();
		}

	}
}
