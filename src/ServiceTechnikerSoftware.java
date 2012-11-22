

public class ServiceTechnikerSoftware implements Software {
	private SecurityLevel level;
	
	@SuppressWarnings("unused")
	private final String seriennummer;

	public ServiceTechnikerSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
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
