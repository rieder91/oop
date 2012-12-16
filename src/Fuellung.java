/**
 * 
 * @author OOP Gruppe 187
 *
 */
public enum Fuellung {
	SCHOKOLADE("Schokolade"), 
	MARMELADE("Marmelade");
	
	private String bezeichnung;

	/**
	 * 
	 * @param bezeichnung
	 */
	private Fuellung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		return this.bezeichnung;
	}
}
