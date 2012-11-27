
/**
 * die Software enthaelt eine Seriennumer die an den Androiden gekoppelt ist
 * 
 * die KaempferSoftware darf nur bei einem Kaempfer installiert werden
 * das Level der KaempferSoftware kann 5 sein
 * 
 * @author OOP Gruppe 187
 *
 */
public class KaempferSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 * @param level security level of the software
	 */
	public KaempferSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
	/**
	 * private constructor that is called from within another object of the 
	 * same type to make the serial unique
	 * 
	 * @param seriennummer serial of the new software
	 * @param level security level of the software
	 */
	private KaempferSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}


	public void installiertIn(Android android) {
		android.calledFromKaempferSoftware(new KaempferSoftware(android.getSeriennummer(), this.level));

		
	}
	
	public SecurityLevel getSecurityLevel() {
		return level;
	}
	
	public String toString() {
		return "Kampf-Software";
	}

}
