/**
 * This class represents the time a process consumed.
 * It implements the Shorter interface.
 * 
 * @author OOP Gruppe 187
 */
//TODO: abstract
public abstract class ElapsedTime implements Shorter<ElapsedTime> {

	private Double value;
	
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
	
	/**
	 * 
	 */
	public boolean shorter(ElapsedTime other) {
		return this.shorter(other.value);
	}
	
	/**
	 * 
	 * @param val
	 * @return
	 */
	public boolean shorter(Double val) {
		if(this.value < val) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Returns number of saved elements
	 * Exact meaning depends on subtype
	 * 
	 * @return number of saved elements
	 */
	public abstract int count();
	
	/**
	 * 
	 * @return
	 */
	public Double getValue() {
		return value;
	}
	
	/**
	 * 
	 * @param value
	 */
	public void setValue(Double value) {
		this.value = value;
	}
}
