/**
 * Shorter interface
 * 
 * @author OOP Gruppe 187
 */

public interface Shorter<T> {
	
	/**
	 * This and @e are compared
	 * 
	 * @param e
	 * 			the element compared, that shall be compared with this
	 * @return true if this is shorter than @e, false otherwise
	 */
	public boolean shorter(T e);
}
