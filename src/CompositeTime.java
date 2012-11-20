/**
 * This class represents the total time of measurement series.
 * 
 * @author OOP Gruppe 187
 */

public class CompositeTime extends ElapsedTime {

	private Double[] comp;
	
	/**
	 * Constructor with one value as parameter
	 * 
	 * @param comp
	 * 			A time consumed by a process
	 */
	public CompositeTime(Double comp) {
		this(new Double[]{comp});
	}
	
	/**
	 * Constructor with an Array as parameter
	 * 
	 * @param comp
	 * 			An Array of times consumed by a process
	 */
	public CompositeTime(Double[] comp) {
		super();
		
		this.comp = new Double[comp.length];
		
		Double sum = 0.0;
		int i = 0;
		
		for(Double a : comp) {
			this.comp[i] = a;
			sum += a;
			i++;
		}

		this.setValue(sum);
	}
	
	/**
	 * Returns the minimum entry of CompositeTime
	 * 
	 * @return minimum entry of CompositeTime
	 */
	public Double getMin() {
		Double min = Double.MAX_VALUE;
		
		for(Double a: this.comp) {
			if(min > a) {
				min = a;
			}
		}
		
		return min;
	}
	
	/**
	 * Returns the number of times saved
	 * 
	 * @return the number of times saved
	 */
	public int count() {
		return this.comp.length;
	}
	
	/**
	 * Compares @this with @other
	 * 
	 * @param other
	 * 			CompositeTime to compare with
	 * @return 	true - if this is shorter than other
	 * 			false - otherwise
	 */
	public boolean shorter(CompositeTime ct) {
		return super.shorter(ct.getValue());
	}
}
