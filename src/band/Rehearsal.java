
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
 * Class that contains the cost of a rehearsal. A rehearsal is an event, the event information is stored in event.
 * 
 * @author OOP Gruppe 187
 * 
 * NOTE: this class inherits all pre- and postconditions the interface 
 *       Authenticatable has
 */
public class Rehearsal extends Event {
	// INVARIANT: cost <= 0
	private BigDecimal cost;
	

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the rehearsal (time >= now)
	 * @param place
	 *            the name of the place as a String
	 * @param duration
	 *            the duration of the rehearsal (duration >= 0)
	 * @param cost
	 *            the costs of the rehearsal as BigDecimal (cost <= 0)
	 */
	@Deprecated
	public Rehearsal(Date time, String place, Integer duration, BigDecimal cost) {

		this("", time, new Place(place), duration, cost);
	}

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the rehearsal (time >= now)
	 * @param place
	 *            the name of the place as a String
	 * @param duration
	 *            the duration of the rehearsal (duration >= 0)
	 * @param cost
	 *            the costs of the rehearsal as Double (cost <= 0)
	 */
	@Deprecated
	public Rehearsal(Date time, String place, Integer duration, Double cost) {

		this("", time, new Place(place), duration, new BigDecimal(cost));
	}

	/**
	 * five param-constructor with place object
	 * 
	 * @param name
	 *            name of the event
	 * @param time
	 *            the time of the rehearsal (time >= now)
	 * @param place
	 *            the place of the rehearsal as Place-object
	 * @param duration
	 *            the duration of the rehearsal (duration >= 0)
	 * @param cost
	 *            the pay of the rehearsal (cost <=0)
	 */
	public Rehearsal(String name, Date time, Place place, Integer duration, BigDecimal cost) {

		super(name, time, place, duration);
		this.cost = cost;
	}

	/**
	 * five param-constructor with place-name
	 * 
	 * @param name
	 *            name of the event
	 * @param time
	 *            the time of the rehearsal (time >= now)
	 * @param place
	 *            the name of the place as a String
	 * @param duration 
	 *            the duration of the rehearsal (duration >= 0)
	 * @param cost
	 *            the pay of the rehearsal (cost <=0)
	 */
	@Deprecated
	public Rehearsal(String name, Date time, String place, Integer duration, BigDecimal cost) {

		this(name, time, new Place(place), duration, cost);
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

		for (Permission allowed : this.permissions.get(m)) {
			if (allowed.equals(p) || allowed.equals(Permission.WORLD)) { return true; }
		}
		return false;
	}

	/**
	 * compares two rehearsals
	 * 
	 * @return true if the rehearsals are equal false otherwise
	 */
	@Override
	public boolean equals(Object o) {

		boolean ret = super.equals(o);

		return ret && this.cost.equals(((Rehearsal) o).cost);
	}

	/**
	 * @return the cost of the rehearsal
	 */
	@Override
	public BigDecimal getFinances() {

		return this.cost.multiply(new BigDecimal(-1.0));
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
	 */
	@Override
	public void restoreEvent(Date restoreDate, Date currentDate) throws InvalidDateException {

		Rehearsal oldGig = (Rehearsal) this.getEventHistory().get(restoreDate);
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
	 * BAD: this method actually violates the inherited POSTCONDITION as Permissions
	 * 		of a Band-object on itself could be set to NONE
	 */
	@Override
	public void setRole(Authenticatable auth, Permission p) {

		this.roles.put(auth, p);
	}

	/**
	 * @return a string representation of a rehearsal
	 */
	@Override
	public String toString() {

		return super.toString() + " Costs: " + this.cost;
	}

	/**
	 * The current event is stored with @changeDate in history and updated to another event @e.
	 * changeDate after date of last edit
	 */
	@Override
	public void updateEvent(Event e, Date changeDate) throws InvalidDateException {

		for (Date d : this.getEventHistory().keySet()) {
			if (d.after(changeDate)) { throw new InvalidDateException("change date is before last edit"); }
		}

		if (e.getClass() == this.getClass()) {
			Rehearsal newRehearsal = (Rehearsal) e;
			Rehearsal history = new Rehearsal(this.getTime(), this.getPlace(), this.getDuration(), this.cost);
			this.addToHistory(history, changeDate);

			this.setTime(newRehearsal.getTime());
			this.setDuration(newRehearsal.getDuration());
			this.setPlace(newRehearsal.getPlace());
			this.cost = newRehearsal.cost;
		}
		else {
			
		}
	}

}
