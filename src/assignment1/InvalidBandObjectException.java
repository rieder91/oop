package assignment1;

/**
 * an InvalidBandObjectException is thrown when an illegal object is being added
 * to the bands members, tracks or events
 * 
 * @author OOP Gruppe 187
 * 
 */
public class InvalidBandObjectException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidBandObjectException() {
	}

	public InvalidBandObjectException(String msg) {
		super(msg);
	}
}
