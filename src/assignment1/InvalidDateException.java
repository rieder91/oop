package assignment1;

/**
 * an InvalidDateException is thrown when a specified date violates the internal
 * consistency of the existing dataset (i.e. overlapping dates)
 * 
 * @author OOP Gruppe 187
 * 
 */
public class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidDateException() {

	}

	public InvalidDateException(String msg) {
		super(msg);
	}
}
