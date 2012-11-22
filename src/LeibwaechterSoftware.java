

public class LeibwaechterSoftware implements Software {

	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	public LeibwaechterSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
	private LeibwaechterSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}


	public void installiertIn(Android android) {
		android.calledFromLeibwaechterSoftware(new LeibwaechterSoftware(android.getSeriennummer(), this.level));
	}

	
	public SecurityLevel getSecurityLevel() {
		return level;
	}

}
