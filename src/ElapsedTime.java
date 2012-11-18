/**
 * This class represents the time a process consumed.
 * It implements the Shorter interface.
 * 
 * @author OOP Gruppe 187
 */

public class ElapsedTime implements Shorter<ElapsedTime> {

	protected Double value;
	
	/**
	 * Default constructor
	 */
	public ElapsedTime() {
		
		value = 0.0;
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param value
	 * 			The time that was consumed by a process
	 */
	public ElapsedTime(Double value) {
		
		this.value = value;
	}
	
	
	public boolean shorter(ElapsedTime other) {
		
		return this.shorter(other.value);
	}
	
	public boolean shorter(Double val) {
		if(this.value < val) 
			return true;
		return false;
	}
	
	/**
	 * Returns number of saved elements
	 * Exact meaning depends on subtype
	 * 
	 * @return number of saved elements
	 */
	public int count() {
		
		return 1;
	}
}
