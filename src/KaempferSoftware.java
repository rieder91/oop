

public class KaempferSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	public KaempferSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
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

}
