package auth;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author OOP Gruppe 187
 * 
 */
public interface Authenticatable {
	public enum Permission {
		WORLD, GROUP, OWNER, ADMIN, MANAGEMENT, NONE;
	}

	void initPermissions();

	Permission getRole(Authenticatable auth);

	boolean allowedMethod(Method m, Permission p);

	void setRole(Authenticatable auth, Permission p);
	
	HashMap<Method, ArrayList<Permission>> getPermissions();
	HashMap<Authenticatable, Permission> getRoles();
}
