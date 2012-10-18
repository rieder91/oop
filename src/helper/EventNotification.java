
package helper;

import band.Event;

/**
 * @author OOP Gruppe 187
 */
public class EventNotification {

	private Event e;
	private Status status;

	/**
	 * @author OOP Gruppe 187
	 *
	 */
	public enum Status {
		scheduled, deferred, canceled
	}

	/**
	 * @param e
	 * @param status
	 */
	public EventNotification(Event e, Status status) {

		this.e = e;
		this.status = status;
	}


}
