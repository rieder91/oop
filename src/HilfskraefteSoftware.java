

public class HilfskraefteSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	public HilfskraefteSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
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
}
