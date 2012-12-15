/**
 * 
 * @author OOP Gruppe 187
 *
 */
public enum Teigart {
	MUERBTEIG("Muerbteig"), ZIMTSTERNTEIG("Zimtsternteig"), SCHOKOLADENTEIG(
			"Schokoladenteig");
	private String bez;

	/**
	 * 
	 * @param f
	 */
	private Teigart(String f) {
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
