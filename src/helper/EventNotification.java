
package helper;

import band.Event;

/**
 * @author OOP Gruppe 187
 */
public class EventNotification {

	private final Event e;
	private final Status status;

	/**
	 * @param e
	 * @param status
	 */
	public EventNotification(final Event e, final Status status) {

		this.e = e;
		this.status = status;
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

}
