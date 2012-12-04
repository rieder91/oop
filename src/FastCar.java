/**
 * Von den acht benachbarten Feldern kann sich das schnellere Auto auf das naechste in Fahrtrichtung liegende Feld
 * (3, siehe das 3x3-Feld unten) nach vorne bewegen,
 * 
 * auf das Feld schraeg links nach vorne (2)
 * bei gleichzeitiger aenderung der Fahrtrichtung um 90° nach links 
 * 
 * oder auf das Feld schraeg rechts nach vorne (4) bei
 * gleichzeitiger aenderung der Fahrtrichtung um 90° nach rechts.
 * 
 * 8 1 2
 * 7 > 3
 * 6 5 4
 * 
 * Rueckwaertsfahren (Felder (6), (7) und (8)) ist nicht moeglich.
 * 
 * a fast car is not as maneuverable as a maneuverable car but therfore it is faster
 * 
 * @author OOP Gruppe 187
 */
public class FastCar extends Car {

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
	public FastCar(int ival, Strategy s, int x, int y, Direction dir, Track t) {
		super(ival, s, x, y, dir, t);
	}

	@Override
	protected void drive() {
		int nextmove = this.getStrategy().next();
		nextmove = nextmove % 2;
		nextmove = (this.getDir().toNumber() + nextmove) % 8;
		if (nextmove < 0) {
			nextmove += 8;
		}
		this.getTrack().move(this, nextmove);

	}

	@Override
	public String toString() {
		return super.toString() + "Fast Car";
	}

}
