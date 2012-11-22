

public class BauarbeiterSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;
	
	public BauarbeiterSoftware(SecurityLevel level) {
		this.level = level;
		this.seriennummer = null;
	}
	
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
	
}
