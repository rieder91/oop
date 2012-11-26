
/**
 * ein Bauarbeiter darf nur Bauarbeiter-Software mit Level 3 oder 4 verwenden
 * 
 * @author Thomas
 *
 */
public class Bauarbeiter extends Schwerarbeiter {

	/**
	 * default constructor
	 * @param seriennummer serial of the android
	 */
	public Bauarbeiter(String seriennummer) {
		super(seriennummer);
	}
	
	// checks the security level first
	protected void calledFromBauarbeiterSoftware(Software s) {
		s.getSecurityLevel().vonSchwerarbeiterVerwendetFuerSoftware(this, s);
	}

	protected void calledFromServiceTechnikerSoftware(Software s) {}
	protected void calledFromTransportarbeiterSoftware(Software s) {}
	
	public String toString() {
		return "Typ: Bauarbeiter-Roboter" + super.toString();
	}
	
	public Android replaceRobotWith(Android android) {
		return android.replacedByBauarbeiter(android);
	}
}
