
package auth;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * the interface which all objects which are protected by the Authenticator need to implement
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: the class name is self-explanatory
 * GOOD: weak object-coupling
 */
public interface Authenticatable {

	/**
	 * enum which contains all the possible permission groups
	 * 
	 * BAD: PermissionGroups would be an more accurate description
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
	 * 
	 * PRECONDITION: the implementing class has knowledge of the permissions for each method
	 * 				 it possesses
	 * 
	 * PRECONDITION: m and p are not null
	 * 
	 * POSTCONDITION: if the method doesn't exist or the class has no permissions definied for
	 * 				  it, false is returned
	 */
	boolean allowedMethod(Method m, Permission p);

	/**
	 * @return the permissions-hashmap
	 * 
	 * PRECONDITION: the permissions are somehow known to the implementing class 
	 * 
	 * POSTCONDITION: there is always a valid HashMap returned; if the class has no
	 * 				  permission definied the HashMap is empty and not null
	 */
	HashMap<Method, ArrayList<Permission>> getPermissions();

	/**
	 * @param auth
	 *            object of which we want the permissions
	 * @return returns the role of @auth in the context of the current object
	 * 
	 * POSTCONDITION: the return value is always a permission-object and never null;
	 * 				  if there are no permissions defined for the given Authenticiatable
	 * 				  the default is Permission.NONE
	 */
	Permission getRole(Authenticatable auth);

	/**
	 * @return the roles-hashmap
	 */
	HashMap<Authenticatable, Permission> getRoles();

	/**
	 * used to initialize the permissions for each method
	 * 
	 * POSTCONDITION: the implementing class saves the permissions defined in this method
	 * 
	 * POSTCONDITION: the instance of an object always OWNER-permissions on itself
	 */
	void initPermissions();

	/**
	 * @param auth
	 *            auth-object for which we set the permission group
	 * @param p
	 *            permission group that is being set
	 *            
	 * PRECONDITION: initPermissions has already been run (guaranteed in our 
	 *               case as initPermissions() is called in the constructors)
	 * 
	 * POSTCONDITION: the permission of an object on itself can't be changed to
	 * 				  anything but OWNER
	 * 
	 */
	void setRole(Authenticatable auth, Permission p);
}
