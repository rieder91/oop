package assignment1;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import auth.Authenticatable;

/**
 * used to store information about a event; Event is an abstract class which
 * implements all methods common to both Gig and Rehearsal
 * 
 * @author OOP Gruppe 187
 */
public abstract class Event implements Authenticatable {

	private String name;
	private String place;
	private Date time;
	private Integer duration;
	private HashMap<Date, Event> eventHistory;

	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;

	/**
	 * @return a string representation of a Event
	 */
	@Override
	public String toString() {

		String ret = "Name: " + this.name + " Place: " + this.place + " Time: "
				+ this.time + " Duration: " + this.duration;
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
	@Deprecated
	public Event(Date time, String place, Integer duration) {
		this("", time, place, duration);
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
	public Event(String name, Date time, String place, Integer duration) {
		this.name = name;
		this.place = place;
		this.time = time;
		this.duration = duration;

		this.eventHistory = new HashMap<Date, Event>();
		this.permissions = new HashMap<Method, ArrayList<Permission>>();
		this.roles = new HashMap<Authenticatable, Permission>();

		this.initPermissions();
	}

	/**
	 * @return the place of the event
	 */
	public String getPlace() {

		return this.place;
	}

	/**
	 * @return the time when the event takes place
	 */
	public Date getTime() {

		return this.time;
	}

	/**
	 * @return the duration of the event
	 */
	public Integer getDuration() {

		return this.duration;
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

		if (this == o)
			return true;

		if (o == null)
			return false;

		if (!this.getClass().equals(o.getClass()))
			return false;
		if (this.place.equals(((Event) o).place)
				&& this.time.equals(((Event) o).time)
				&& this.duration.equals(((Event) o).duration))
			return true;
		return false;
	}

	public void addToHistory(Event e, Date d) {
		this.eventHistory.put(d, e);
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public HashMap<Date, Event> getEventHistory() {
		return this.eventHistory;
	}

	public abstract void updateEvent(Event e, Date changeDate)
			throws InvalidDateException;

	public abstract void restoreEvent(Date restoreDate, Date currentDate)
			throws InvalidDateException;
}
