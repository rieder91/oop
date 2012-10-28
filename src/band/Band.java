
package band;

import helper.InvalidBandObjectException;
import helper.InvalidDateException;
import helper.Status;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import auth.Authenticatable;
import finances.FinanceFilter;
import finances.Finances;
import finances.Finances.FinanceTypes;

/**
 * Class that contains all the information belonging to the band. Members, tracks and events can be added and removed.
 * There are validity checks for the dates and to avoid duplicate elements. A history is saved in order to enable
 * queries about the bands' past. There are Getters for Events, Tracks and Members which return all Objects at either a
 * given key date or within a range. A Billing-Method has also been implemented which calculates the bands revenue
 * within a given time frame.
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: the name of the class
 * 
 * BAD: the class depends rather heavily on Event, Member and Track; 
 *      a more generic implementation would have been nice and easier
 *      to expand in the future (this actually was one of the points of
 *      the 2nd assignment which he had to drop due to time constraints)
 *      
 * NOTE: this class inherits all pre- and postconditions the interface 
 *       Authenticatable has
 *      
 */
public class Band implements Authenticatable {

	// NOTE: global band information
	private String name;
	private String genre;

	// NOTE: contain the current information
	private ArrayList<Event> events;
	private ArrayList<Member> members;
	private ArrayList<Track> tracks;

	// NOTE: History of deletedEvents
	private HashMap<Event, ArrayList<Date>> previousEvents;

	// NOTE: contain the "join dates"
	private HashMap<Member, ArrayList<Date>> memberDates;
	private HashMap<Track, ArrayList<Date>> trackDates;

	// NOTE: contain the "leave dates"
	private HashMap<Member, ArrayList<Date>> previousMembers;
	private HashMap<Track, ArrayList<Date>> previousTracks;

	// NOTE: authentication stuff
	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;

	// NOTE: finance handling
	private Finances finances;

	/**
	 * Constructor which requires two arguments
	 * 
	 * @param name
	 *            the name of the band
	 * @param genre
	 *            the genre of the band
	 */
	public Band(final String name, final String genre) {

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

		this.finances = new Finances();

		this.initPermissions();
	}

	/**
	 * Adds an events to the bands event-log
	 * 
	 * @param e
	 *            event to be added
	 * @throws InvalidBandObjectException
	 *             thrown if the event already exists
	 */
	public void addEvent(final Event e) throws InvalidBandObjectException {

		if (!this.events.contains(e)) {
			this.events.add(e);

			ArrayList<Member> alm = new ArrayList<Member>();
			for (Member m : this.members) {
				// NOTE: if ((e instanceof Event)&&)
				alm.add(m);
			}
			e.setMember(alm);

			for (final Member mem : this.members) {
				e.setRole(mem, Permission.GROUP);
				mem.notifyEvent(e, Status.scheduled);
			}
		}
		else {
			throw new InvalidBandObjectException("event already exists");
		}

	}

	/**
	 * the method adds positive @money to income and negative to expense. if @money is zero, nothing will be done.
	 * 
	 * @param currentDate
	 *            date of entry
	 * @param reason
	 *            short info why money was get or spent (i.e. "Merchandise" or "Advertisment")
	 * @param money
	 *            income if positive, expense if negative
	 */
	public void addFinance(final Date currentDate, final String reason, final BigDecimal money) {

		if (money.signum() == 1) {
			this.finances.add(currentDate, reason, money);
		}
		else if (money.signum() == -1) {
			this.finances.subtract(currentDate, reason, money);
		}
	}

	/**
	 * Adds a member to the bands lineup
	 * 
	 * @param m
	 *            member to be added
	 * @param d
	 *            date the member (re)-joined the band
	 * @throws InvalidDateException
	 *             thrown if the member has already joined AND left the band once AND the "leave-date" is after the new
	 *             join-date
	 * @throws InvalidBandObjectException
	 *             thrown if the member already exists
	 */
	public void addMember(final Member m, final Date d) throws InvalidDateException, InvalidBandObjectException {

		if (!this.members.contains(m)) {
			if (this.memberDates.containsKey(m)) {
				// NOTE: the member has already been part of the band once before
				// date
				final ArrayList<Date> history = this.previousMembers.get(m);
				final Date leaveDate = history.get(history.size() - 1);
				if (leaveDate.after(d)) {
					throw new InvalidDateException("new date prior to last remove date");
				}
				else {
					this.members.add(m);
					this.memberDates.get(m).add(d);
					m.addBand(this);
				}
			}
			else {
				ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.memberDates.put(m, newHistory);
				this.members.add(m);
				m.addBand(this);
			}

			for (final Event e : this.events) {
				e.setRole(m, Permission.GROUP);
			}

			for (final Member mem : this.members) {
				mem.setRole(m, Permission.GROUP);
				m.setRole(mem, Permission.GROUP);
			}

			this.setRole(m, Permission.GROUP);

		}
		else {
			throw new InvalidBandObjectException("member already exists");
		}
	}

	/**
	 * this method should only be used in Member
	 * 
	 * @param t
	 *            the track itself
	 * @param d
	 *            the date the track was added
	 * @throws InvalidDateException
	 *             thrown if the track has already been added AND removed before AND the removal date is PRIOR to the
	 *             new add date
	 * @throws InvalidBandObjectException
	 *             thrown if the track already exists
	 */
	// @Deprecated
	public void addTrack(final Track t, final Date d) throws InvalidDateException, InvalidBandObjectException {

		ArrayList<Track> al = new ArrayList<Track>();
		if (this.members.size() > 0) {
			al.addAll(this.members.get(0).getTracks());
			if (this.members.size() > 1) {

				for (final Member m : this.members) {
					al.retainAll(m.getTracks());
				}
			}
		}

		if (al.contains(t) && !this.tracks.contains(t)) {
			if (this.trackDates.containsKey(t)) {
				ArrayList<Date> history = this.previousTracks.get(t);
				Date leaveDate = history.get(history.size() - 1);
				if (leaveDate.after(d)) {
					throw new InvalidDateException("new date prior to last remove date");
				}
				else {
					this.trackDates.get(t).add(d);
				}
			}
			else {
				final ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.trackDates.put(t, newHistory);
			}
		}

		this.tracks = al;
		// NOTE:  else throw new InvalidBandObjectException("track already exists");

	}

	/**
	 * @param m
	 *            method that is checked
	 * @param p
	 *            permissions that the caller possesses
	 * @return true if the method m can be invoked with the permissions p
	 * 
	 * PRECONDITION: permissions does in fact contain the permission for each method
	 */
	@Override
	public boolean allowedMethod(final Method m, final Permission p) {

		for (final Permission allowed : this.permissions.get(m)) {
			if (allowed.equals(p) || allowed.equals(Permission.WORLD)) { return true; }
		}
		return false;
	}

	/**
	 * defer an event
	 * 
	 * @param e
	 *            event to be deferred
	 * @param d
	 *            new date of the Event
	 * @throws InvalidBandObjectException
	 *             thrown if the event doesnt exist
	 */
	public void deferreEvent(final Event e, final Date d) throws InvalidBandObjectException {

		if (!this.events.contains(e)) {
			throw new InvalidBandObjectException("event doesnt exist");
		}
		else {
			this.events.get(this.events.indexOf(e)).setTime(d);

			for (final Member mem : this.members) {
				e.setRole(mem, Permission.NONE);
				mem.notifyEvent(e, Status.deferred);
			}
		}
	}

	/**
	 * compares two bands
	 * 
	 * @return true if the bands are equal false otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof Band)) { return false; }
		Band other = (Band) obj;
		if (this.events == null) {
			if (other.events != null) { return false; }
		}
		else if (!this.events.equals(other.events)) { return false; }
		if (this.finances == null) {
			if (other.finances != null) { return false; }
		}
		else if (!this.finances.equals(other.finances)) { return false; }
		if (this.genre == null) {
			if (other.genre != null) { return false; }
		}
		else if (!this.genre.equals(other.genre)) { return false; }
		if (this.memberDates == null) {
			if (other.memberDates != null) { return false; }
		}
		else if (!this.memberDates.equals(other.memberDates)) { return false; }
		if (this.members == null) {
			if (other.members != null) { return false; }
		}
		else if (!this.members.equals(other.members)) { return false; }
		if (this.name == null) {
			if (other.name != null) { return false; }
		}
		else if (!this.name.equals(other.name)) { return false; }
		if (this.permissions == null) {
			if (other.permissions != null) { return false; }
		}
		else if (!this.permissions.equals(other.permissions)) { return false; }
		if (this.previousEvents == null) {
			if (other.previousEvents != null) { return false; }
		}
		else if (!this.previousEvents.equals(other.previousEvents)) { return false; }
		if (this.previousMembers == null) {
			if (other.previousMembers != null) { return false; }
		}
		else if (!this.previousMembers.equals(other.previousMembers)) { return false; }
		if (this.previousTracks == null) {
			if (other.previousTracks != null) { return false; }
		}
		else if (!this.previousTracks.equals(other.previousTracks)) { return false; }
		if (this.roles == null) {
			if (other.roles != null) { return false; }
		}
		else if (!this.roles.equals(other.roles)) { return false; }
		if (this.trackDates == null) {
			if (other.trackDates != null) { return false; }
		}
		else if (!this.trackDates.equals(other.trackDates)) { return false; }
		if (this.tracks == null) {
			if (other.tracks != null) { return false; }
		}
		else if (!this.tracks.equals(other.tracks)) { return false; }
		return true;
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
	public BigDecimal getBilling(final Date d1, final Date d2, final ArrayList<Class<? extends Event>> types)
			throws InvalidDateException {

		BigDecimal ret = new BigDecimal(0.0);
		if (d1.after(d2)) {
			throw new InvalidDateException("from-date AFTER to-date");
		}
		else {
			for (final Event e : this.events) {
				if (types.contains(e.getClass())) {
					if (e.getTime().after(d1) && e.getTime().before(d2)) {
						ret = ret.add(e.getFinances());
					}
				}
			}
		}
		return ret;
	}

	/**
	 * @return ArrayList of all events
	 */
	public ArrayList<Event> getEvents() {

		return this.events;
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
	public ArrayList<Event> getEvents(final Date d1, final Date d2, final ArrayList<Class<? extends Event>> types)
			throws InvalidDateException {

		final ArrayList<Event> ret = new ArrayList<Event>();
		if (d1.after(d2)) {
			throw new InvalidDateException("from-date AFTER to-date");
		}
		else {
			for (final Event e : this.events) {
				if (types.contains(e.getClass())) {
					if (e.getTime().after(d1) && e.getTime().before(d2)) {
						ret.add(e);
					}
				}
			}
		}
		return ret;
	}

	/**
	 * with the use of a filter it is possible to get income/expense/total of various reasons in a specified period at
	 * once
	 * 
	 * @param f
	 *            a filter used for enhanced search
	 * @return a string with the specified filter information
	 */
	public HashMap<FinanceTypes, BigDecimal> getFinancesFiltered(final FinanceFilter f) {

		HashMap<FinanceTypes, BigDecimal> ret = new HashMap<FinanceTypes, BigDecimal>();
		BigDecimal tmp;
		BigDecimal total = new BigDecimal(0);

		final Date startDate = f.getStartDate();
		final Date endDate = f.getEndDate();

		tmp = new BigDecimal(0);
		for (final Date d : this.finances.getIncome().keySet()) {
			if (endDate.before(d)) {
				break;
			}
			if (startDate.before(d) || startDate.equals(d)) {
				for (final String s : f.getReason()) {
					if (this.finances.getIncome().get(d).containsKey(s)) {
						tmp = tmp.add(this.finances.getIncome().get(d).get(s));
					}
				}
			}
		}
		if (f.isIncome()) {
			ret.put(FinanceTypes.Income, tmp);
		}
		total = total.add(tmp);

		tmp = new BigDecimal(0);
		for (final Date d : this.finances.getExpense().keySet()) {
			if (endDate.before(d)) {
				break;
			}
			if (startDate.before(d) || startDate.equals(d)) {
				for (final String s : f.getReason()) {
					if (this.finances.getExpense().get(d).containsKey(s)) {
						tmp = tmp.add(this.finances.getExpense().get(d).get(s));
					}
				}
			}
		}
		if (f.isExpense()) {
			ret.put(FinanceTypes.Expense, tmp);
		}
		total = total.add(tmp);

		if (f.isTotal()) {
			ret.put(FinanceTypes.Turnover, total);
		}
		return ret;
	}

	/**
	 * the turnover of a specified reason in a period
	 * 
	 * @param startDate
	 *            first date of a period
	 * @param endDate
	 *            end date of a period
	 * @param reason
	 *            short info why money was get or spent (i.e. "Merchandise" or "Advertisement")
	 * @return total finances of @reason, 0 if no entries where found
	 */
	public BigDecimal getFinancesSinceUntilOf(final Date startDate, final Date endDate, final String reason) {

		BigDecimal ret = new BigDecimal(0);
		for (final Date d : this.finances.getIncome().keySet()) {
			if (endDate.before(d)) {
				break;
			}
			if (startDate.before(d) || startDate.equals(d)) {
				if (this.finances.getIncome().get(d).containsKey(reason)) {
					ret = ret.add(this.finances.getIncome().get(d).get(reason));
				}
			}
		}
		for (final Date d : this.finances.getExpense().keySet()) {
			if (endDate.before(d)) {
				break;
			}
			if (startDate.before(d) || startDate.equals(d)) {
				if (this.finances.getExpense().get(d).containsKey(reason)) {
					ret = ret.add(this.finances.getExpense().get(d).get(reason));
				}
			}
		}
		return ret;
	}

	/**
	 * @return ArrayList of the current members
	 */
	public ArrayList<Member> getMembers() {

		return this.members;
	}

	/**
	 * used to get all substitute or non substitute member
	 * 
	 * @param substitute
	 *            true - substitute member false - non substitute member
	 * @return ArrayList of the current member
	 */
	public ArrayList<Member> getMembers(boolean substitute) {

		ArrayList<Member> memlist = new ArrayList<Member>();

		for (Member mem : this.members) {
			if (!mem.isSubstituteMember() ^ substitute) {
				memlist.add(mem);
			}
		}

		return memlist;
	}

	/**
	 * return the lineup of the band at a given date
	 * 
	 * @param d
	 *            key date
	 * @return an ArrayList of all members that were part of the band on the given day
	 */
	public ArrayList<Member> getMembers(final Date d) {

		final ArrayList<Member> ret = new ArrayList<Member>();

		for (final Member m : this.memberDates.keySet()) {
			Date lastValidDate = null;
			for (final Date joinDate : this.memberDates.get(m)) {
				if (joinDate.before(d)) {
					lastValidDate = joinDate;
				}
			}

			// NOTE: if he left the group, get the "leave-date" after the
			// lastValidDate
			if (lastValidDate != null && this.previousMembers.containsKey(m)) {
				for (final Date leaveDate : this.previousMembers.get(m)) {
					if (leaveDate.before(d) && leaveDate.after(lastValidDate)) {
						lastValidDate = null;
						break;
					}
				}
			}

			if (lastValidDate != null) {
				ret.add(m);
			}

		}
		return ret;
	}

	/**
	 * used to get all valid member in the specified interval
	 * 
	 * @param numberOfRehearsals
	 *            number of rehearsals the member has to attend minimal
	 * @param from
	 *            start of the time interval
	 * @param to
	 *            end of the time interval
	 * @return all valid member
	 */
	public ArrayList<Member> getMemberWithRehearsals(Integer numberOfRehearsals, Date from, Date to) {

		ArrayList<Member> memlist = new ArrayList<Member>();
		int anz = 0;
		for (Member mem : this.members) {
			anz = 0;
			for (Rehearsal r : mem.getRehearsals()) {
				if (r.getTime().before(to) && r.getTime().after(from)) {
					anz++;
				}

			}
			if (!mem.isSubstituteMember() || anz >= numberOfRehearsals) {
				memlist.add(mem);
			}
		}
		return memlist;
	}
	
	/*
	 * (non-Javadoc)
	 * @see auth.Authenticatable#getPermissions()
	 * 
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
	 */
	@Override
	public HashMap<Method, ArrayList<Permission>> getPermissions() {

		return this.permissions;
	}

	/**
	 * gets the role of @auth in the context if this object
	 * 
	 * @param auth
	 *            auth-object
	 * @return the permissions of the object
	 * 
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
	 */
	@Override
	public Permission getRole(final Authenticatable auth) {

		if (this.roles.containsKey(auth)) {
			return this.roles.get(auth);
		}
		else {
			return Permission.NONE;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see auth.Authenticatable#getRoles()
	 * 
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
	 * 
	 */
	@Override
	public HashMap<Authenticatable, Permission> getRoles() {

		return this.roles;
	}

	/**
	 * @return ArrayList of the current tracks
	 */
	public ArrayList<Track> getTracks() {

		return this.tracks;
	}

	/**
	 * return the tracks of the band at a given date
	 * 
	 * @param d
	 *            key date
	 * @return an ArrayList of all the tracks that the band was performing at the given date
	 */
	public ArrayList<Track> getTracks(Date d) {

		ArrayList<Track> ret = new ArrayList<Track>();

		for (final Track t : this.trackDates.keySet()) {
			Date lastValidDate = null;
			for (Date addDate : this.trackDates.get(t)) {
				if (addDate.before(d)) {
					lastValidDate = addDate;
				}
			}

			if (lastValidDate != null && this.previousTracks.containsKey(t)) {
				for (Date removeDate : this.previousTracks.get(t)) {
					if (removeDate.before(d) && removeDate.after(lastValidDate)) {
						lastValidDate = null;
						break;
					}
				}
			}

			if (lastValidDate != null) {
				ret.add(t);
			}
		}

		return ret;
	}

	/**
	 * @param d
	 * @param min
	 *            number of rehersals the member should have attendet since @d
	 * @return all valid members
	 */
	public ArrayList<Member> getValidMember(Date d, int min) {

		ArrayList<Member> val = new ArrayList<Member>();
		int anz = 0;
		for (Member mem : this.members) {
			for (Rehearsal re : mem.getRehersal()) {
				if (re.getTime().after(d)) {
					anz++;
				}
			}
			if (anz >= min) {
				val.add(mem);
			}
			anz = 0;
		}
		return val;
	}

	/**
	 * @return a hash code representation of the band
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (this.events == null ? 0 : this.events.hashCode());
		result = prime * result + (this.finances == null ? 0 : this.finances.hashCode());
		result = prime * result + (this.genre == null ? 0 : this.genre.hashCode());
		result = prime * result + (this.memberDates == null ? 0 : this.memberDates.hashCode());
		result = prime * result + (this.members == null ? 0 : this.members.hashCode());
		result = prime * result + (this.name == null ? 0 : this.name.hashCode());
		result = prime * result + (this.permissions == null ? 0 : this.permissions.hashCode());
		result = prime * result + (this.previousEvents == null ? 0 : this.previousEvents.hashCode());
		result = prime * result + (this.previousMembers == null ? 0 : this.previousMembers.hashCode());
		result = prime * result + (this.previousTracks == null ? 0 : this.previousTracks.hashCode());
		result = prime * result + (this.roles == null ? 0 : this.roles.hashCode());
		result = prime * result + (this.trackDates == null ? 0 : this.trackDates.hashCode());
		result = prime * result + (this.tracks == null ? 0 : this.tracks.hashCode());
		return result;
	}

	/**
	 * initializes the permissions for each method of the class; this method should be called in the constructor
	 * 
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
	 */
	@Override
	public void initPermissions() {

		this.permissions = new HashMap<Method, ArrayList<Permission>>();
		this.roles = new HashMap<Authenticatable, Permission>();

		// NOTE: get all methods of the class; there is NO difference in the
		// permissions of methods with the same name but different arguments
		final ArrayList<Method> methods = new ArrayList<Method>();
		methods.addAll(Arrays.asList(this.getClass().getMethods()));

		final ArrayList<Permission> tPerm = new ArrayList<Permission>();
		for (final Method m : methods) {
			if ("addEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			}
			else if ("addMember".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
			}
			else if ("getBilling".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
			}
			else if ("getEvents".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			}
			else if ("getMembers".equals(m.getName())) {
				tPerm.add(Permission.WORLD);
			}
			else if ("getTracks".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			}
			else if ("removeEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			}
			else if ("removeMember".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
			}
			else if ("restoreEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
				tPerm.add(Permission.GROUP);
			}
			else if ("getValidMember".equals(m.getName())) {
				tPerm.add(Permission.WORLD);
			}

			// NOTE: save the permissions and reset the temporary list
			this.permissions.put(m, new ArrayList<Permission>(tPerm));
			tPerm.clear();
		}

		// NOTE: set the owner to THIS
		this.setRole(this, Permission.OWNER);
	}

	/**
	 * removes an event from the event-log
	 * 
	 * @param e
	 *            event to be removed
	 * @throws InvalidBandObjectException
	 *             thrown if the event doesnt exist
	 */
	public void removeEvent(final Event e) throws InvalidBandObjectException {

		if (!this.events.contains(e)) {
			throw new InvalidBandObjectException("event doesnt exist");
		}
		else {
			this.events.remove(e);

			for (final Member mem : this.members) {
				e.setRole(mem, Permission.NONE);
				mem.notifyEvent(e, Status.canceled);
			}
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
	public void removeEvent(final Event e, final Date d) throws InvalidBandObjectException {

		if (this.events.contains(e)) {
			this.removeEvent(e);
			if (this.previousEvents.containsKey(e)) {
				this.previousEvents.get(e).add(d);
			}
			else {
				final ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.previousEvents.put(e, newHistory);
			}
		}
		else {
			throw new InvalidBandObjectException("event doesnt exist");
		}
	}

	/**
	 * removes a member from the band
	 * 
	 * @param m
	 *            the member to be removed
	 * @param d
	 *            the date the member left the band
	 * @throws InvalidDateException
	 *             thrown if the "leave-date" of the member is prior to the last join date
	 * @throws InvalidBandObjectException
	 *             thrown if the member doesnt exist
	 */
	public void removeMember(final Member m, final Date d) throws InvalidDateException, InvalidBandObjectException {

		final ArrayList<Date> history = this.memberDates.get(m);
		final Date joinDate = history.get(history.size() - 1);
		if (!this.members.contains(m)) {
			throw new InvalidBandObjectException("member doesnt exist");
		}
		else if (joinDate.after(d)) {
			throw new InvalidDateException("new date prior to last add date");
		}
		else {
			this.members.remove(m);

			for (final Event e : this.events) {
				e.setRole(m, Permission.NONE);
			}

			for (final Member mem : this.members) {
				mem.setRole(m, Permission.NONE);
				m.setRole(mem, Permission.NONE);
			}

			this.setRole(m, Permission.NONE);

			if (this.previousMembers.containsKey(m)) {
				// the member has leave once before
				this.previousMembers.get(m).add(d);
			}
			else {
				final ArrayList<Date> newHistory = new ArrayList<Date>();
				newHistory.add(d);
				this.previousMembers.put(m, newHistory);
			}
		}
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
	// @Deprecated
	public void removeTrack(Track t, Date d) throws InvalidDateException, InvalidBandObjectException {

		ArrayList<Track> al = new ArrayList<Track>();
		if (this.members.size() > 0) {
			al.addAll(this.members.get(0).getTracks());
			if (this.members.size() > 1) {

				for (final Member m : this.members) {
					al.retainAll(m.getTracks());
				}
			}
		}

		ArrayList<Date> history = this.trackDates.get(t);
		if (history != null && history.size() - 1 >= 0) {
			final Date joinDate = history.get(history.size() - 1);

			if (this.tracks.contains(t) && joinDate.after(d)) {
				throw new InvalidDateException("new date prior to last add date");
			}
			else {

				if (this.previousTracks.containsKey(t)) {
					// NOTE: we need to add a new date to the history
					this.previousTracks.get(t).add(d);
				}
				else {
					final ArrayList<Date> newHistory = new ArrayList<Date>();
					newHistory.add(d);
					this.previousTracks.put(t, newHistory);
				}
			}
		}

		this.tracks = al;
	}

	/**
	 * searches and restores an event; if more than one event matches the criterea, all events are restored
	 * 
	 * @param place
	 *            place the event took place
	 * @param duration
	 *            duration of the event
	 * @param time
	 *            the time the even took place
	 * @throws InvalidBandObjectException
	 *             thrown if no event is found
	 */
	public void restoreEvent(final String place, final Integer duration, final Date time)
			throws InvalidBandObjectException {

		ArrayList<Event> e;
		e = this.searchEvent(place, duration, time);
		if (!e.isEmpty()) {
			for (final Event rest : e) {
				this.addEvent(rest);
				this.previousEvents.remove(rest);
			}
		}
		else {
			throw new InvalidBandObjectException("event doesnt exist");
		}
	}

	/**
	 * searches for events using different params
	 * 
	 * @param place
	 *            place the event took place
	 * @param duration
	 *            duration of the event
	 * @param time
	 *            the time the even took place
	 * @return arraylist of all events that match the criterea
	 */
	private ArrayList<Event> searchEvent(final String place, final Integer duration, final Date time) {

		final ArrayList<Event> ret = new ArrayList<Event>();
		for (final Event e : this.previousEvents.keySet()) {
			if (place.equals(e.getPlace()) && time.equals(e.getTime()) && duration.equals(e.getDuration())) {
				ret.add(e);
			}
		}
		return ret;
	}

	/**
	 * sets the role of @auth to @p for this object
	 * 
	 * @param auth
	 *            auth-object
	 * @param p
	 *            target-permission
	 *            
	 * BAD: this method actually violates the inherited POSTCONDITION as Permissions
	 * 		of a Band-object on itself could be set to NONE
	 */
	@Override
	public void setRole(final Authenticatable auth, final Permission p) {

		this.roles.put(auth, p);
	}

	/**
	 * @return fancy string for debugging purposes
	 */
	@Override
	public String toString() {

		String ret = "";
		ret += "Band name: " + this.name;
		ret += "\nGenre: " + this.genre;

		ret += "\n\nMembers:\n";
		for (final Member m : this.members) {
			ret += m.toString();
			ret += '\n';
		}

		ret += "\nEvents:\n";
		for (final Event e : this.events) {
			ret += e.toString();
			ret += '\n';
		}

		ret += "\nTracks:\n";
		for (final Track t : this.tracks) {
			ret += t.toString();
			ret += '\n';
		}

		return ret;

	}

	/**
	 * total expense of events since first entry of a band
	 * 
	 * @return total expense of events
	 */
	public BigDecimal totalEventExpense() {

		BigDecimal ret = new BigDecimal(0);
		for (final Event e : this.getEvents()) {
			if (e.getFinances().signum() == -1) {
				ret = ret.add(e.getFinances());
			}
		}
		return ret;
	}

	/**
	 * total income of events since first entry of a band
	 * 
	 * @return total income of events
	 */
	public BigDecimal totalEventIncome() {

		BigDecimal ret = new BigDecimal(0);
		for (final Event e : this.getEvents()) {
			if (e.getFinances().signum() == 1) {
				ret = ret.add(e.getFinances());
			}
		}
		return ret;
	}

	/**
	 * total turnover of events and others since first entry of a band
	 * 
	 * @return total turnover
	 */
	public BigDecimal totalTurnover() {

		BigDecimal eventTurnover = new BigDecimal(0);
		for (final Event e : this.getEvents()) {
			eventTurnover = eventTurnover.add(e.getFinances());
		}
		return eventTurnover.add(this.finances.turnover());
	}
}
