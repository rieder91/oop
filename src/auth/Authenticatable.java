
package auth;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * the interface which all objects which are protected by the Authenticator need to implement
 * 
 * @author OOP Gruppe 187
 */
public interface Authenticatable {

	/**
	 * enum which contains all the possible permission groups
	 */
	public enum Permission {
		WORLD, GROUP, OWNER, ADMIN, MANAGEMENT, NONE;
	}

	/**
	 * @param m
	 *            method which is being queries
	 * @param p
	 *            permission group which is checked
	 * @return true if the method can be invoked with the given permission group
	 */
	boolean allowedMethod(Method m, Permission p);

	/**
	 * @return the permissions-hashmap
	 */
	HashMap<Method, ArrayList<Permission>> getPermissions();

	/**
	 * @param auth
	 *            object of which we want the permissions
	 * @return returns the role of @auth in the context of the current object
	 */
	Permission getRole(Authenticatable auth);

	/**
	 * @return the roles-hashmap
	 */
	HashMap<Authenticatable, Permission> getRoles();

	/**
	 * used to initialize the permissions for each method
	 */
	void initPermissions();

	/**
	 * @param auth
	 *            auth-object for which we set the permission group
	 * @param p
	 *            permission group that is being set
	 */
	void setRole(Authenticatable auth, Permission p);
}
