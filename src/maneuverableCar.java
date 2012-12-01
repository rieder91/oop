/**
 * @author OOP Gruppe 187
 */
public class maneuverableCar extends Car {

	/**
	 * Constructor with 6 arguments
	 * 
	 * @param ival
	 * 		time the car waits between the moves
	 * @param s
	 * 		strategy the car uses to move
	 * @param x
	 * 		the x coordinate of the car on the track
	 * @param y
	 * 		the y coordinate of the car on the track
	 * @param dir
	 * 		the direction the car faces
	 * @param t
	 * 		the track the car is placed on
	 */
	public maneuverableCar(int ival, Strategy s, int x, int y, Direction dir, Track t) {
		super(ival, s, x, y, dir, t);
	}

	@Override
	protected void drive() {
		int nextmove = this.getStrategy().next();
		nextmove = (this.getdir().toNumber() + nextmove) % 8;
		if (nextmove < 0) {
			nextmove += 7;
		}
		this.getTrack().move(this, nextmove);

	}

}
