package assignment1;

import java.math.BigDecimal;
import java.util.Date;

public class Rehearsal extends Event {

	private BigDecimal cost;

	/**
	 * 
	 * @return 
	 */
	public String toString() {
		return super.toString() + " Costs: " + this.cost;
	}

	/**
	 * 
	 * @param time
	 * @param place
	 * @param duration
	 * @param cost
	 * @return 
	 */
	public Rehearsal(Date time, String place, Integer duration, BigDecimal cost) {
		super(time, place, duration);
		this.cost = cost;
	}
	
	public Rehearsal(Date time, String place, Integer duration, Double cost) {
		super(time, place, duration);
		this.cost = new BigDecimal(cost);
	}
	
	
	public BigDecimal getFinances() {
		return this.cost.multiply(new BigDecimal(-1.0));
	}
	
}