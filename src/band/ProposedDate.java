
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
	 * @return true if the member agreed false if the member declined
	 */
	public boolean isAgreed() {

		return this.agreed;
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
	 * @return the reason why the member accepted oder declined the date
	 */
	public String getReason() {

		return this.reason;
	}

	/**
	 * @return the event
	 */
	public Event getE() {

		return this.e;
	}

	/**
	 * @return
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (agreed ? 1231 : 1237);
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		return result;
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
		if (agreed != other.agreed) { return false; }
		if (date == null) {
			if (other.date != null) { return false; }
		}
		else if (!date.equals(other.date)) { return false; }
		if (e == null) {
			if (other.e != null) { return false; }
		}
		else if (!e.equals(other.e)) { return false; }
		if (reason == null) {
			if (other.reason != null) { return false; }
		}
		else if (!reason.equals(other.reason)) { return false; }
		return true;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {

		return this.date;
	}

}
