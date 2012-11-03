
package band;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import auth.Authenticatable;

/**
 * class which all human beings share; used to simplify permission management
 * 
 * @author OOP Gruppe 187
 * 
 * NOTE: this class inherits all pre- and postconditions the interface 
 *       Authenticatable has
 * 
 * GOOD: this class create an abstraction layer for all humans and makes them
 * 		 automatically Authenticatable; this makes it easy to implement another 
 * 		 class like Manager or Fan
 */
public abstract class Person implements Authenticatable {

	// NOTE: stuff needed for authentication
	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;
	
	// NOTE: permissions for every method
	Permission defaultPermissions;

	public Person() {
		this.initPermissions();
	}

	/**
	 * @param m
	 *            method that is checked
	 * @param p
	 *            permissions that the caller possesses
	 * @return true if the method m can be invoked with the permissions p
	 * 
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
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
	 * initializes the permissions for each method of the class; this method should be called in the constructor
	 */
	@Override
	public abstract void initPermissions();

	/**
	 * sets the role of @auth to @p for this object
	 * 
	 * @param auth
	 *            auth-object
	 * @param p
	 *            target-permission
	 *            
	 * GOOD: the method doesn't violate it's inherited CONDITIONS
	 */
	@Override
	public void setRole(Authenticatable auth, Permission p) {

		if (this.roles.containsKey(auth) && auth.equals(this)) {
			// NOTE: don't overwrite the own OWNER-permission
		}
		else {
			this.roles.put(auth, p);
		}
	}

}
