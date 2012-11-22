
/**
 * die Software enthaelt eine Seriennumer die an den Androiden gekoppelt ist
 * 
 * die HilfskraefteSoftware darf nur bei einer Hilfskraft installiert werden
 * das Level der HilfskraefteSoftware kann 1 oder 2 sein
 * 
 * @author Thomas
 *
 */
public class HilfskraefteSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 * @param level security level of the software
	 */
	public HilfskraefteSoftware(SecurityLevel level) {
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
	private HilfskraefteSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}


	public void installiertIn(Android android) {
		android.calledFromHilfskraefteSoftware(new HilfskraefteSoftware(android.getSeriennummer(), this.level));
	}

	public SecurityLevel getSecurityLevel() {
		return level;
	}
	
	public String toString() {
		return "Hilfskraefte-Software";
	}
}
