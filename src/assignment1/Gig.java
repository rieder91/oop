package assignment1;

import java.math.BigDecimal;
import java.util.Date;

public class Gig extends Event {

	private BigDecimal pay;

	/**
	 * 
	 * @return a string representation of a Gig
	 */
	public String toString() {
		return super.toString() + " Pay: " + this.pay;
	}

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the gig
	 * @param place
	 *            the place of the gig
	 * @param duration
	 *            the duration of the gig
	 * @param pay
	 *            the pay of the gig
	 */
	public Gig(Date time, String place, Integer duration, BigDecimal pay) {
		super(time, place, duration);
		this.pay = pay;
	}
	
	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the gig
	 * @param place
	 *            the place of the gig
	 * @param duration
	 *            the duration of the gig
	 * @param pay
	 *            the pay of the gig
	 */
	public Gig(Date time, String place, Integer duration, Double pay) {
		super(time, place, duration);
		this.pay = new BigDecimal(pay);
	}
	
	/**
	 * 
	 * @return the pay you get for the gig
	 */
	public BigDecimal getFinances() {
		return this.pay;
	}
	
	/**
	 * compares two events
	 * 
	 * @return true if the events are equal false if the events are not equal
	 */
	public boolean equals(Object o) {
		boolean ret = super.equals(o);
		
		if(ret && pay.equals(((Gig) o).pay)) {
			return true;
		} else {
			return false;
		}
	}

}