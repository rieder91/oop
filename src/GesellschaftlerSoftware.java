
/**
 * die Software enthaelt eine Seriennumer die an den Androiden gekoppelt ist
 * 
 * die Gesellschaftler-Software darf nur bei einem Gesellschaftler installiert werden
 * das Level der Gesellschaftler Software kann 1 sein
 * 
 * @author Thomas
 *
 */
public class GesellschaftlerSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;
	
	/**
	 * default constructor
	 * @param level security level of the software
	 */
	public GesellschaftlerSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
	/**
	 * private constructor that is called from within another of the 
	 * same type as this to make the serial unique
	 * 
	 * @param seriennummer serial of the new software
	 * @param level security level of the software
	 */
	private GesellschaftlerSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}


	public void installiertIn(Android android) {
		android.calledFromGesellschaftlerSoftware(new GesellschaftlerSoftware(android.getSeriennummer(), this.level));
	}

	public SecurityLevel getSecurityLevel() {
		return level;
	}
	
	public String toString() {
		return "Gesellschaftler-Software";
	}

}
