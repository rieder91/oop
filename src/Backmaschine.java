/**
 * 
 * @author OOP Gruppe 187
 *
 */
public abstract class Backmaschine {

	private Keks k = null;
	/**
	 * 
	 * @param p
	 * @return
	 */
	protected Keks getKeks(Position p) {
		return backen(p);
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	protected abstract Keks backen(Position p);
}
