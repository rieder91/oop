
package helper;

/**
 * an InvalidBandObjectException is thrown when an illegal object is being added to the bands members, tracks or events
 * 
 * @author OOP Gruppe 187
 */
public class InvalidBandObjectException extends Exception {

	// Eclipse is naggin'
	private static final long serialVersionUID = 1L;

	/**
	 * default constructor
	 */
	public InvalidBandObjectException() {

	}

	/**
	 * default constructor
	 * 
	 * @param msg
	 *            dbg-message
	 */
	public InvalidBandObjectException(String msg) {

		super(msg);
	}
}
