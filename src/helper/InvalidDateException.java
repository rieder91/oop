
package helper;

/**
 * an InvalidDateException is thrown when a specified date violates the internal consistency of the existing dataset
 * (i.e. overlapping dates)
 * 
 * @author OOP Gruppe 187
 */
public class InvalidDateException extends Exception {

	// Eclipse is naggin'
	private static final long serialVersionUID = 1L;

	/**
	 * default constructor
	 */
	public InvalidDateException() {

	}

	/**
	 * default constructor
	 * 
	 * @param msg
	 *            dbg-message
	 */
	public InvalidDateException(String msg) {

		super(msg);
	}
}
