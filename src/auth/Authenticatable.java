package auth;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public interface Authenticatable {
	public enum Permissions {
		WORLD() {
			@Override
			public boolean authenticate(Authenticatable auth) {
				return true;
				
			}
		},
		GROUP() {
			@Override
			public boolean authenticate(Authenticatable auth) {
				// TODO Auto-generated method stub
				return false;
				
			}
		},
		OWNER() {
			@Override
			public boolean authenticate(Authenticatable auth) {
				// TODO Auto-generated method stub
				return false;
				
			}
		},
		ADMIN() {
			@Override
			public boolean authenticate(Authenticatable auth) {
				return true;
				
			}
		},
		MANAGEMENT() {
			@Override
			public boolean authenticate(Authenticatable auth) {
				// TODO Auto-generated method stub
				return false;
				
			}
		};
		
		
		
		public abstract boolean authenticate(Authenticatable auth);
	}
	
	
	/**
	 * return true if @auth has the permission to execute @m
	 * @param auth party that wants to execute @m
	 * @param m the method that is being executed
	 * @return true if allowed; false otherwise
	 */
	boolean isAllowed(Authenticatable auth, Method m);
	
	/**
	 * returns all objects that are allowed to access the given object
	 * @return
	 */
	ArrayList<Authenticatable> getAllowed(Object obj);
	
	/**
	 * returns all objects that are allowed to execute the given method
	 * @return
	 */
	ArrayList<Authenticatable> getAllowed(Method obj);
	
	void initPermissions();
	
	Permissions getPermissions(Object obj);
	Permissions getPermissions(Method m);
}
