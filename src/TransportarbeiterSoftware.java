

public class TransportarbeiterSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	public TransportarbeiterSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
	private TransportarbeiterSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}


	public void installiertIn(Android android) {
		android.calledFromTransportarbeiterSoftware(new TransportarbeiterSoftware(android.getSeriennummer(), this.level));

	}

	public SecurityLevel getSecurityLevel() {
		return level;
	}

}
