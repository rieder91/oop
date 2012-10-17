
package assignment1;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class that contains the pay of a gig.
 * 
 * A gig is an event, the event information is stored in event.
 * 
 * @author OOP Gruppe 187
 */
public class Gig extends Event {

	private BigDecimal pay;

	/**
	 * @return a string representation of a Gig
	 */
	@Override
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
	 * @return the pay you get for the gig
	 */
	@Override
	public BigDecimal getFinances() {

		return this.pay;
	}

	/**
	 * compares two gigs
	 * 
	 * @return true if the gigs are equal false otherwise
	 */
	@Override
	public boolean equals(Object o) {

		boolean ret = super.equals(o);

		if (ret && pay.equals(((Gig) o).pay)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateEvent(Event e, Date changeDate) throws InvalidDateException {
		for(Date d : getEventHistory().keySet()) {
			if(d.after(changeDate)) {
				throw new InvalidDateException("change date is before last edit");
			}
		}
		
		if(e.getClass() == this.getClass()) {
			Gig newGig = (Gig) e;
			Gig history = new Gig(this.getTime(), this.getPlace(), this.getDuration(), this.pay);
			addToHistory(history, changeDate);
			
			this.setTime(newGig.getTime());
			this.setDuration(newGig.getDuration());
			this.setPlace(newGig.getPlace());
			this.pay = new BigDecimal(0);
			this.pay = this.pay.add(newGig.pay);
		} else {
			// type error
		}
	}

	@Override
	/**
	 * Reverts the Event to the state at @restoreDate and saves the current state with the date @currentDate
	 * 
	 */
	public void restoreEvent(Date restoreDate, Date currentDate) throws InvalidDateException {
		Gig oldGig = (Gig) getEventHistory().get(restoreDate);
		if(oldGig != null) {
			updateEvent(oldGig, currentDate);
		} else {
			throw new InvalidDateException("no event found at the specified date");
		}
	}
}
