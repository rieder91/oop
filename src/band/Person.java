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
 */
public abstract class Person implements Authenticatable {
	// stuff needed for authentication
	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;

	public Person() {
		this.initPermissions();
	}

	/**
	 * initializes the permissions for each method of the class; this method
	 * should be called in the constructor
	 */
	@Override
	public abstract void initPermissions();

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
		if (this.roles.containsKey(auth) && auth.equals(this)) {
			// don't overwrite the own OWNER-permission
		} else
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

}
