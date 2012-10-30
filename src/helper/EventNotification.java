
package helper;

import band.Event;

/**
 * contains all the information for a single event notification
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: the class name
 */
public class EventNotification {

	private final Event e; 
	private final Status status; 
	private boolean notified;

	/**
	 * @param e
	 *            (!= null)
	 *            event to be notified
	 * @param status
	 *            status of the event
	 *            
	 * PRECONDITION: none of the parameters are null
	 */
	public EventNotification(final Event e, final Status status) {

		this.e = e;
		this.status = status;
		this.notified = false;
	}

	/**
	 * compares two event notifications
	 * 
	 * @param obj
	 *            the event notification to compare with
	 * @return
	 *         true - if the event notification are equal
	 *         false - otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof EventNotification)) { return false; }
		EventNotification other = (EventNotification) obj;
		if (this.e == null) {
			if (other.e != null) { return false; }
		}
		else if (!this.e.equals(other.e)) { return false; }
		if (this.status != other.status) { return false; }
		return true;
	}

	/**
	 * @return the event the member should be notified
	 */
	public Event getE() {

		return this.e;
	}

	/**
	 * @return the notification status
	 *         true - the member was already notified
	 *         false - otherwise
	 */
	public boolean getNotified() {

		return this.notified;
	}

	/**
	 * @return the status of the event
	 */
	public Status getStatus() {

		return this.status;
	}

	/**
	 * @return a hash value representing the event notification
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (this.e == null ? 0 : this.e.hashCode());
		result = prime * result + (this.status == null ? 0 : this.status.hashCode());
		return result;
	}

	/**
	 * sets the notification status to @not
	 * 
	 * @param not
	 *            the new notification status
	 *            true - the member is notified about the event
	 *            false - otherwise
	 */
	public void setNotified(boolean not) {

		this.notified = not;
	}

}
