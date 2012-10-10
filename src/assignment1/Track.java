package assignment1;

public class Track {

	private Double length;
	private String name;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.name + ": " + this.length;
	}

	/**
	 * 
	 * @param length
	 * @param name
	 * @return
	 */
	public Track(Double length, String name) {
		this.length = length;
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return this.length.hashCode() + this.name.hashCode();
	}
}