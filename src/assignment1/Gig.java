package assignment1;

import java.math.BigDecimal;
import java.util.Date;

public class Gig extends Event {

	private BigDecimal pay;

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
	public Gig(Date time, String place, Integer duration, BigDecimal pay) {
		super(time, place, duration);
		this.pay = pay;
	}
	
	public Gig(Date time, String place, Integer duration, Double pay) {
		super(time, place, duration);
		this.pay = new BigDecimal(pay);
	}
	
	public BigDecimal getFinances() {
		return this.pay;
	}

}