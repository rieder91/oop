package assignment1;

import java.math.BigDecimal;
import java.util.Date;

public class Rehearsal extends Event {

	private BigDecimal cost;

	/**
	 * 
	 * @return a string representation of a Rehersal
	 */
	public String toString() {
		return super.toString() + " Costs: " + this.cost;
	}

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the rehearsal
	 * @param place
	 *            the place of the rehearsal
	 * @param duration
	 *            the duration of the rehearsal
	 * @param cost
	 *            the costs of the rehearsal
	 */
	public Rehearsal(Date time, String place, Integer duration, BigDecimal cost) {
		super(time, place, duration);
		this.cost = cost;
	}

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the rehearsal
	 * @param place
	 *            the place of the rehearsal
	 * @param duration
	 *            the duration of the rehearsal
	 * @param cost
	 *            the costs of the rehearsal
	 */
	public Rehearsal(Date time, String place, Integer duration, Double cost) {
		super(time, place, duration);
		this.cost = new BigDecimal(cost);
	}

	/**
	 * 
	 * 
	 * @return the cost of the rehearsal
	 */
	public BigDecimal getFinances() {
		return this.cost.multiply(new BigDecimal(-1.0));
	}

}