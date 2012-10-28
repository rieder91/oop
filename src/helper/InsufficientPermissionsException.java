
package helper;

/**
 * This exception is thrown if someone tries to invoke a method with insufficient privileges
 * 
 * @author OOP Gruppe 187
 * 
 * GOOD: name of the class
 * GOOD: low object coupling (obviously - it's an exception after all)
 */
public class InsufficientPermissionsException extends Exception {

	/**
	 * Eclipse is naggin'
	 */
	private static final long serialVersionUID = 1L;

	public InsufficientPermissionsException() {

	}

	public InsufficientPermissionsException(String arg0) {

		super(arg0);
	}

	public InsufficientPermissionsException(String arg0, Throwable arg1) {

		super(arg0, arg1);
	}

	public InsufficientPermissionsException(Throwable arg0) {

		super(arg0);
	}

}
