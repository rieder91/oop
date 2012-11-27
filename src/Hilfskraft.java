/**
 * eine Hilfskraft kann nur Hilfskraftsoftware verwenden
 * @author OOP Gruppe 187
 *
 */
public class Hilfskraft extends Bediener {

	/**
	 * default constructor
	 * @param seriennummer serial of the droid
	 */
	public Hilfskraft(String seriennummer) {
		super(seriennummer);
	}
	
	protected void calledFromHilfskraefteSoftware(Software s) {
		s.getSecurityLevel().vonHilfskraftVerwendetFuerSoftware(this, s);
	}
	
	protected void calledFromGesellschaftlerSoftware(Software s) {}
	
	public String toString() {
		return "Typ: Hilfskraft-Roboter" + super.toString();
	}
	
	public Android replaceRobotWith(Android android) {
		return android.replacedByHilfskraft(android);
	}

}
