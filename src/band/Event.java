
package band;

import helper.InvalidDateException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import auth.Authenticatable;

/**
 * used to store information about a event; Event is an abstract class which implements all methods common to both Gig
 * and Rehearsal
 * 
 * @author OOP Gruppe 187
 */
public abstract class Event implements Authenticatable {

	private String name;
	private Place place;
	private Date time;
	private Integer duration;
	private HashMap<Date, Event> eventHistory;
	private ArrayList<Member> attended;

	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;

	public ArrayList<Member> getMember() {

		return this.attended;
	}

	public void setMember(ArrayList<Member> alm) {

		this.attended = alm;
	}

	/**
	 * @return a string representation of a Event
	 */
	@Override
	public String toString() {

		String ret = "Name: " + this.name + " Place: " + this.place.getName() + " Time: " + this.time + " Duration: "
				+ this.duration;
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
	@Deprecated
	public Event(String name, Date time, String place, Integer duration) {

		this(name, time, new Place(place), duration);
	}

	public Event(String name, Date time, Place place, Integer duration) {

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

		return this.place.getName();
	}

	/**
	 * @return
	 */
	public Place getPlaceObj() {

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
	 * @return
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((place == null) ? 0 : place.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		if (!(obj instanceof Event)) { return false; }
		Event other = (Event) obj;
		if (duration == null) {
			if (other.duration != null) { return false; }
		}
		else if (!duration.equals(other.duration)) { return false; }
		if (name == null) {
			if (other.name != null) { return false; }
		}
		else if (!name.equals(other.name)) { return false; }
		if (place == null) {
			if (other.place != null) { return false; }
		}
		else if (!place.equals(other.place)) { return false; }
		if (time == null) {
			if (other.time != null) { return false; }
		}
		else if (!time.equals(other.time)) { return false; }
		return true;
	}

	public void addToHistory(Event e, Date d) {

		this.eventHistory.put(d, e);
	}

	public void setPlace(String place) {

		this.place = new Place(place);
	}

	public void setPlaceObj(Place place) {

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

	public abstract void updateEvent(Event e, Date changeDate) throws InvalidDateException;

	public abstract void restoreEvent(Date restoreDate, Date currentDate) throws InvalidDateException;
}
