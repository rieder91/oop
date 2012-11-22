
/**
 * die Software enthaelt eine Seriennumer die an den Androiden gekoppelt ist
 * 
 * die ObjektbewacherSoftware darf nur bei einem Objektbewacher installiert werden
 * das Level der ObjektbewacherSoftware kann 4 sein
 * 
 * @author Thomas
 *
 */
public class ObjektbewacherSoftware implements Software {

	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 * @param level security level of the software
	 */
	public ObjektbewacherSoftware(SecurityLevel level) {
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

	public String toString() {
		return "Objektbewacher-Software";
	}
}
