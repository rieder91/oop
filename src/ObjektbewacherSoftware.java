

public class ObjektbewacherSoftware implements Software {

	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	public ObjektbewacherSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
	private ObjektbewacherSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}


	public void installiertIn(Android android) {
		android.calledFromObjektbewacherSoftware(new ObjektbewacherSoftware(android.getSeriennummer(), this.level));
	}

	public SecurityLevel getSecurityLevel() {
		return level;
	}

}
