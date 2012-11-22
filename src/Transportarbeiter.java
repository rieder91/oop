
/**
 * ein Transportarbeiter darf nur seine eigene Software mit Level 3 oder 4 verwenden
 * 
 * @author Thomas
 *
 */
public class Transportarbeiter extends Schwerarbeiter {

	/**
	 * default constructor
	 * @param seriennummer serial of the android
	 */
	public Transportarbeiter(String seriennummer) {
		super(seriennummer);
	}

	protected void calledFromTransportarbeiterSoftware(Software s) {
		s.getSecurityLevel().vonSchwerarbeiterVerwendetFuerSoftware(this, s);
	}
	
	protected void calledFromBauarbeiterSoftware(Software s) {}
	protected void calledFromServiceTechnikerSoftware(Software s) {}
	
	public String toString() {
		return "Typ: Transport-Roboter" + super.toString();
	}
}
