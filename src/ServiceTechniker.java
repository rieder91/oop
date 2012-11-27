
/**
 * ein ServiceTechniker kann nur seine eigene Software mit Level 3 oder 4 verwenden
 * 
 * @author OOP Gruppe 187
 *
 */
public class ServiceTechniker extends Schwerarbeiter {

	/**
	 * default constructor
	 * @param seriennummer serial of the android
	 */
	public ServiceTechniker(String seriennummer) {
		super(seriennummer);
	}

	protected void calledFromServiceTechnikerSoftware(Software s) {
		s.getSecurityLevel().vonSchwerarbeiterVerwendetFuerSoftware(this, s);
	}
	
	protected void calledFromBauarbeiterSoftware(Software s) {}
	protected void calledFromTransportarbeiterSoftware(Software s) {}

	public String toString() {
		return "Typ: Servicetechnik-Roboter" + super.toString();
	}
	
	public Android replaceRobotWith(Android android) {
		return android.replacedByServiceTechniker(android);
	}

}
