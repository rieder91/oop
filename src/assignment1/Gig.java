package assignment1;

import java.util.Date;

public class Gig extends Event {

	private Double pay;

	/**
	 * 
	 * @return
	 */
	public String toString() {
		return super.toString() + " Pay: " + this.pay;
	}

	/**
	 * 
	 * @param time
	 * @param place
	 * @param duration
	 * @param pay
	 */
	public Gig(Date time, String place, Integer duration, Double pay) {
		super(time, place, duration);
		this.pay = pay;
	}
	
	public Double getFinances() {
		return this.pay;
	}

}