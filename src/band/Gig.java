
package band;

import helper.InvalidDateException;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import auth.Authenticatable;

/**
 * Class that contains the pay of a gig. A gig is an event, the event information is stored in event.
 * 
 * @author OOP Gruppe 187
 * 
 * NOTE: this class inherits all pre- and postconditions the interface 
 *       Authenticatable has
 *       
 * GOOD: low object coupling (only depends on date)
 *
 */
public class Gig extends Event {
	
	// INVARIANT: pay >= 0
	private BigDecimal pay;

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the gig (time >= now)
	 * @param place
	 *            the name of the place as a String
	 * @param duration
	 *            the duration of the gig (duration >= 0)
	 * @param pay
	 *            the pay of the gig as BigDecimal (pay >=0)
	 */
	@Deprecated
	public Gig(Date time, String place, Integer duration, BigDecimal pay) {

		this("", time, new Place(place), duration, pay);
	}

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the gig (time >= now)
	 * @param place
	 *            the name of the place as a String
	 * @param duration
	 *            the duration of the gig (duration >= 0)
	 * @param pay
	 *            the pay of the gig as Double (pay >=0)
	 */
	@Deprecated
	public Gig(Date time, String place, Integer duration, Double pay) {

		this("", time, new Place(place), duration, new BigDecimal(pay));
	}

	/**
	 * five param-constructor with place object
	 * 
	 * @param name
	 *            name of the event
	 * @param time
	 *            the time of the gig (time >= now)
	 * @param place
	 *            the place of the gig as Place-object
	 * @param duration
	 *            the duration of the gig (duration >= 0)
	 * @param pay
	 *            the pay of the gig (pay >=0)
	 */
	public Gig(String name, Date time, Place place, Integer duration, BigDecimal pay) {
		this(name, time, place, duration, pay, globalPermissions);
	}
	
	/**
	 * six param-constructor with place object and default permissions
	 * 
	 * @param name
	 *            name of the event
	 * @param time
	 *            the time of the gig (time >= now)
	 * @param place
	 *            the place of the gig as Place-object
	 * @param duration
	 *            the duration of the gig (duration >= 0)
	 * @param pay
	 *            the pay of the gig (pay >=0)
	 * @param defaultPermissions
	 * 			  the default permissions of each method
	 */
	public Gig(String name, Date time, Place place, Integer duration, BigDecimal pay, Permission defaultPermissions) {
		super(name, time, place, duration, defaultPermissions);
		this.pay = pay;
	}

	/**
	 * five param-constructor with place-name
	 * 
	 * @param name
	 *            name of the event
	 * @param time
	 *            the time of the gig (time >= now)
	 * @param place
	 *            the name of the place as a String
	 * @param duration 
	 *            the duration of the gig (duration >= 0)
	 * @param pay
	 *            the pay of the gig (pay >=0)
	 */
	@Deprecated
	public Gig(String name, Date time, String place, Integer duration, BigDecimal pay) {

		this(name, time, new Place(place), duration, pay);
	}

	/**
	 * @param m
	 *            method that is checked
	 * @param p
	 *            permissions that the caller possesses
	 * @return true if the method m can be invoked with the permissions p, otherwise false
	 */
	@Override
	public boolean allowedMethod(Method m, Permission p) {
		// NOTE: Check default permissions
		if(p.equals(defaultPermissions) && !defaultPermissions.equals(Permission.NONE)) {
			return true;
		}

		for (Permission allowed : this.permissions.get(m)) {
			if (allowed.equals(p) || allowed.equals(Permission.WORLD)) { return true; }
		}
		return false;
	}

	/**
	 * compares two gigs
	 * 
	 * @return true if the gigs are equal false otherwise
	 */
	@Override
	public boolean equals(Object o) {

		boolean ret = super.equals(o);

		return ret && this.pay.equals(((Gig) o).pay);
	}

	/**
	 * @return the pay the band gets for the gig
	 */
	@Override
	public BigDecimal getFinances() {

		return this.pay;
	}

	/**
	 * @return a HashMap of methods and their permissions
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
	public Permission getRole(Authenticatable auth) {

		if (this.roles.containsKey(auth)) {
			return this.roles.get(auth);
		}
		else {
			return Permission.NONE;
		}
	}

	/**
	 * @return the HashMap of permissions
	 * 
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
	 */
	@Override
	public HashMap<Authenticatable, Permission> getRoles() {

		return this.roles;
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

		
		ArrayList<Method> methods = new ArrayList<Method>();
		methods.addAll(Arrays.asList(this.getClass().getMethods()));

		ArrayList<Permission> tPerm = new ArrayList<Permission>();
		for (Method m : methods) {
			if ("getFinances".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
			}
			else if ("restoreEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			}
			else if ("updateEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			}

			
			this.permissions.put(m, new ArrayList<Permission>(tPerm));
			tPerm.clear();
		}

		
		this.setRole(this, Permission.OWNER);
	}

	/**
	 * Reverts the Event to the state at @restoreDate and saves the current state with the date @currentDate
	 * restoreDate before currentDate; currentDate == now
	 * 
	 * 
	 * PRECONDITION: currentDate is not null
	 */
	@Override
	public void restoreEvent(Date restoreDate, Date currentDate) throws InvalidDateException {

		Gig oldGig = (Gig) this.getEventHistory().get(restoreDate);
		if (oldGig != null) {
			this.updateEvent(oldGig, currentDate);
		}
		else {
			throw new InvalidDateException("no event found at the specified date");
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
		if(auth != this) {
			this.roles.put(auth, p);
		}
	}

	/**
	 * @return a string representation of a Gig
	 */
	@Override
	public String toString() {

		return super.toString() + " Pay: " + this.pay;
	}

	/**
	 * The current event is stored with @changeDate in history and updated to another event @e.
	 * changeDate after date of last edit
	 * 
	 * PRECONDITION: e is not null
	 */
	@Override
	public void updateEvent(Event e, Date changeDate) throws InvalidDateException {

		for (Date d : this.getEventHistory().keySet()) {
			if (d.after(changeDate)) { throw new InvalidDateException("change date is before last edit"); }
		}

		if (e.getClass() == this.getClass()) {
			Gig newGig = (Gig) e;
			Gig history = new Gig(this.getTime(), this.getPlace(), this.getDuration(), this.pay);
			this.addToHistory(history, changeDate);

			this.setTime(newGig.getTime());
			this.setDuration(newGig.getDuration());
			this.setPlace(newGig.getPlace());
			this.pay = newGig.pay;
		}
		else {
			
		}
	}
}
