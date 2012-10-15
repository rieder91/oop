
package assignment1;

import java.math.BigDecimal;
import java.util.Date;

/**
 * used to store information about events
 * 
 * @author OOP Gruppe 187
 */
public abstract class Event {

	private String place;
	private Date time;
	private Integer duration;

	/**
	 * @return a string representation of a Event
	 */
	@Override
	public String toString() {

		String ret = "Place: " + place + " Time: " + time + " Duration: "
				+ duration;
		return ret;
	}

	/**
	 * three parameter constructor
	 * 
	 * @param time
	 *            the time of the event
	 * @param place
	 *            the place of the event
	 * @param duration
	 *            the duration of the event
	 */
	public Event(Date time, String place, Integer duration) {

		super();
		this.place = place;
		this.time = time;
		this.duration = duration;
	}

	/**
	 * @return the place of the event
	 */
	public String getPlace() {

		return place;
	}

	/**
	 * @return the time when the event takes place
	 */
	public Date getTime() {

		return time;
	}

	/**
	 * @return the duration of the event
	 */
	public Integer getDuration() {

		return duration;
	}

	/**
	 * @return the cost/pay of the event
	 */
	public abstract BigDecimal getFinances();

	/**
	 * compares two events
	 * 
	 * @return true if the events are equal false otherwise
	 */
	@Override
	public boolean equals(Object o) {

		if (this == o) { return true; }

		if (o == null) { return false; }

		if (!this.getClass().equals(o.getClass())) { return false;

		}
		if (this.place.equals(((Event) o).place)
				&& this.time.equals(((Event) o).time)
				&& this.duration.equals(((Event) o).duration)) { return true;

		}
		return false;
	}
}
