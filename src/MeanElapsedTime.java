import java.util.Iterator;



/**
 * This class represents the average time of measurement series.
 * 
 * @author OOP Gruppe 187
 */

public class MeanElapsedTime extends ElapsedTime {

	private Set<Double> entries;
	
	/**
	 * Default Constructor
	 */
	public MeanElapsedTime(){
		this.entries=new Set<>();
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param v
	 * 			First ElapsedTime of a row
	 */
	public MeanElapsedTime(ElapsedTime v) {
		this(new Set<>(v.getValue()));
	}
	
	/**
	 * Constructor with one parameter
	 * 
	 * @param entries
	 * 			Set of values
	 */
	public MeanElapsedTime(Set<Double> entries) {
		this.entries = new Set<>(entries);
		
		double sum = 0.0;
		
		for(Double a:this.entries){
			sum+=a;
		}
		
		this.setValue(sum / count());
	}
	
	/**
	 * Adds a ElapsedTime
	 * 
	 * @param et
	 * 			The ElapsedTime that shall be added to MeanElapsedTime
	 */
	public void add(ElapsedTime et) {
		this.add(et.getValue());
	}
	
	/**
	 * Adds a value
	 * 
	 * @param et
	 * 			The value that shall be added to MeanElapsedTime
	 */
	public void add(Double value) {
		
		if(this.entries.insert(value)) {
			double sum=0.0;
			for(Double a:this.entries){
				sum+=a;
			}
			this.setValue(sum/this.count());
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
		
		Double max = this.getValue();
		
		for(Double a:this.entries){
			if(a > max) {
				max = a;
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
		
		for (Iterator<Double> iterator = this.entries.iterator(); iterator.hasNext();) {
			iterator.next();
			tmp++;
		}
		
		return tmp;
	}
	
	/**
	 * Compares @this with @other
	 * 
	 * @param other
	 * 			MeanElapsedTime to compare with
	 * @return 	true - if this is shorter than other
	 * 			false - otherwise
	 */
	public boolean shorter(MeanElapsedTime other) {
		
		return super.shorter(other.getValue());
	}
}
