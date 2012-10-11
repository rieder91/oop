package assignment1;

public class Track {

	private Integer length;
	private String name;

	/**
	 * 
	 * @return a string representation of an member
	 */
	public String toString() {
		return this.name + " - " + this.length/60 + ":" + (this.length % 60 < 10 ? "0" + this.length % 60 : this.length % 60);
	}

	/**
	 * Constructor which requires two arguments
	 * 
	 * @param length
	 * 				the length of the track
	 * @param name
	 * 				the name of the track
	 */
	public Track(String name, Integer length) {
		this.length = length;
		this.name = name;
	}

	/**
	 * 
	 * @return a hash value that represents the track
	 */
	public int hashCode() {
		return this.length.hashCode() + this.name.hashCode();
	}
	
	/** 
	 * compares two tracks
	 * 
	 * @return 
	 * 			true if the tracks are equal
	 * 			false if the tracks are not equal
	 */
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (!this.getClass().equals(o.getClass())) {
			return false;

		}
		if (this.length.equals(((Track) o).length)
				&& this.name.equals(((Track) o).name)) {
			return true;

		}
		return false;
	}
}