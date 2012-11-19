import java.util.Iterator;

/**
 * This class represents the average time of measurement series.
 * 
 * @author OOP Gruppe 187
 */

public class MeanElapsedTime extends ElapsedTime {

	private Set<Double> entries;
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param v
	 * 			First ElapsedTime of a row
	 */
	public MeanElapsedTime(ElapsedTime v) {
		this(new Set<Double>(v.getValue()));
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param entries
	 * 			Set of values
	 */
	public MeanElapsedTime(Set<Double> entries) {
		this.entries = new Set<Double>(entries);
		
		Iterator<Double> it = this.entries.iterator();
		Double sum = 0.0;
		
		while(it.hasNext()) {
			sum += it.next();
		}
		
		this.setValue(sum / count());
	}
	
	/**
	 * Adds more ElapsedTimes
	 * 
	 * @param et
	 * 			The ElapsedTime that shall be added to MeanElapsedTime
	 */
	public void add(ElapsedTime et) {
		if(this.entries.insert(et.getValue())) {
			this.setValue(this.getValue() + (et.getValue() / this.count()));
		} else {
			throw new RuntimeException("MeanElapsedTime: Object already exists!");
		}
	}
	
	/**
	 * Returns the maximum entry of MeanElapsedTime
	 * 
	 * @return maximum entry of MeanElapsedTime
	 */
	public Double getMax() {
		
		Double tmp, max = Double.MIN_VALUE;
		Iterator<Double> it = this.entries.iterator();
		
		while(it.hasNext()) {
			tmp = it.next();
			if(tmp > max) {
				max = tmp;
			}
		}
		
		return max;
	}
	
	/**
	 * Returns the number of times saved
	 * 
	 * @return the number of times saved
	 */
	@Override
	public int count() {
		int tmp = 0;
		Iterator<Double> it = this.entries.iterator();
		
		while(it.hasNext()) {
			it.next();
			tmp++;
		}
		
		return tmp;
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public boolean shorter(MeanElapsedTime other) {
		
		return super.shorter(other.getValue());
	}
}
