
package assignment1;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import auth.Authenticatable;

/**
 * Class that contains the pay of a gig.
 * 
 * A gig is an event, the event information is stored in event.
 * 
 * @author OOP Gruppe 187
 */
public class Gig extends Event {

	private BigDecimal pay;

	/**
	 * @return a string representation of a Gig
	 */
	@Override
	public String toString() {

		return super.toString() + " Pay: " + this.pay;
	}

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the gig
	 * @param place
	 *            the place of the gig
	 * @param duration
	 *            the duration of the gig
	 * @param pay
	 *            the pay of the gig
	 */
	@Deprecated
	public Gig(Date time, String place, Integer duration, BigDecimal pay) {

		super(time, place, duration);
		this.pay = pay;
	}

	/**
	 * Constructor which requires four arguments
	 * 
	 * @param time
	 *            the time of the gig
	 * @param place
	 *            the place of the gig
	 * @param duration
	 *            the duration of the gig
	 * @param pay
	 *            the pay of the gig
	 */
	@Deprecated
	public Gig(Date time, String place, Integer duration, Double pay) {

		super(time, place, duration);
		this.pay = new BigDecimal(pay);
	}
	
	/**
	 * 
	 * @param name
	 * @param time
	 * @param place
	 * @param duration
	 * @param pay
	 */
	public Gig(String name, Date time, String place, Integer duration, BigDecimal pay) {
		super(name, time, place, duration);
		this.pay = pay;
	}

	/**
	 * @return the pay you get for the gig
	 */
	@Override
	public BigDecimal getFinances() {

		return this.pay;
	}

	/**
	 * compares two gigs
	 * 
	 * @return true if the gigs are equal false otherwise
	 */
	@Override
	public boolean equals(Object o) {

		boolean ret = super.equals(o);

		if (ret && pay.equals(((Gig) o).pay)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void updateEvent(Event e, Date changeDate) throws InvalidDateException {
		for(Date d : getEventHistory().keySet()) {
			if(d.after(changeDate)) {
				throw new InvalidDateException("change date is before last edit");
			}
		}
		
		if(e.getClass() == this.getClass()) {
			Gig newGig = (Gig) e;
			Gig history = new Gig(this.getTime(), this.getPlace(), this.getDuration(), this.pay);
			addToHistory(history, changeDate);
			
			this.setTime(newGig.getTime());
			this.setDuration(newGig.getDuration());
			this.setPlace(newGig.getPlace());
			this.pay = newGig.pay;
		} else {
			// type error
		}
	}

	@Override
	/**
	 * Reverts the Event to the state at @restoreDate and saves the current state with the date @currentDate
	 * 
	 */
	public void restoreEvent(Date restoreDate, Date currentDate) throws InvalidDateException {
		Gig oldGig = (Gig) getEventHistory().get(restoreDate);
		if(oldGig != null) {
			updateEvent(oldGig, currentDate);
		} else {
			throw new InvalidDateException("no event found at the specified date");
		}
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
			if ("getFinances".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
				tPerm.add(Permission.MANAGEMENT);
			} else if ("restoreEvent".equals(m.getName())) {
				tPerm.add(Permission.OWNER);
			} else if ("updateEvent".equals(m.getName())) {
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
