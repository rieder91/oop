/**
 * 
 * @author OOP Gruppe 187
 *
 */
public enum Fuellung {
	SCHOKOLADE("Schokolade"), MARMELADE("Marmelade");
	private String bez;

	/**
	 * 
	 * @param f
	 */
	private Fuellung(String f) {
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
