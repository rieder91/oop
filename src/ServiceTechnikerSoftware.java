
/**
 * die Software enthaelt eine Seriennumer die an den Androiden gekoppelt ist
 * 
 * die ServiceTechnikerSoftware Software darf nur bei einem ServiceTechniker installiert werden
 * das Level der ServiceTechnikerSoftware kann 3 oder 4 sein
 * 
 * @author Thomas
 *
 */
public class ServiceTechnikerSoftware implements Software {
	private SecurityLevel level;
	
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 * @param level security level of the software
	 */
	public ServiceTechnikerSoftware(SecurityLevel level) {
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
	private ServiceTechnikerSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}


	public void installiertIn(Android android) {
		android.calledFromServiceTechnikerSoftware(new ServiceTechnikerSoftware(android.getSeriennummer(), this.level));
	}


	public SecurityLevel getSecurityLevel() {
		return level;
	}

}
