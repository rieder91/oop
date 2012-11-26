/**
 * ein Gesellschaftler darf nur seine eigene software von level 1 verwenden
 * (level 2 ist verboten)
 * 
 * @author Thomas
 * 
 */
public class Gesellschaftler extends Bediener {
	
	/**
	 * default constructor
	 * @param seriennummer serial of the android
	 */
	public Gesellschaftler(String seriennummer) {
		super(seriennummer);
	}
	
	protected void calledFromGesellschaftlerSoftware(Software s) {
		s.getSecurityLevel().vonGesellschaftlerVerwendetFuerSoftware(this, s);
	}
	
	protected void calledFromHilfskraefteSoftware(Software s) {}

	public String toString() {
		return "Typ: Gesellschaftler-Roboter" + super.toString();
	}

	public Android replaceRobotWith(Android android) {
		return android.replacedByGesellschaftler(android);
	}

}
