/**
 * abstract class which all cookie-factories extend
 * 
 * it contains the abstract backen-method which creates a new cookie with the
 * ADDITIONAL details specified in the argument
 * 
 * @author OOP Gruppe 187
 * 
 */
public abstract class Backmaschine {

	/**
	 * produces a cookie with the one specific detail extracted from the
	 * position (dependant on the machine-type)
	 * 
	 * @param p
	 *            position which contains the details of the cookie that is to
	 *            be produced
	 * @return new cookie
	 */
	protected abstract Keks backen(Position p);
}
