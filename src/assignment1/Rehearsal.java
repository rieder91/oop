package assignment1;

import java.util.Date;

public class Rehearsal extends Event {

	private Double cost;

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
	public Rehearsal(Date time, String place, Integer duration, Double cost) {
		super(time, place, duration);
		this.cost = cost;
	}
	
	public Double getFinances() {
		return this.cost * -1;
	}
	
}