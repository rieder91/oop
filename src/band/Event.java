
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
 * 
 * GOOD: low object coupling (only depends on date)
 * 
 */
public abstract class Event implements Authenticatable {

	private String name;
	private Place place;
	private Date time;
	private Integer duration;
	private HashMap<Date, Event> eventHistory;
	private ArrayList<Member> attended;

	// NOTE: Authentication stuff
	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;

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
	 * @param name
	 *            name of the event
	 * @param time
	 *            time of the event
	 * @param place
	 *            place of the event
	 * @param duration
	 *            duration of the event
	 */
	public Event(String name, Date time, Place place, Integer duration) {

		this.name = name;
		this.place = place;
		this.time = time;
		this.duration = duration;

		this.eventHistory = new HashMap<Date, Event>();
		this.permissions = new HashMap<Method, ArrayList<Permission>>();
		this.roles = new HashMap<Authenticatable, Permission>();
		
		// NOTE: calls the child's initPermissions()
		this.initPermissions();
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

	/**
	 * adds a new event to the history
	 * 
	 * @param e
	 *            new event
	 * @param d
	 *            date the event was added
	 *            
	 * PRECONDITION: e and d are not null
	 */
	public void addToHistory(Event e, Date d) {

		this.eventHistory.put(d, e);
	}

	@Override
	public boolean equals(Object obj) {

		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof Event)) { return false; }
		Event other = (Event) obj;
		if (this.duration == null) {
			if (other.duration != null) { return false; }
		}
		else if (!this.duration.equals(other.duration)) { return false; }
		if (this.name == null) {
			if (other.name != null) { return false; }
		}
		else if (!this.name.equals(other.name)) { return false; }
		if (this.place == null) {
			if (other.place != null) { return false; }
		}
		else if (!this.place.equals(other.place)) { return false; }
		if (this.time == null) {
			if (other.time != null) { return false; }
		}
		else if (!this.time.equals(other.time)) { return false; }
		return true;
	}

	/**
	 * @return the duration of the event
	 */
	public Integer getDuration() {

		return this.duration;
	}

	/**
	 * getter for the event-history
	 * 
	 * @return event-history as a hashmap
	 */
	public HashMap<Date, Event> getEventHistory() {

		return this.eventHistory;
	}

	/**
	 * @return the cost/pay of the event
	 */
	public abstract BigDecimal getFinances();

	/**
	 * @return member list
	 */
	public ArrayList<Member> getMember() {

		return this.attended;
	}

	/**
	 * @return the name of the place of the event
	 */
	public String getPlace() {

		return this.place.getName();
	}

	/**
	 * @return place of the event
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

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (this.duration == null ? 0 : this.duration.hashCode());
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		result = prime * result + (this.place == null ? 0 : this.place.hashCode());
		result = prime * result + (this.time == null ? 0 : this.time.hashCode());
		return result;
	}

	/**
	 * restores an event
	 * 
	 * @param restoreDate
	 *            the date of which the state of the event is restored
	 * @param currentDate
	 *            the date the event is being restored
	 * @throws InvalidDateException
	 *             thrown if restoreDate is after currentdate
	 */
	public abstract void restoreEvent(Date restoreDate, Date currentDate) throws InvalidDateException;

	/**
	 * setter for the duration
	 * 
	 * @param duration
	 *            new duration
	 */
	public void setDuration(Integer duration) {

		this.duration = duration;
	}

	/**
	 * sets the member list
	 * 
	 * @param alm
	 *            member list
	 */
	public void setMember(ArrayList<Member> alm) {

		this.attended = alm;
	}

	/**
	 * setter for the place
	 * 
	 * @param place
	 *            new place-name
	 */
	public void setPlace(String place) {

		this.place = new Place(place);
	}

	/**
	 * setter for the place
	 * 
	 * @param place
	 *            new place-object
	 */
	public void setPlaceObj(Place place) {

		this.place = place;
	}

	/**
	 * setter for the time
	 * 
	 * @param time
	 *            new time
	 */
	public void setTime(Date time) {

		this.time = time;
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
	 * updates and event and saves the changes to the history
	 * 
	 * @param e
	 *            new event
	 * @param changeDate
	 *            date the change occured
	 * @throws InvalidDateException
	 *             thrown if the changeDate is before the last edit-date
	 */
	public abstract void updateEvent(Event e, Date changeDate) throws InvalidDateException;
}
