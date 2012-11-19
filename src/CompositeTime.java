/**
 * This class represents the total time of measurement series.
 * 
 * @author OOP Gruppe 187
 */

public class CompositeTime extends ElapsedTime{

	private Double[] comp;
	
	/**
	 * Constructor with one value as parameter
	 * 
	 * @param val
	 * 			A time consumed by a process
	 */
	public CompositeTime(Double val) {
		
		super(val);
		comp = new Double[1];
		comp[0] = val;
	}
	
	/**
	 * Constructor with an Array as parameter
	 * 
	 * @param val
	 * 			An Array of times consumed by a process
	 */
	public CompositeTime(Double[] val) {
		super();
		
		comp = new Double[val.length];
		Double tmp = 0.0;
		int i = 0;
		
		for(Double a: val) {
			comp[i] = a;
			tmp += a;
			i++;
		}
		
		this.value = tmp;
	}
	
	/**
	 * Returns the minimum entry of CompositeTime
	 * 
	 * @return minimum entry of CompositeTime
	 */
	public Double getMin() {
		
		Double tmp = this.comp[0];
		
		for(Double a: this.comp) {
			if(tmp > a)
				tmp = a;
		}
		
		return tmp;
	}
	
	/**
	 * Returns the number of times saved
	 * 
	 * @return the number of times saved
	 */
	@Override
	public int count() {
		
		return this.comp.length;
	}
	
	public boolean shorter(CompositeTime ct) {
		
		return super.shorter(ct.value);
	}
}
