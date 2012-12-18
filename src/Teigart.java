/**
 * ... und besteht aus einer bestimmten Teigart (Mürbteig, Zimtsternteig oder Schokoladenteig)
 * 
 * 
 * @author OOP Gruppe 187
 * 
 */
public enum Teigart {
	MUERBTEIG("Muerbteig"), ZIMTSTERNTEIG("Zimtsternteig"), SCHOKOLADENTEIG("Schokoladenteig");
	
	private String	bezeichnung;
	
	/**
	 * private constructor used to provide toString
	 * 
	 * @param bezeichnung
	 *            name of the enum
	 */
	private Teigart(String bezeichnung) {
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
