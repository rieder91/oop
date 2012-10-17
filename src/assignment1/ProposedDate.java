package assignment1;

import java.util.Date;

/**
 * This class is used to save information about a proposed date.
 * 
 * @author OOP Gruppe 187
 * 
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
	 * compares two proposed dates
	 * 
	 * @return true if the proposed dates are equal false otherwise
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ProposedDate))
			return false;
		ProposedDate other = (ProposedDate) obj;
		if (this.e == null) {
			if (other.e != null)
				return false;
		} else if (!this.e.equals(other.e))
			return false;
		if (this.date == null) {
			if (other.date != null)
				return false;
		} else if (!this.date.equals(other.date))
			return false;
		return true;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return this.date;
	}

}