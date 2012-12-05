import java.util.Random;

/**
 * in this Strategy the car drives in a random direction
 * 
 * @author OOP Gruppe 187
 */
public class RandomStrategy implements Strategy {

	private Random rnd;

	/**
	 * default constructor
	 */
	public RandomStrategy() {
		this.rnd = new Random();
	}

	/**
	 * @return the direction of the next move ( between -2 and 2)
	 */
	@Override
	public int next() {
		return (this.rnd.nextInt(5)) - 3;
	}

	@Override
	public String toString() {
		return "Random";
	}
}
