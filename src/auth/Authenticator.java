
package auth;

import helper.InsufficientPermissionsException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import auth.Authenticatable.Permission;

/**
 * Authenticator class which performs all permissions check prior to function calls
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: the name of the class is self-explanatory
 * 
 * GOOD: the methods are easy to use and type-safe as everything is done using
 * 		 the Autenticatable and Permissions
 */
public class Authenticator {

	/**
	 * @param askingAuth
	 *            the auth wich asks for permission
	 * @param grantingAuth
	 *            the auth from which permission is being asked
	 * @param m
	 *            the method which askingAuth wishes to invoke
	 * @throws InsufficientPermissionsException
	 *             if not allowed to invoke
	 *             
	 * PRECONDITION: the permission of the grantingAuth have already been initialized
	 * PRECONDITION: none of the three arguments is null (harsh condition in my opinion)
	 * 
	 * POSTCONDITION: if there is any error like a non-existing permission or an invalid method
	 * 				  the access is denied by default
	 * 
	 */
	public static void checkPermissions(Authenticatable askingAuth, Authenticatable grantingAuth, Method m)
			throws InsufficientPermissionsException {

		Permission role = grantingAuth.getRole(askingAuth);
		boolean allowed = grantingAuth.allowedMethod(m, role);
		if (!allowed) { throw new InsufficientPermissionsException("Not allowed to invoke method"); }
	}

	/**
	 * debug method for printing the permission of a given auth-obj
	 * 
	 * @param auth
	 *            auth-obj of which the permissions are printed
	 *            
	 * PRECONDITION: the permissions have already been initialized
	 */
	public static void printPermissions(Authenticatable auth) {

		HashMap<Authenticatable, Permission> roles = auth.getRoles();
		System.out.println("\nRoles:");
		for (Authenticatable a : roles.keySet()) {
			System.out.print("[[[" + a.toString() + "]]]: ");
			System.out.println(roles.get(a).toString());
		}

		System.out.println("\nMethods:");
		HashMap<Method, ArrayList<Permission>> permissions = auth.getPermissions();
		for (Method m : permissions.keySet()) {
			if (!permissions.get(m).isEmpty()) {
				System.out.print("[[[" + m.getName() + "]]]: ");
				for (Permission p : permissions.get(m)) {
					System.out.print(p + " ");
				}
				System.out.println();
			}
		}
	}

}
