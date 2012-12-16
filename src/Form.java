/**
 * 
 * @author OOP Gruppe 187
 *
 */
public enum Form {
	RUND("Rund"), 
	MOND("Mond"), 
	WEIHNACHTSMANN("Weihnachtsmann");
	
	private String bezeichnung;

	/**
	 * 
	 * @param bezeichnung
	 */
	private Form(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * toString-Method for fancy output
	 */
	@Override
	public String toString() {
		return this.bezeichnung;
	}
}
