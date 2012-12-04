/**
 * Ein Auto befindet sich auf einem Feld und ist nach einer der vier Himmelsrichtungen
 * (Norden, Osten, Süden und Westen) ausgerichtet.
 * 
 * Das Fahren wird in viele unterschiedlich lange dauernde Teilschritte unterteilt.
 * 
 * In jedem Schritt kann sich ein Auto vom aktuellen Feld auf ein benachbartes Feld bewegen.
 * 
 * Es gibt zwei Arten von Autos, ein schnelleres und ein beweglicheres.
 * 
 * Die Autos bewegen sich mit unterschiedlichen möglichst einfachen Strategien weiter,
 * z.B. zufällig, oder im Kreis oder in Schlangenlinien im Kreis, aber nie über die Fahrbahn hinaus.
 * 
 * Jedes Auto bewegt nach einer gewissen Zeit (wenige Millisekunden) von einem Feld zu einem Nachbarfeld,
 * ein schnelles Auto nach sehr wenigen Millisekunden, ein bewegliches Auto nach etwas mehr Millisekunden.
 * Simulieren Sie Wartezeiten mittels der Methode Thread.sleep(n).
 * 
 * @author OOP Gruppe 187
 */
public abstract class Car implements Runnable, Comparable<Car> {

	private Direction dir;
	private int interval;
	private Strategy s;
	private int x;
	private int y;
	private int points;
	private Track t;
	private int moves;

	// used for rollback
	private int tempInc;
	private int tempX;
	private int tempY;
	private Direction tempDir;
	private int tempPoints;

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

	@Override
	public int compareTo(Car arg0) {
		return (arg0.points == this.points) ? 0 : (arg0.points < this.points) ? -1 : 1;
	}

	/**
	 * 
	 */
	protected abstract void drive();

	/**
	 * @return the direction the car faces
	 */
	protected Direction getDir() {
		return this.dir;
	}

	/**
	 * @return the number of moves the car made
	 */
	protected int getMoves() {
		return this.moves;
	}

	/**
	 * @return the points of the car
	 */
	protected int getPoints() {
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
	protected int getX() {
		return this.x;
	}

	/**
	 * @return the y coordinate of the car
	 */
	protected int getY() {
		return this.y;
	}

	/**
	 * increments the move counter by one
	 */
	protected void increaseMoves() {
		this.moves++;
	}

	/**
	 * notifies the car about a crash
	 * 
	 * @param p
	 *            the points the car gets
	 */
	protected void notification(int p) {
		this.points += p;

	}

	/**
	 * should be called if a thread is stopped and there are pending changes
	 */
	protected void rollbackChanges() {
		this.dir = this.tempDir;
		this.moves = this.tempInc;
		this.x = this.tempX;
		this.y = this.tempY;
		if (!this.t.getLastCars().contains(this)) {
			this.points = this.tempPoints;
		}
	}

	/**
	 * main method of the car
	 */
	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(this.interval);
			}
			catch (InterruptedException e) {
				return;
			}

			this.saveState();
			this.drive();
			if (this.t.getGameEnded().get()) {
				this.rollbackChanges();
				return;
			}
		}

	}

	protected void saveState() {
		this.tempDir = this.dir;
		this.tempInc = this.moves;
		this.tempX = this.x;
		this.tempY = this.y;
		this.tempPoints = this.points;
	}

	/**
	 * sets the direction of the car to dir
	 * 
	 * @param dir
	 *            the new direction
	 */
	protected void setDir(Direction dir) {
		this.dir = dir;
	}

	/**
	 * sets the x coordinate of the car to x
	 * 
	 * @param x
	 *            the new x cooridiante
	 */
	protected void setX(int x) {
		this.x = x;
	}

	/**
	 * sets the y coordinate of the car to y
	 * 
	 * @param y
	 *            the new y coordinate
	 */
	protected void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Punkte: " + this.points + " Strategie: " + this.s + " Autotyp: ";
	}
}
