import java.util.Random;

/**
 * @author OOP Gruppe 187
 */
public class randomStrategy implements Strategy {

	Random rnd;

	randomStrategy() {
		this.rnd = new Random();
	}

	/**
	 * 
	 * @return the direction of the next move
	 */
	@Override
	public int next() {
		return (this.rnd.nextInt(5)) - 3;
	}

}
