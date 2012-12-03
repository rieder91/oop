/**
 * a maneuverable car is not as fast as a fast car but therfore it is more maneuverable
 * 
 * @author OOP Gruppe 187
 */
public class ManeuverableCar extends Car {

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
	public ManeuverableCar(int ival, Strategy s, int x, int y, Direction dir, Track t) {
		super(ival, s, x, y, dir, t);
	}

	@Override
	protected void drive() {
		int nextmove = this.getStrategy().next();
		nextmove = (this.getDir().toNumber() + nextmove) % 8;
		if (nextmove < 0) {
			nextmove += 8;
		}
		this.getTrack().move(this, nextmove);

	}

	@Override
	public String getBez() {
		return "Maneuverable Car";
	}

}
