import java.util.Iterator;

/**
 * This class represents the average time of measurement series.
 * 
 * @author OOP Gruppe 187
 */

public class MeanElapsedTime extends ElapsedTime{

	private Set<Double> entries;
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param v
	 * 			First ElapsedTime of a row
	 */
	public MeanElapsedTime(ElapsedTime v) {
		
		super(v.value);
		this.entries = new Set<Double>(v.value);
	}
	
	/**
	 * Adds more ElapsedTimes
	 * 
	 * @param et
	 * 			The ElapsedTime that shall be added to MeanElapsedTime
	 */
	public void add(ElapsedTime et) {
		
		this.entries.insert(et.value);
		this.value = (this.value + et.value) / this.count();
	}
	
	/**
	 * Returns the maximum entry of MeanElapsedTime
	 * 
	 * @return maximum entry of MeanElapsedTime
	 */
	public Double getMax() {
		
		Double tmp, max = 0.0;
		Iterator<Double> it = this.entries.iterator();
		
		while(it.hasNext()) {
			tmp = it.next();
			if(tmp > max)
				max = tmp;
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
	
	public boolean shorter(MeanElapsedTime other) {
		
		return super.shorter(other.value);
	}
}
