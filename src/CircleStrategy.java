/**
 * in this Strategy the car drives in left circles
 * 
 * @author OOP Gruppe 187
 */
public class CircleStrategy implements Strategy {

	/**
	 * @return the direction of the next move
	 */
	@Override
	public int next() {

		return 1;
	}

	@Override
	public String toString() {
		return "Circle";
	}
}
