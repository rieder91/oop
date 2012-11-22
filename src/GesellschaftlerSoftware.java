

public class GesellschaftlerSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;
	
	public GesellschaftlerSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
	private GesellschaftlerSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}


	public void installiertIn(Android android) {
		// TODO Auto-generated method stub
		android.calledFromGesellschaftlerSoftware(new GesellschaftlerSoftware(android.getSeriennummer(), this.level));
		
	}

	public SecurityLevel getSecurityLevel() {
		return level;
	}

}
