/**
 * in this Strategy the car drives in left circles
 * 
 * @author OOP Gruppe 187
 */
public class LeftCircleStrategy implements Strategy {

	/**
	 * 
	 * @return the direction of the next move(everytime 1)
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
