/**
 * 
 * @author OOP Gruppe 187
 *
 */
public enum Form {
	RUND("Rund"), MOND("Mond"), WEIHNACHTSMANN("Weihnachtsmann");
	private String bez;

	/**
	 * 
	 * @param f
	 */
	private Form(String f) {
		this.bez = f;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.bez;
	}
}
