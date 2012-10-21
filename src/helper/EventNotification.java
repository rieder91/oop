
package helper;

import band.Event;

/**
 * @author OOP Gruppe 187
 */
public class EventNotification {

	private final Event e;
	private final Status status;
	private boolean notified;

	/**
	 * @param e
	 * @param status
	 */
	public EventNotification(final Event e, final Status status) {

		this.e = e;
		this.status = status;
		this.notified = false;
	}

	/**
	 * @return
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (!(obj instanceof EventNotification)) { return false; }
		EventNotification other = (EventNotification) obj;
		if (e == null) {
			if (other.e != null) { return false; }
		}
		else if (!e.equals(other.e)) { return false; }
		if (status != other.status) { return false; }
		return true;
	}

	/**
	 * @return the event
	 */
	public Event getE() {

		return this.e;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {

		return this.status;
	}

	/**
	 * @return the notification status
	 */
	public boolean getNotified() {

		return this.notified;
	}

	/**
	 * @param not
	 *            the new notification status
	 */
	public void setNotified(boolean not) {

		this.notified = not;
	}

}
