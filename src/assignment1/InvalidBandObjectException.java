package assignment1;

public class InvalidBandObjectException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidBandObjectException() {
	}

	public InvalidBandObjectException(String msg) {
		super(msg);
	}
}
