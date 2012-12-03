/**
 * drive strategy of the car
 * 
 * @author OOP Gruppe 187
 */
public interface Strategy {

	/**
	 * @return the direction of the next move
	 */
	public int next();

	/**
	 * return the name of the strategy
	 * @return name of the strategy
	 */
	public String getBez();
}
