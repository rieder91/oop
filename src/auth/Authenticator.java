
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
