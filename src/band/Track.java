package band;

/**
 * Class that contains all the information belonging to a track.
 * 
 * @author OOP Gruppe 187
 */
public class Track {

	private Integer length;
	private String name;

	/**
	 * @return a string representation of a member
	 */
	@Override
	public String toString() {

		return this.name
				+ " - "
				+ (this.length / 60)
				+ ":"
				+ ((this.length % 60) < 10 ? "0" + (this.length % 60)
						: this.length % 60);
	}

	/**
	 * Constructor which requires two arguments
	 * 
	 * @param length
	 *            the length of the track
	 * @param name
	 *            the name of the track
	 */
	public Track(String name, Integer length) {

		this.length = length;
		this.name = name;
	}

	/**
	 * @return a hash value representing the track
	 */
	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = (prime * result)
				+ ((this.length == null) ? 0 : this.length.hashCode());
		result = (prime * result)
				+ ((this.name == null) ? 0 : this.name.hashCode());
		return result;
	}

	/**
	 * compares two tracks
	 * 
	 * @return true if the tracks are equal false otherwise
	 */
	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Track))
			return false;
		Track other = (Track) obj;
		if (this.length == null) {
			if (other.length != null)
				return false;
		} else if (!this.length.equals(other.length))
			return false;
		if (this.name == null) {
			if (other.name != null)
				return false;
		} else if (!this.name.equals(other.name))
			return false;
		return true;
	}
}