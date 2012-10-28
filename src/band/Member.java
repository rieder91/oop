
package band;

import helper.EventNotification;
import helper.InvalidBandObjectException;
import helper.InvalidDateException;
import helper.Status;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import auth.Authenticatable;

/**
 * Class that contains all the information belonging to a member.
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: the class name is self-explanatory
 */
public class Member extends Person {

	private String firstName;
	private String lastName;
	private String instrument;
	private String telephoneNumber;

	private boolean substituteMember;

	private ArrayList<Band> bands; // INVARIANT: not null
	private ArrayList<Track> repertoire; // INVARIANT: not null
	private ArrayList<Rehearsal> rehersals; // INVARIANT: not null

	private ArrayList<ProposedDate> events; // INVARIANT: not null
	private ArrayList<EventNotification> eventNot; // INVARIANT: not null

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param firstName
	 *            the first name of the member
	 * @param lastName
	 *            the last name of the member
	 * @param instrument
	 *            the instrument of the member
	 * @param telephoneNumber
	 *            the telephone number of the member
	 * 
	 * PRECONDITION: none of the parameter are null
	 */
	@Deprecated
	public Member(final String firstName, final String lastName, final String instrument, final String telephoneNumber) {

		this(firstName, lastName, instrument, telephoneNumber, false);
	}

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param firstName
	 *            the first name of the member
	 * @param lastName
	 *            the last name of the member
	 * @param instrument
	 *            the instrument of the member
	 * @param telephoneNumber
	 *            the telephone number of the member
	 * @param substituteMember
	 *            the substitute status of the member
	 *            true - member is a substitute member
	 *            false - otherwise
	 *            
	 * PRECONDITION: none of the parameter are null
	 */
	public Member(final String firstName, final String lastName, final String instrument, final String telephoneNumber,
			final boolean substituteMember) {

		super();
		this.events = new ArrayList<ProposedDate>();
		this.repertoire = new ArrayList<Track>();
		this.eventNot = new ArrayList<EventNotification>();
		this.rehersals = new ArrayList<Rehearsal>();
		this.bands = new ArrayList<Band>();
		this.telephoneNumber = telephoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;
		this.substituteMember = substituteMember;
		// set the owner to THIS
		this.setRole(this, Permission.OWNER);
	}

	/**
	 * adds a new band to the member
	 * 
	 * @param bnd
	 *            a band the member is in
	 * @throws InvalidBandObjectException
	 *             if the member is already in this band
	 *             
	 * PRECONDITION: bnd is not null
	 * PRECONDITION: the member should not already be in this band
	 */
	public void addBand(Band bnd) throws InvalidBandObjectException {

		if (this.bands.contains(bnd)) { throw new InvalidBandObjectException("Member is already in this band"); }
		this.bands.add(bnd);
	}

	/**
	 * Adds a new proposed date for an event.
	 * 
	 * @param pd
	 *            a time proposal for an event
	 * @throws InvalidBandObjectException
	 *             if the date was already proposed to this member
	 *             
	 * PRECONDITION: pd is not null
	 * PRECONDITION: do not add the same proposal more than one time
	 */
	public void addProposedDate(final ProposedDate pd) throws InvalidBandObjectException {

		if (this.events.indexOf(pd) == -1) {
			this.events.add(pd);
		}
		else {
			throw new InvalidBandObjectException("proposed date aready exists");
		}
	}

	/**
	 * Adds a Rehearsal the Member attended;
	 * 
	 * @param re
	 *            a Rehearsal
	 *            
	 * PRECONDITION: re is not null
	 * PRECONDITION: only add the rehearsal once
	 */
	public void addRehersal(Rehearsal re) {

		this.rehersals.add(re);
	}

	/**
	 * adds a new track to the repertoire of the member
	 * 
	 * @param tr
	 *            (!= null)
	 *            track to be added
	 *            do not add a track two times
	 * @param d
	 *            (!= null)
	 *            the actual date
	 * @throws InvalidBandObjectException
	 *             if the Member already knows the track
	 * @throws InvalidDateException
	 *             if the track is added at a date the track already was in the track list of the band
	 *             
	 * PRECONDITION:tr and d are not null
	 * PRECONDITION:a track could only be added another time if he was deleted before
	 */
	public void addTrack(final Track tr, Date d) throws InvalidDateException, InvalidBandObjectException {

		if (!this.repertoire.contains(tr)) {
			this.repertoire.add(tr);
		}
		else {
			throw new InvalidBandObjectException("Track already exists!");
		}
		for (Band bnd : this.bands) {
			bnd.addTrack(tr, d);
		}
	}

	/**
	 * This method is used to agree/disagree to a proposed Date.
	 * 
	 * @param e
	 *            event you want to agree or disagree
	 * @param agreed
	 *            agree or disagree to the proposed date true - agree false - disagree
	 * @param date
	 * @throws InvalidBandObjectException
	 *             if the event is not in the event list of the member
	 *             
	 * PRECONDITION: none of the parameters are null
	 * PRECONDITION: you can only agree to an event you already added with addProposedDate
	 */
	public void agree(final Event e, final Date date, final boolean agreed) throws InvalidBandObjectException {

		ProposedDate propd = new ProposedDate(e, date);
		if (!this.events.contains(propd)) { throw new InvalidBandObjectException("There is no such event!"); }
		final int idx = this.events.indexOf(propd);
		this.events.get(idx).agree(agreed);
	}

	/**
	 * This method is used to agree/disagree to a proposed Date.
	 * 
	 * @param e
	 *            event you want to agree or disagree
	 * @param reason
	 *            the reason you have agreed or disagreed
	 * @param date
	 *            (!= null)
	 * @param agreed
	 *            agree or disagree to the proposed date
	 *            true - agree
	 *            false - disagree
	 * @throws InvalidBandObjectException
	 *             if the event is not in the event list of the member
	 * 
	 * PRECONDITION: none of the arguments are null
	 * PRECONDITION: you can only agree to an event you already added with addProposedDate
	 */
	public void agree(final Event e, final Date date, final String reason, final boolean agreed)
			throws InvalidBandObjectException {

		ProposedDate propd = new ProposedDate(e, date);
		if (!this.events.contains(propd)) { throw new InvalidBandObjectException("There is no such event!"); }
		final int idx = this.events.indexOf(propd);
		this.events.get(idx).agree(agreed, reason);
	}

	/**
	 * This method is used to agree/disagree to a proposed Date.
	 * 
	 * @param e
	 *            proposed date you want to agree or disagree
	 * @param agreed
	 *            agree or disagree to the proposed date
	 *            true - agree
	 *            false - disagree
	 * @throws InvalidBandObjectException
	 *             if the event is not in the event list of the member
	 *             
	 * PRECONDITION: none of the arguments are null
	 * PRECONDITION: you can only agree to a proposed date you already added with addProposedDate
	 */
	public void agree(ProposedDate e, boolean agreed) throws InvalidBandObjectException {

		if (!this.events.contains(e)) { throw new InvalidBandObjectException("There is no such event!"); }
		final int idx = this.events.indexOf(e);
		this.events.get(idx).agree(agreed);
	}

	/**
	 * This method is used to agree/disagree to a proposed Date.
	 * 
	 * @param e
	 *            proposed date you want to agree or disagree
	 * @param reason
	 *            the reason you have agreed or disagreed
	 * @param agreed
	 *            agree or disagree to the proposed date
	 *            true - agree
	 *            false - disagree
	 * @throws InvalidBandObjectException
	 *             if the event is not in the event list of the member
	 *             
	 * PRECONDITION: none of the arguments are null
	 * PRECONDITION: you can only agree to a proposed date you already added with addProposedDate
	 */
	public void agree(ProposedDate e, final String reason, final boolean agreed) throws InvalidBandObjectException {

		if (!this.events.contains(e)) { throw new InvalidBandObjectException("There is no such event!"); }
		final int idx = this.events.indexOf(e);
		this.events.get(idx).agree(agreed, reason);
	}

	/**
	 * inverts the substitute status of a member.
	 */
	public void changeSubstituteStatus() {

		this.substituteMember = !this.substituteMember;
	}

	/**
	 * compares two members
	 * 
	 * @param obj
	 *            the member to compare with
	 * @return true if the members are equal false otherwise
	 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj) { return true; }
		if (obj == null) { return false; }
		if (!(obj instanceof Member)) { return false; }
		final Member other = (Member) obj;
		if (this.firstName == null) {
			if (other.firstName != null) { return false; }
		}
		else if (!this.firstName.equals(other.firstName)) { return false; }
		if (this.instrument == null) {
			if (other.instrument != null) { return false; }
		}
		else if (!this.instrument.equals(other.instrument)) { return false; }
		if (this.lastName == null) {
			if (other.lastName != null) { return false; }
		}
		else if (!this.lastName.equals(other.lastName)) { return false; }
		if (this.telephoneNumber == null) {
			if (other.telephoneNumber != null) { return false; }
		}
		else if (!this.telephoneNumber.equals(other.telephoneNumber)) { return false; }
		return true;
	}

	/**
	 * @return the firstName of the member
	 */
	public String getFirstName() {

		return this.firstName;
	}

	/**
	 * @return the lastName of the member
	 */
	public String getLastName() {

		return this.lastName;
	}

	/**
	 * used to get the notifications of the member
	 * 
	 * @param all
	 *            true - all notifications
	 *            false - only unread notifications
	 * @return the notifications of the member
	 * 
	 * POSTCONDITION:you always get a ArrayList even if there are no notifications
	 */
	public ArrayList<EventNotification> getNotifications(boolean all) {

		ArrayList<EventNotification> alen = new ArrayList<EventNotification>();
		for (EventNotification en : this.eventNot) {
			if (all || !en.getNotified()) {
				alen.add(en);
				en.setNotified(true);
			}
		}
		return alen;
	}

	/**
	 * @return the permissions-hashmap
	 * 
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
	 */
	@Override
	public HashMap<Method, ArrayList<Permission>> getPermissions() {

		return this.permissions;
	}

	/**
	 * @return the date proposals of the member
	 * 
	 * POSTCONDITION: you always get a ArrayList even if there are no date proposals
	 */
	public ArrayList<ProposedDate> getProposedDates() {

		return this.events;
	}

	/**
	 * @return the rehearsals the member attended
	 * 
	 * POSTCONDITION: you always get a ArrayList even if the member attended no rehearsals
	 */
	public ArrayList<Rehearsal> getRehearsals() {

		return this.rehersals;
	}

	/**
	 * @return a list of rehearsals the Member attended
	 * 
	 * POSTCONDITION: you always get a ArrayList even if the member attended no rehearsals
	 */
	public ArrayList<Rehearsal> getRehersal() {

		return this.rehersals;

	}

	/**
	 * @return the roles-hashmap
	 * 
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
	 */
	@Override
	public HashMap<Authenticatable, Permission> getRoles() {

		return this.roles;
	}

	/**
	 * @return the repertoire of the member
	 * 
	 * POSTCONDITION: you always get a ArrayList even if the member has no tracks
	 */
	public ArrayList<Track> getTracks() {

		return this.repertoire;

	}

	/**
	 * used to get the hash value of a member
	 * 
	 * @return a hash value representing the member
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + (this.firstName == null ? 0 : this.firstName.hashCode());
		result = prime * result + (this.instrument == null ? 0 : this.instrument.hashCode());
		result = prime * result + (this.lastName == null ? 0 : this.lastName.hashCode());
		result = prime * result + (this.telephoneNumber == null ? 0 : this.telephoneNumber.hashCode());
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

		// get all methods of the class; there is NO difference in the
		// permissions of methods with the same name but different arguments
		final ArrayList<Method> methods = new ArrayList<Method>();
		methods.addAll(Arrays.asList(this.getClass().getMethods()));

		final ArrayList<Permission> tPerm = new ArrayList<Permission>();
		for (final Method m : methods) {
			if ("isSubstituteMember".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
				tPerm.add(Permission.MANAGEMENT);
			}
			else if ("agree".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			}
			else if ("addProposedDate".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
				tPerm.add(Permission.MANAGEMENT);
			}
			else if ("addTrack".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			}
			else if ("removeTrack".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			}
			else if ("notifyEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
				tPerm.add(Permission.MANAGEMENT);
			}
			else if ("changeSubstituteStatus".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
				tPerm.add(Permission.MANAGEMENT);
			}
			else if ("getNotifications".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			}
			else if ("agree".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			}
			else if ("addBand".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
				tPerm.add(Permission.MANAGEMENT);
			}

			// save the permissions and reset the temporary list
			this.permissions.put(m, new ArrayList<Permission>(tPerm));
			tPerm.clear();
		}
	}

	/**
	 * used to get the substitute status of a member
	 * 
	 * @return
	 *         true if the member is a substitute member
	 *         false if the member isn't a substitute member
	 */
	public boolean isSubstituteMember() {

		return this.substituteMember;
	}

	/**
	 * Notify a member about the event @e.
	 * 
	 * @param e
	 *            the event, the member should be notified
	 * @param stat
	 *            the status of the event
	 * @throws InvalidBandObjectException
	 *             if the member was already notified about the event
	 *             
	 * PRECONDITION: none of the parameters are null
	 */
	public void notifyEvent(final Event e, final Status stat) throws InvalidBandObjectException {

		if (!this.eventNot.contains(new EventNotification(e, stat))) {
			this.eventNot.add(new EventNotification(e, stat));
		}
	}

	/**
	 * removes @tr from the repertoire of the member
	 * 
	 * @param tr
	 *            (!= null)
	 *            track to be removed
	 * @param d
	 *            (!= null)
	 *            date when the track was removed
	 * @throws InvalidBandObjectException
	 *             if the track does not exist
	 * @throws InvalidDateException
	 *             if the track is removed before is was added
	 *             
	 * PRECONDITION: none of the parameters are null
	 * PRECONDITION: the member must know the track
	 */
	public void removeTrack(final Track tr, Date d) throws InvalidBandObjectException, InvalidDateException {

		int idx;
		if ((idx = this.repertoire.indexOf(tr)) != -1) {
			this.repertoire.remove(idx);
			for (Band bnd : this.bands) {
				bnd.removeTrack(tr, d);
			}
		}
		else {
			throw new InvalidBandObjectException("Track does not exist!");
		}
	}

	/**
	 * used to get a readable representation of a member
	 * 
	 * @return a string representation of an member
	 */
	@Override
	public String toString() {

		final String ret = "First name: " + this.firstName + " Last name: " + this.lastName + " Instrument: "
				+ this.instrument + " Telephone number: " + this.telephoneNumber;
		return ret;
	}
}
