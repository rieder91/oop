/**
 * Neben einfachen Keksen gibt es Doppelkekse, die aus zwei einfachen Keksen und einer Fuellung (Schokolade oder
 * Marmelade) bestehen.
 * 
 * 
 * @author OOP Gruppe 187
 * 
 */
public enum Fuellung {
	SCHOKOLADE("Schokolade"), MARMELADE("Marmelade");
	
	private String	bezeichnung;
	
	/**
	 * private constructor used to provide toString
	 * 
	 * @param bezeichnung
	 *            name of the enum
	 */
	private Fuellung(String bezeichnung) {
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
