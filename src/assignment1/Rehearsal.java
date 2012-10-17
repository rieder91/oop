
package assignment1;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Class that contains the cost of a rehearsal.
 * 
 * A rehearsal is an event, the event information is stored in event.
 * 
 * @author OOP Gruppe 187
 */
public class Rehearsal extends Event {

	private BigDecimal cost;

	/**
	 * @return a string representation of a rehearsal
	 */
	@Override
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
	 * @return the cost of the rehearsal
	 */
	@Override
	public BigDecimal getFinances() {

		return this.cost.multiply(new BigDecimal(-1.0));
	}

	/**
	 * compares two rehearsals
	 * 
	 * @return true if the rehearsals are equal false otherwise
	 */
	@Override
	public boolean equals(Object o) {

		boolean ret = super.equals(o);

		if (ret && cost.equals(((Rehearsal) o).cost)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	@Override
	public void updateEvent(Event e, Date changeDate) {
		if(e.getClass() == this.getClass()) {
			Rehearsal newRehearsal = (Rehearsal) e;
			Rehearsal history = new Rehearsal(this.getTime(), this.getPlace(), this.getDuration(), this.cost);
			addToHistory(history, changeDate);
			
			this.setTime(newRehearsal.getTime());
			this.setDuration(newRehearsal.getDuration());
			this.setPlace(newRehearsal.getPlace());
			this.cost = new BigDecimal(0);
			this.cost.add(newRehearsal.cost);
			
		} else {
			// type error
		}
	}

	@Override
	public void restoreEvent(Date restoreDate, Date currentDate) {
		// TODO Auto-generated method stub
		
	}

}
