import java.util.ArrayList;

/**
 * @author Markus
 */

public class Track {

	private ArrayList<Car> cars;
	private ArrayList<Thread> carthread;
	private ArrayList<char[][]> map;
	private int maxx;
	private int maxy;
	private int maxmoves;

	/**
	 * constructor with 3 parameter
	 * 
	 * @param length
	 * 		the length of the track
	 * @param height
	 * 		the height of the track
	 * @param maxmoves
	 * 		the maximum moves one car make bevor the game ends
	 */
	public Track(int length, int height, int maxmoves) {
		this.cars = new ArrayList<Car>();
		this.carthread = new ArrayList<Thread>();
		this.map = new ArrayList<char[][]>();
		this.maxx = length;
		this.maxy = height;
		this.maxmoves = maxmoves;
	}

	/**
	 * @param car
	 */
	public void addCar(Car car) {
		this.cars.add(car);
		this.carthread.add(new Thread(car));
	}

	/**
	 * generates a character representation of the track
	 */
	public void generateMap() {
		char[][] s = new char[this.maxy + 1][this.maxx + 1];
		for (int i = 0; i <= this.maxx; i++) {
			for (int a = 0; a <= this.maxy; a++) {
				s[a][i] = '.';
			}
		}
		for (Car c : this.cars) {
			if (s[c.getY()][c.getX()] != '.') {
				s[c.getY()][c.getX()] = 'x';
			}
			else {
				s[c.getY()][c.getX()] = (c.getdir() == 0 ? 'v' : c.getdir() == 2 ? '>' : c.getdir() == 4 ? '^' : '<');
			}
		}
		this.map.add(s);

	}

	/**
	 * 
	 * @return c characater representation of the track
	 */
	public ArrayList<char[][]> getMap() {
		return this.map;
	}


	/**
	 * moves the car in the given direction
	 * @param c
	 * 		the car that moves
	 * @param move
	 * 		the direction the car wants to move
	 */
	public synchronized void move(Car c, int move) {
		int newx = 0;
		int newy = 0;
		int newdir = 0;

		switch (move) {
			case 0:
				newx = c.getX();
				newy = c.getY() + 1;
				newdir = 0;
				break;
			case 1:
				newx = c.getX() + 1;
				newy = c.getY() + 1;
				if (c.getdir() == 0) {
					newdir = 2;
				}
				else {
					newdir = 0;
				}
				break;
			case 2:
				newx = c.getX() + 1;
				newy = c.getY();
				newdir = 2;
				break;
			case 3:
				newx = c.getX() + 1;
				newy = c.getY() - 1;
				if (c.getdir() == 2) {
					newdir = 4;
				}
				else {
					newdir = 2;
				}
				break;
			case 4:
				newx = c.getX();
				newy = c.getY() - 1;
				newdir = 4;
				break;
			case 5:
				newx = c.getX() - 1;
				newy = c.getY() - 1;
				if (c.getdir() == 4) {
					newdir = 6;
				}
				else {
					newdir = 4;
				}
				break;
			case 6:
				newx = c.getX() - 1;
				newy = c.getY();
				newdir = 5;
				break;
			case 7:
				newx = c.getX() - 1;
				newy = c.getY() + 1;
				if (c.getdir() == 6) {
					newdir = 0;
				}
				else {
					newdir = 6;
				}
				break;

		}

		if (!((newx >= 0) && (newx <= this.maxx) && (newy >= 0) && (newy <= this.maxy))) { return; }
		c.incmoves();
		this.generateMap();

		int invdir;
		invdir = (c.getdir());

		int left, right;

		for (Car cc : this.cars) {
			if ((cc.getX() == newx) && (cc.getY() == newy)) {
				left = (cc.getdir() + 6) % 8;
				right = cc.getdir() + 2;

				if (invdir == cc.getdir()) {
					c.notification(1);
				}
				if (c.getdir() == cc.getdir()) {
					cc.notification(-1);
				}
				if (c.getdir() == left) {
					cc.notification(-1);
				}
				if (c.getdir() == right) {
					cc.notification(-1);
				}
			}

		}
		if ((c.getPoints() >= 10) || (c.getmoves() >= this.maxmoves)) {
			this.stop();
		}
		c.setdir(newdir);
		c.setX(newx);
		c.setY(newy);

	}

	/**
	 * 
	 * @return the points of every car
	 */
	public String points() {
		String s = "";
		for (Car c : this.cars) {
			s = s + c.getPoints() + "\n";
		}
		return s;
	}

	/**
	 * starts the game
	 */
	public void start() {
		for (Thread t : this.carthread) {
			t.start();
		}
	}

	/**
	 * stops the game
	 */
	public synchronized void stop() {

		this.notifyAll();
		for (Thread t : this.carthread) {
			t.interrupt();
		}

	}
}
