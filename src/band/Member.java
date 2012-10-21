
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
 */
public class Member extends Person {

	private String firstName;
	private String lastName;
	private String instrument;
	private String telephoneNumber;
	private ArrayList<ProposedDate> events;
	private ArrayList<Track> repertoire;
	private boolean substituteMember;
	private ArrayList<EventNotification> eventNot;
	private ArrayList<Rehearsal> rehersals;
	private ArrayList<Band> bands;

	/**
	 * @return the repertoire of the member
	 */
	public ArrayList<Track> getTracks() {

		return this.repertoire;

	}

	/**
	 * @param bnd
	 * @throws InvalidBandObjectException
	 *             if the member is already in this band
	 */
	public void addBand(Band bnd) throws InvalidBandObjectException {

		if (this.bands.contains(bnd)) throw new InvalidBandObjectException("Member is already in this band");
		this.bands.add(bnd);
	}

	/**
	 * Adds a Rehearsal the Member attended;
	 * 
	 * @param re
	 *            a Rehearsal
	 */
	public void addRehersal(Rehearsal re) {

		this.rehersals.add(re);
	}

	/**
	 * @return a list of rehearsals the Member attended
	 */
	public ArrayList<Rehearsal> getRehersal() {

		return this.rehersals;

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
	 * Adds a new proposed date for an event.
	 * 
	 * @param pd
	 *            a time proposal for an event
	 * @throws InvalidBandObjectException
	 *             if the date was already proposed to this member
	 */
	public void addProposedDate(final ProposedDate pd) throws InvalidBandObjectException {

		if (this.events.indexOf(pd) == -1) {
			this.events.add(pd);
		}
		else throw new InvalidBandObjectException("proposed date aready exists");
	}

	/**
	 * adds a new track to the repertoire of the member
	 * 
	 * @param tr
	 *            track to be added
	 * @param d
	 * @throws InvalidBandObjectException
	 * @throws InvalidDateException
	 */
	public void addTrack(final Track tr, Date d) throws InvalidDateException, InvalidBandObjectException {

		if (!this.repertoire.contains(tr)) {
			this.repertoire.add(tr);
		}
		else throw new InvalidBandObjectException("Track already exists!");
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
	 * @throws InvalidBandObjectException
	 */
	public void agree(final Event e, final Date date, final boolean agreed) throws InvalidBandObjectException {

		ProposedDate propd = new ProposedDate(e, date);
		if (!this.events.contains(propd)) throw new InvalidBandObjectException("There is no such event!");
		final int idx = this.events.indexOf(propd);
		this.events.get(idx).agree(agreed);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {

		return this.firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {

		return this.lastName;
	}

	/**
	 * This method is used to agree/disagree to a proposed Date.
	 * 
	 * @param e
	 *            event you want to agree or disagree
	 * @param reason
	 *            the reason you have agreed or disagreed
	 * @param agreed
	 *            agree or disagree to the proposed date true - agree false - disagree
	 * @throws InvalidBandObjectException
	 */
	public void agree(final Event e, final Date date, final String reason, final boolean agreed)
			throws InvalidBandObjectException {

		ProposedDate propd = new ProposedDate(e, date);
		if (!this.events.contains(propd)) throw new InvalidBandObjectException("There is no such event!");
		final int idx = this.events.indexOf(propd);
		this.events.get(idx).agree(agreed, reason);
	}

	/**
	 * compares two members
	 * 
	 * @return true if the members are equal false otherwise
	 */
	@Override
	public boolean equals(final Object obj) {

		if (this == obj) return true;
		if (obj == null) return false;
		if (!(obj instanceof Member)) return false;
		final Member other = (Member) obj;
		if (this.firstName == null) {
			if (other.firstName != null) return false;
		}
		else if (!this.firstName.equals(other.firstName)) return false;
		if (this.instrument == null) {
			if (other.instrument != null) return false;
		}
		else if (!this.instrument.equals(other.instrument)) return false;
		if (this.lastName == null) {
			if (other.lastName != null) return false;
		}
		else if (!this.lastName.equals(other.lastName)) return false;
		if (this.telephoneNumber == null) {
			if (other.telephoneNumber != null) return false;
		}
		else if (!this.telephoneNumber.equals(other.telephoneNumber)) return false;
		return true;
	}

	/**
	 * @param all
	 *            true - all notifications false - only unread notifications
	 * @return the notifications of the member
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

	@Override
	public HashMap<Method, ArrayList<Permission>> getPermissions() {

		return this.permissions;
	}

	@Override
	public HashMap<Authenticatable, Permission> getRoles() {

		return this.roles;
	}

	/**
	 * @return a hash value representing the member
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.firstName == null) ? 0 : this.firstName.hashCode());
		result = (prime * result) + ((this.instrument == null) ? 0 : this.instrument.hashCode());
		result = (prime * result) + ((this.lastName == null) ? 0 : this.lastName.hashCode());
		result = (prime * result) + ((this.telephoneNumber == null) ? 0 : this.telephoneNumber.hashCode());
		return result;
	}

	/**
	 * initializes the permissions for each method of the class; this method should be called in the constructor
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

			// save the permissions and reset the temporary list
			this.permissions.put(m, new ArrayList<Permission>(tPerm));
			tPerm.clear();
		}
	}

	/**
	 * @return true if the member is a substitute member false if the member isn't a substitute member
	 */
	public boolean isSubstituteMember() {

		return this.substituteMember;
	}

	/**
	 * inverts the substitute status of a member.
	 */
	public void changeSubstituteStatus() {

		this.substituteMember = !this.substituteMember;
	}

	/**
	 * Notify a member about the event @e.
	 * 
	 * @param e
	 * @throws InvalidBandObjectException
	 *             if the member was already notified about the event
	 */
	public void notifyEvent(final Event e, final Status stat) throws InvalidBandObjectException {

		if (this.eventNot.contains(new EventNotification(e, stat)))
			//throw new InvalidBandObjectException("Already notified!");
		this.eventNot.add(new EventNotification(e, stat));
	}

	/**
	 * removes a new track from the repertoire of the member
	 * 
	 * @param tr
	 *            track to be removed
	 * @throws InvalidBandObjectException
	 *             if the track does not exist
	 * @throws InvalidDateException
	 */
	public void removeTrack(final Track tr, Date d) throws InvalidBandObjectException, InvalidDateException {

		int idx;
		if ((idx = this.repertoire.indexOf(tr)) != -1) {
			this.repertoire.remove(idx);
			for (Band bnd : this.bands) {
				bnd.removeTrack(tr, d);
			}
		}
		else throw new InvalidBandObjectException("Track does not exist!");
	}

	/**
	 * @return a string representation of an member
	 */
	@Override
	public String toString() {

		final String ret = "First name: " + this.firstName + " Last name: " + this.lastName + " Instrument: "
				+ this.instrument + " Telephone number: " + this.telephoneNumber;
		return ret;
	}
}
