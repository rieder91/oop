
package band;

import java.util.Date;

/**
 * This class is used to save information about a proposed date.
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: the class name
 * GOOD: high Klassenzusammenhalt
 * GOOD: low object coupling
 */
public class ProposedDate {

	private Event e; 

	private boolean agreed;
	private String reason;
	private Date date; 

	/**
	 * Constructor which requires three arguments
	 * 
	 * @param e
	 *            event to agree
	 * @param date
	 *            date when the event should be
	 * 
	 * PRECONDITION: none of the parameters are null
	 */
	public ProposedDate(Event e, Date date) {

		this.e = e;
		this.date = date;
	}

	/**
	 * agree to a proposed date
	 * 
	 * @param agreed
	 *            true - the member agrees
	 *            false - the member disagrees
	 */
	public void agree(boolean agreed) {

		this.agreed = agreed;
	}

	/**
	 * agree to a proposed date
	 * 
	 * @param agreed
	 *            true - the member agrees
	 *            false - the member disagrees
	 * @param reason
	 *            the reason why you agree/disagree
	 *            
	 * PRECONDITION: reason is not null
	 */
	public void agree(boolean agreed, String reason) {

		this.agreed = agreed;
		this.reason = reason;
	}

	/**
	 * compares two proposed dates
	 * 
	 * @param obj
	 *            the proposed date to compare with
	 * @return true - if the proposed dates are equal
	 *         false - otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof ProposedDate)) { return false; }
		ProposedDate other = (ProposedDate) obj;
		if (this.agreed != other.agreed) { return false; }
		if (this.date == null) {
			if (other.date != null) { return false; }
		}
		else if (!this.date.equals(other.date)) { return false; }
		if (this.e == null) {
			if (other.e != null) { return false; }
		}
		else if (!this.e.equals(other.e)) { return false; }
		if (this.reason == null) {
			if (other.reason != null) { return false; }
		}
		else if (!this.reason.equals(other.reason)) { return false; }
		return true;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {

		return this.date;
	}

	/**
	 * @return the event
	 */
	public Event getE() {

		return this.e;
	}

	/**
	 * @return the reason why the member accepted oder declined the date
	 */
	public String getReason() {

		return this.reason;
	}

	/**
	 * @return a hash value representing the proposed date
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (this.agreed ? 1231 : 1237);
		result = prime * result + (this.date == null ? 0 : this.date.hashCode());
		result = prime * result + (this.e == null ? 0 : this.e.hashCode());
		result = prime * result + (this.reason == null ? 0 : this.reason.hashCode());
		return result;
	}

	/**
	 * before this method is used the member has to accept/decline the proposal
	 * 
	 * @return true - if the member agreed
	 *         false - if the member declined
	 *         
	 * PRECONDITION: before this method is used you have to use agree
	 */
	public boolean isAgreed() {

		return this.agreed;
	}

	/**
	 * @return a string representation of a proposed date
	 */
	@Override
	public String toString() {

		return "Event: " + this.e + ", agreed: " + this.agreed + ", reason: " + this.reason + ", date: " + this.date;
	}

}
