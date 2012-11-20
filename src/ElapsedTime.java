/**
 * This class represents the time a process consumed.
 * It implements the Shorter interface.
 * 
 * @author OOP Gruppe 187
 */
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
	 * Compares @this with @other
	 * 
	 * @param other
	 * 			elapsed time to compare with
	 * @return 	true - if this is shorter than other
	 * 			false - otherwise
	 */
	public boolean shorter(ElapsedTime other) {
		return this.shorter(other.value);
	}
	
	/**
	 * Compares the value of the elapsed time with @val
	 * 
	 * @param val 
	 * 		value to compare with
	 * @return true - if this is shorter than other
	 * 			false - otherwise
	 * 		
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
	 * @return the value of the elapsed time
	 */
	public Double getValue() {
		return value;
	}
	
	/**
	 * @param value the new value of the elapsed time
	 */
	public void setValue(Double value) {
		this.value = value;
	}
}
