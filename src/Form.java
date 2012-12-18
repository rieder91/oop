/**
 * Jedes Keks hat eine bestimmte Form (rund, in der Form eines Mondes und in der Form eines Weihnachtsmannes) ...
 * 
 * @author OOP Gruppe 187
 * 
 */
public enum Form {
	RUND("Rund"), MOND("Mond"), WEIHNACHTSMANN("Weihnachtsmann");
	
	private String	bezeichnung;
	
	/**
	 * private constructor used to provide toString
	 * 
	 * @param bezeichnung
	 *            name of the enum
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
