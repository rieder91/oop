package assignment1;


public class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidDateException() {
		
	}
	
	public InvalidDateException(String msg) {
		super(msg);
	}
}
