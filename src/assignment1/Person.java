package assignment1;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import auth.Authenticatable;

public abstract class Person implements Authenticatable {
	// stuff needed for authentication
	HashMap<Method, ArrayList<Permission>> permissions;
	HashMap<Authenticatable, Permission> roles;

	public Person() {
		// TODO Auto-generated constructor stub
		initPermissions();
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
		if(roles.containsKey(auth) && auth.equals(this)) {
			// don't overwrite the own OWNER-permission
		} else {
			roles.put(auth, p);
		}
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
