
/**
 * die Software enthaelt eine Seriennumer die an den Androiden gekoppelt ist
 * 
 * die Bauarbeiter Software darf nur bei einem Bauarbeiter installiert werden
 * das Level der Bauarbeiter Software kann 3 oder 4 sein
 * 
 * @author OOP Gruppe 187
 *
 */
public class BauarbeiterSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;
	
	/**
	 * default constructor
	 * @param level security level of the software
	 */
	public BauarbeiterSoftware(SecurityLevel level) {
		this.level = level;
		this.seriennummer = null;
	}
	
	/**
	 * private constructor that is called from within another object of the 
	 * same type to make the serial unique
	 * 
	 * @param seriennummer serial of the new software
	 * @param level security level of the software
	 */
	private BauarbeiterSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}

	
	public void installiertIn(Android android) {
		android.calledFromBauarbeiterSoftware(new BauarbeiterSoftware(android.getSeriennummer(), this.level));
	}
	
	public SecurityLevel getSecurityLevel() {
		return level;
	}
	
	public String toString() {
		return "Bauarbeiter-Software";
	}
}
