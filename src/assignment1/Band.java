package assignment1;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import auth.Authenticatable;

/**
 * Class that contains all the information belonging to the band. Members,
 * tracks and events can be added and removed. There are validity checks for the
 * dates and to avoid duplicate elements.
 * 
 * A history is saved in order to enable queries about the bands' past. There
 * are Getters for Events, Tracks and Members which return all Objects at either
 * a given key date or within a range. A Billing-Method has also been
 * implemented which calculates the bands revenue within a given time frame.
 * 
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Band implements Authenticatable {

	// global band information
	private String name;
	private String genre;

	// contain the current information
	private ArrayList<Event> events;
	private ArrayList<Member> members;
	private ArrayList<Track> tracks;

	// History of deletedEvents
	private HashMap<Event, ArrayList<Date>> previousEvents;

	// contain the "join dates"
	private HashMap<Member, ArrayList<Date>> memberDates;
	private HashMap<Track, ArrayList<Date>> trackDates;

	// contain the "leave dates"
	private HashMap<Member, ArrayList<Date>> previousMembers;
	private HashMap<Track, ArrayList<Date>> previousTracks;

	// authentication stuff
	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;

	/**
	 * Constructor which requires two arguments
	 * 
	 * @param name
	 *            the name of the band
	 * @param genre
	 *            the genre of the band
	 */
	public Band(String name, String genre) {
		this.name = name;
		this.genre = genre;

		this.events = new ArrayList<Event>();
		this.members = new ArrayList<Member>();
		this.tracks = new ArrayList<Track>();

		this.memberDates = new HashMap<Member, ArrayList<Date>>();
		this.trackDates = new HashMap<Track, ArrayList<Date>>();

		this.previousEvents = new HashMap<Event, ArrayList<Date>>();
		this.previousMembers = new HashMap<Member, ArrayList<Date>>();
		this.previousTracks = new HashMap<Track, ArrayList<Date>>();

		this.permissions = new HashMap<Method, ArrayList<Permission>>();
		this.roles = new HashMap<Authenticatable, Permission>();

		this.initPermissions();
	}

	/**
	 * 
	 * @return ArrayList of the current members
	 */
	public ArrayList<Member> getMembers() {
		return this.members;
	}

	/**
	 * 
	 * @return ArrayList of all events
	 */
	public ArrayList<Event> getEvents() {
		return this.events;
	}

	/**
	 * 
	 * @return ArrayList of the current tracks
	 */
	public ArrayList<Track> getTracks() {
		return this.tracks;
	}

	/**
	 * 
	 * @return fancy string for debugging purposes
	 */
	@Override
	public String toString() {
		String ret = "";
		ret += "Band name: " + this.name;
		ret += "\nGenre: " + this.genre;

		ret += "\n\nMembers:\n";
		for (Member m : this.members) {
			ret += m.toString();
			ret += '\n';
		}

		ret += "\nEvents:\n";
		for (Event e : this.events) {
			ret += e.toString();
			ret += '\n';
		}

		ret += "\nTracks:\n";
		for (Track t : this.tracks) {
			ret += t.toString();
			ret += '\n';
		}

		return ret;

	}

	/**
	 * Adds a new Track to the bands repertoire
	 * 
	 * @param t
	 *            the track itself
	 * @param d
	 *            the date the track was added
	 * @throws InvalidDateException
	 *             thrown if the track has already been added AND removed before
	 *             AND the removal date is PRIOR to the new add date
	 * @throws InvalidBandObjectException
	 *             thrown if the track already exists
	 */
	public void addTrack(Track t, Date d) throws InvalidDateException,
			InvalidBandObjectException {
		if (!this.tracks.contains(t)) {
			if (this.trackDates.containsKey(t)) {
				// the track has already been added in the past - we need to add
				// a new date
				ArrayList<Date> history = this.previousTracks.get(t);
				Date removeDate = history.get(history.size() - 1);
				if (removeDate.after(d))
					throw new InvalidDateException(
							"new date prior to last remove date");
				else {
					this.trackDates.get(t).add(d);
					this.tracks.add(t);
				}
			} else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.trackDates.put(t, newHistory);
				this.tracks.add(t);
			}
		} else
			throw new InvalidBandObjectException("track already exists");

	}

	/**
	 * Removes a track from the bands repertoire
	 * 
	 * @param t
	 *            the track to be removed
	 * @param d
	 *            the date the track was removed
	 * @throws InvalidDateException
	 *             thrown if the removal date is prior to the add date
	 * @throws InvalidBandObjectException
	 *             thrown if the track doesnt exist
	 */
	public void removeTrack(Track t, Date d) throws InvalidDateException,
			InvalidBandObjectException {
		ArrayList<Date> history = this.trackDates.get(t);
		Date joinDate = history.get(history.size() - 1);

		if (!this.tracks.contains(t))
			throw new InvalidBandObjectException("track doesnt exist");
		else if (joinDate.after(d))
			throw new InvalidDateException("new date prior to last add date");
		else {
			this.tracks.remove(t);

			if (this.previousTracks.containsKey(t))
				// we need to add a new date to the history
				this.previousTracks.get(t).add(d);
			else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.previousTracks.put(t, newHistory);
			}
		}
	}

	/**
	 * Adds an events to the bands event-log
	 * 
	 * @param e
	 *            event to be added
	 * @throws InvalidBandObjectException
	 *             thrown if the event already exists
	 */
	public void addEvent(Event e) throws InvalidBandObjectException {
		if (!this.events.contains(e)) {
			this.events.add(e);

			for (Member mem : this.members)
				e.setRole(mem, Permission.GROUP);

		} else
			throw new InvalidBandObjectException("event already exists");

	}

	/**
	 * removes an event from the event-log
	 * 
	 * @param e
	 *            event to be removed
	 * @throws InvalidBandObjectException
	 *             thrown if the event doesnt exist
	 */
	public void removeEvent(Event e) throws InvalidBandObjectException {
		if (!this.events.contains(e))
			throw new InvalidBandObjectException("event doesnt exist");
		else {
			this.events.remove(e);

			for (Member mem : this.members)
				e.setRole(mem, Permission.NONE);
		}
	}

	/**
	 * removes an event from the event-log and places it in a history
	 * 
	 * @param e
	 *            event to be removed
	 * @param d
	 *            date of removal
	 * @throws InvalidBandObjectException
	 *             thrown if the event doesnt exist
	 */
	public void removeEvent(Event e, Date d) throws InvalidBandObjectException {
		if (this.events.contains(e)) {
			this.removeEvent(e);
			if (this.previousEvents.containsKey(e))
				this.previousEvents.get(e).add(d);
			else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.previousEvents.put(e, newHistory);
			}
		} else
			throw new InvalidBandObjectException("event doesnt exist");
	}

	/**
	 * 
	 * @param place
	 * @param duration
	 * @param time
	 * @param restoreDate
	 * @throws InvalidDateException
	 * @throws InvalidBandObjectException
	 */
	public void restoreEvent(String place, Integer duration, Date time)
			throws InvalidBandObjectException {
		ArrayList<Event> e;
		e = this.searchEvent(place, duration, time);
		if (!e.isEmpty())
			for (Event rest : e) {
				this.addEvent(rest);
				this.previousEvents.remove(rest);
			}
		else
			throw new InvalidBandObjectException("event doesnt exist");
	}

	/**
	 * 
	 * @param place
	 * @param duration
	 * @param time
	 * @return
	 */
	private ArrayList<Event> searchEvent(String place, Integer duration,
			Date time) {
		ArrayList<Event> ret = new ArrayList<Event>();
		for (Event e : this.previousEvents.keySet())
			if (place.equals(e.getPlace()) && time.equals(e.getTime())
					&& duration.equals(e.getDuration()))
				ret.add(e);
		return ret;
	}

	/**
	 * Adds a member to the bands lineup
	 * 
	 * @param m
	 *            member to be added
	 * @param d
	 *            date the member (re)-joined the band
	 * @throws InvalidDateException
	 *             thrown if the member has already joined AND left the band
	 *             once AND the "leave-date" is after the new join-date
	 * @throws InvalidBandObjectException
	 *             thrown if the member already exists
	 */
	public void addMember(Member m, Date d) throws InvalidDateException,
			InvalidBandObjectException {
		if (!this.members.contains(m)) {
			if (this.memberDates.containsKey(m)) {
				// the member has already been part of the band once before
				// date
				ArrayList<Date> history = this.previousMembers.get(m);
				Date leaveDate = history.get(history.size() - 1);
				if (leaveDate.after(d))
					throw new InvalidDateException(
							"new date prior to last remove date");
				else {
					this.members.add(m);
					this.memberDates.get(m).add(d);
				}
			} else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.memberDates.put(m, newHistory);
				this.members.add(m);
			}

			for (Event e : this.events)
				e.setRole(m, Permission.GROUP);

			for (Member mem : this.members) {
				mem.setRole(m, Permission.GROUP);
				m.setRole(mem, Permission.GROUP);
			}

			this.setRole(m, Permission.GROUP);

		} else
			throw new InvalidBandObjectException("member already exists");
	}

	/**
	 * removes a member from the band
	 * 
	 * @param m
	 *            the member to be removed
	 * @param d
	 *            the date the member left the band
	 * @throws InvalidDateException
	 *             thrown if the "leave-date" of the member is prior to the last
	 *             join date
	 * @throws InvalidBandObjectException
	 *             thrown if the member doesnt exist
	 */
	public void removeMember(Member m, Date d) throws InvalidDateException,
			InvalidBandObjectException {
		ArrayList<Date> history = this.memberDates.get(m);
		Date joinDate = history.get(history.size() - 1);
		if (!this.members.contains(m))
			throw new InvalidBandObjectException("member doesnt exist");
		else if (joinDate.after(d))
			throw new InvalidDateException("new date prior to last add date");
		else {
			this.members.remove(m);

			for (Event e : this.events)
				e.setRole(m, Permission.NONE);

			for (Member mem : this.members) {
				mem.setRole(m, Permission.NONE);
				m.setRole(mem, Permission.NONE);
			}

			this.setRole(m, Permission.NONE);

			if (this.previousMembers.containsKey(m))
				// the member has leave once before
				this.previousMembers.get(m).add(d);
			else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.previousMembers.put(m, newHistory);
			}
		}
	}

	/**
	 * returns all events within a given time period
	 * 
	 * @param d1
	 *            from-date
	 * @param d2
	 *            to-date
	 * @param types
	 *            the types of events that should be returned
	 * @return an ArrayList of all events within the given time period
	 */
	public ArrayList<Event> getEvents(Date d1, Date d2,
			ArrayList<Class<? extends Event>> types)
			throws InvalidDateException {
		ArrayList<Event> ret = new ArrayList<Event>();
		if (d1.after(d2))
			throw new InvalidDateException("from-date AFTER to-date");
		else
			for (Event e : this.events)
				if (types.contains(e.getClass()))
					if (e.getTime().after(d1) && e.getTime().before(d2))
						ret.add(e);
		return ret;
	}

	/**
	 * return the revenue of the band within a given time period
	 * 
	 * @param d1
	 *            from-date
	 * @param d2
	 *            to-date
	 * @return the sum of the costs of all events within the given time period
	 */
	public BigDecimal getBilling(Date d1, Date d2,
			ArrayList<Class<? extends Event>> types)
			throws InvalidDateException {
		BigDecimal ret = new BigDecimal(0.0);
		if (d1.after(d2))
			throw new InvalidDateException("from-date AFTER to-date");
		else
			for (Event e : this.events)
				if (types.contains(e.getClass()))
					if (e.getTime().after(d1) && e.getTime().before(d2))
						ret = ret.add(e.getFinances());
		return ret;
	}

	/**
	 * return the lineup of the band at a given date
	 * 
	 * @param d
	 *            key date
	 * @return an ArrayList of all members that were part of the band on the
	 *         given day
	 */
	public ArrayList<Member> getMembers(Date d) {
		ArrayList<Member> ret = new ArrayList<Member>();

		for (Member m : this.memberDates.keySet()) {
			Date lastValidDate = null;
			for (Date joinDate : this.memberDates.get(m))
				if (joinDate.before(d))
					lastValidDate = joinDate;

			// if he left the group, get the "leave-date" after the
			// lastValidDate
			if (lastValidDate != null && this.previousMembers.containsKey(m))
				for (Date leaveDate : this.previousMembers.get(m))
					if (leaveDate.before(d) && leaveDate.after(lastValidDate))
						lastValidDate = null;

			if (lastValidDate != null)
				ret.add(m);

		}
		return ret;
	}

	/**
	 * return the tracks of the band at a given date
	 * 
	 * @param d
	 *            key date
	 * @return an ArrayList of all the tracks that the band was performing at
	 *         the given date
	 */
	public ArrayList<Track> getTracks(Date d) {
		ArrayList<Track> ret = new ArrayList<Track>();

		for (Track t : this.trackDates.keySet()) {
			Date lastValidDate = null;
			for (Date addDate : this.trackDates.get(t))
				if (addDate.before(d))
					lastValidDate = addDate;

			if (lastValidDate != null && this.previousTracks.containsKey(t))
				for (Date removeDate : this.previousTracks.get(t))
					if (removeDate.before(d) && removeDate.after(lastValidDate))
						lastValidDate = null;

			if (lastValidDate != null)
				ret.add(t);
		}

		return ret;
	}


	/**
	 * initializes the permissions for each method of the class; this method
	 * should be called in the constructor
	 */
	@Override
	public void initPermissions() {
		this.permissions = new HashMap<Method, ArrayList<Permission>>();
		this.roles = new HashMap<Authenticatable, Permission>();

		// get all methods of the class; there is NO difference in the
		// permissions of methods with the same name but different arguments
		ArrayList<Method> methods = new ArrayList<Method>();
		methods.addAll(Arrays.asList(this.getClass().getMethods()));

		ArrayList<Permission> tPerm = new ArrayList<Permission>();
		for (Method m : methods) {
			if ("addEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			} else if ("addMember".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
			} else if ("addTrack".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
			} else if ("getBilling".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
			} else if ("getEvents".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			} else if ("getMembers".equals(m.getName()))
				tPerm.add(Permission.WORLD);
			else if ("getTracks".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			} else if ("removeEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			} else if ("removeMember".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
			} else if ("removeTrack".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
			} else if ("restoreEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			}

			// save the permissions and reset the temporary list
			this.permissions.put(m, new ArrayList<Permission>(tPerm));
			tPerm.clear();
		}

		// set the owner to THIS
		this.setRole(this, Permission.OWNER);
	}

	/**
	 * gets the role of @auth in the context if this object
	 * 
	 * @param auth
	 *            auth-object
	 * @return the permissions of the object
	 */
	@Override
	public Permission getRole(Authenticatable auth) {
		if (this.roles.containsKey(auth))
			return this.roles.get(auth);
		else
			return Permission.NONE;
	}

	/**
	 * sets the role of @auth to @p for this object
	 * 
	 * @param auth
	 *            auth-object
	 * @param p
	 *            target-permission
	 * 
	 */
	@Override
	public void setRole(Authenticatable auth, Permission p) {
		this.roles.put(auth, p);
	}

	/**
	 * @param m
	 *            method that is checked
	 * @param p
	 *            permissions that the caller possesses
	 * @return true if the method m can be invoked with the permissions p
	 */
	@Override
	public boolean allowedMethod(Method m, Permission p) {
		for (Permission allowed : this.permissions.get(m))
			if (allowed.equals(p) || allowed.equals(Permission.WORLD))
				return true;
		return false;
	}
	
	@Override
	public HashMap<Method, ArrayList<Permission>> getPermissions() {
		return permissions;
	}

	@Override
	public HashMap<Authenticatable, Permission> getRoles() {
		return roles;
	}

}
