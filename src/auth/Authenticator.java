package auth;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

import auth.Authenticatable.Permission;

/**
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Authenticator {

	/**
	 * 
	 * @param askingAuth
	 * @param grantingAuth
	 * @param m
	 * @throws InsufficientPermissionsException
	 */
	public static void checkPermissions(Authenticatable askingAuth,
			Authenticatable grantingAuth, Method m)
					throws InsufficientPermissionsException {
		Permission role = grantingAuth.getRole(askingAuth);
		boolean allowed = grantingAuth.allowedMethod(m, role);
		if (!allowed)
			throw new InsufficientPermissionsException(
					"Not allowed to invoke method");
	}

	public static void printPermissions(Authenticatable auth) {
		HashMap<Authenticatable, Permission> roles = auth.getRoles();
		System.out.println("\nRoles:");
		for (Authenticatable a : roles.keySet()) {
			System.out.print("[[[" + a.toString() + "]]]: ");
			System.out.println(roles.get(a).toString());
		}

		System.out.println("\nMethods:");
		HashMap<Method, ArrayList<Permission>> permissions = auth
				.getPermissions();
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
