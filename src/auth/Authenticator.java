package auth;

import java.lang.reflect.Method;
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
	public static void checkPermissions(Authenticatable askingAuth, Authenticatable grantingAuth, Method m) throws InsufficientPermissionsException {
		Permission role = grantingAuth.getRole(askingAuth);
		boolean allowed = grantingAuth.allowedMethod(m, role);
		if(!allowed) {
			throw new InsufficientPermissionsException("Not allowed to invoke method");
		}
	}

}
