package assignment1;

/**
 * 
 * @author Thomas
 *
 */
@SuppressWarnings("serial")
public class InvalidDateException extends Exception {
	public InvalidDateException() {
		
	}
	
	public InvalidDateException(String msg) {
		super(msg);
	}
}
