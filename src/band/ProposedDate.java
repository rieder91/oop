
package band;

import java.util.Date;

/**
 * This class is used to save information about a proposed date.
 * 
 * @author OOP Gruppe 187
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
	 */
	public ProposedDate(Event e, Date date) {

		this.e = e;
		this.date = date;
	}

	/**
	 * @param agreed
	 *            the agreed to set
	 */
	public void agree(boolean agreed) {

		this.agreed = agreed;
	}

	/**
	 * @param agreed
	 *            the agreed to set
	 */
	public void agree(boolean agreed, String reason) {

		this.agreed = agreed;
		this.reason = reason;
	}

	/**
	 * @param obj
	 * @return
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
	 * @return
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
	 * @return true if the member agreed false if the member declined
	 */
	public boolean isAgreed() {

		return this.agreed;
	}

	/**
	 * @return
	 */
	@Override
	public String toString() {

		return "Event: " + this.e + ", agreed: " + this.agreed + ", reason: " + this.reason + ", date: " + this.date;
	}

}
