/**
 * 
 * @author OOP Gruppe 187
 *
 */
public enum Teigart {
	MUERBTEIG("Muerbteig"), 
	ZIMTSTERNTEIG("Zimtsternteig"), 
	SCHOKOLADENTEIG("Schokoladenteig");
	
	private String bezeichnung;

	/**
	 * 
	 * @param bezeichnung
	 */
	private Teigart(String bezeichnung) {
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
