package assignment1;

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
public class Member extends Person implements Authenticatable {

	private String firstName;
	private String lastName;
	private String instrument;
	private String telephoneNumber;
	private ArrayList<ProposedDate> events;
	private ArrayList<Track> repertoire;
	private boolean substituteMember;

	// stuff needed for authentication
	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;

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
	public Member(String firstName, String lastName, String instrument,
			String telephoneNumber, boolean substituteMember) {

		this.telephoneNumber = telephoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;
		this.substituteMember = substituteMember;

		initPermissions();
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
	public Member(String firstName, String lastName, String instrument,
			String telephoneNumber) {

		this.telephoneNumber = telephoneNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.instrument = instrument;

		initPermissions();
	}

	/**
	 * @return a string representation of an member
	 */
	@Override
	public String toString() {

		String ret = "First name: " + this.firstName + " Last name: "
				+ this.lastName + " Instrument: " + this.instrument
				+ " Telephone number: " + this.telephoneNumber;
		return ret;
	}

	/**
	 * @return a hash value representing the track
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = (prime * result)
				+ ((instrument == null) ? 0 : instrument.hashCode());
		result = (prime * result)
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = (prime * result)
				+ ((telephoneNumber == null) ? 0 : telephoneNumber.hashCode());
		return result;
	}

	/**
	 * compares two members
	 * 
	 * @return true if the members are equal false otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Member)) {
			return false;
		}
		Member other = (Member) obj;
		if (firstName == null) {
			if (other.firstName != null) {
				return false;
			}
		} else if (!firstName.equals(other.firstName)) {
			return false;
		}
		if (instrument == null) {
			if (other.instrument != null) {
				return false;
			}
		} else if (!instrument.equals(other.instrument)) {
			return false;
		}
		if (lastName == null) {
			if (other.lastName != null) {
				return false;
			}
		} else if (!lastName.equals(other.lastName)) {
			return false;
		}
		if (telephoneNumber == null) {
			if (other.telephoneNumber != null) {
				return false;
			}
		} else if (!telephoneNumber.equals(other.telephoneNumber)) {
			return false;
		}
		return true;
	}

	/**
	 * This method is used to agree/disagree to a proposed Date.
	 * 
	 * @param e
	 *            event you want to agree or disagree
	 * @param agreed
	 *            agree or disagree to the proposed date true - agree false -
	 *            disagree
	 */
	public void agree(Event e, Date date, boolean agreed) {
		int idx = this.events.indexOf(new ProposedDate(e, date));
		this.events.get(idx).agree(agreed);
	}

	/**
	 * This method is used to agree/disagree to a proposed Date.
	 * 
	 * @param e
	 *            event you want to agree or disagree
	 * @param reason
	 *            the reason you have agreed or disagreed
	 * @param agreed
	 *            agree or disagree to the proposed date true - agree false -
	 *            disagree
	 */
	public void agree(Event e, Date date, String reason, boolean agreed) {
		int idx = this.events.indexOf(new ProposedDate(e, date));
		this.events.get(idx).agree(agreed, reason);
	}

	/**
	 * Adds a new proposed date for an event.
	 * 
	 * @param pd
	 *            a time proposal for an event
	 * @throws InvalidBandObjectException
	 *             if the date was already proposed to this member
	 */
	public void addProposedDate(ProposedDate pd)
			throws InvalidBandObjectException {
		if (this.events.indexOf(pd) == -1)
			this.events.add(pd);
		else
			throw new InvalidBandObjectException("proposed date aready exists");
	}

	/**
	 * adds a new track to the repertoire of the member
	 * 
	 * @param tr
	 *            track to be added
	 */
	public void addTrack(Track tr) {
		if (this.repertoire.indexOf(tr) == -1)
			this.repertoire.add(tr);
	}

	/**
	 * removes a new track from the repertoire of the member
	 * 
	 * @param tr
	 *            track to be removed
	 * @throws InvalidBandObjectException
	 * 
	 */
	public void removeTrack(Track tr) throws InvalidBandObjectException {
		if (this.repertoire.indexOf(tr) == -1)
			this.repertoire.add(tr);
		else
			throw new InvalidBandObjectException("track already in repatoire");
	}

	/**
	 * @return true if the member is a substitute member false if the member
	 *         isn't a substitute member
	 */
	public boolean isSubstituteMember() {
		return this.substituteMember;
	}

	/**
	 * initializes the permissions for each method of the class; this method
	 * should be called in the constructor
	 */
	@Override
	public void initPermissions() {
		permissions = new HashMap<Method, ArrayList<Permission>>();
		roles = new HashMap<Authenticatable, Permission>();

		// get all methods of the class; there is NO difference in the
		// permissions of methods with the same name but different arguments
		ArrayList<Method> methods = new ArrayList<Method>();
		methods.addAll(Arrays.asList(this.getClass().getMethods()));

		ArrayList<Permission> tPerm = new ArrayList<Permission>();
		for (Method m : methods) {
			if ("isSubstituteMember".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
				tPerm.add(Permission.MANAGEMENT);
			} else if ("agree".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			} else if ("addProposedDate".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.GROUP);
				tPerm.add(Permission.MANAGEMENT);
			} else if ("addTrack".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			} else if ("removeTrack".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			}

			// save the permissions and reset the temporary list
			permissions.put(m, new ArrayList<Permission>(tPerm));
			tPerm.clear();
		}

		// set the owner to THIS
		setRole(this, Permission.OWNER);
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
		if (roles.containsKey(auth)) {
			return roles.get(auth);
		} else {
			return Permission.NONE;
		}
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
			roles.put(auth, p);
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
		for (Permission allowed : permissions.get(m)) {
			if (allowed.equals(p) || allowed.equals(Permission.WORLD)) {
				return true;
			}
		}
		return false;
	}

}
