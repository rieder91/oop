package assignment1;

public class Track {

	private Double length;
	private String name;

	/**
	 * 
	 * @return 
	 */
	public String toString() {
		return this.name+": "+this.length;
	}

	/**
	 * 
	 * @param length
	 * @param name
	 * @return 
	 */
	public Track(Double length, String name) {
		this.length=length;
		this.name=name;
	}

}