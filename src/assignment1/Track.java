package assignment1;

public class Track {

	private Integer length;
	private String name;

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return this.name + " - " + this.length/60 + ":" + (this.length % 60 < 10 ? "0" + this.length % 60 : this.length % 60);
	}

	/**
	 * 
	 * @param length
	 * @param name
	 * @return
	 */
	public Track(String name, Integer length) {
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