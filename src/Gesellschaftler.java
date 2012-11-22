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
	
	public void calledFromGesellschaftlerSoftware(Software s) {
		s.getSecurityLevel().vonGesellschaftlerVerwendetFuerSoftware(this, s);
	}
	
	protected void calledFromHilfskraefteSoftware(Software s) {}

}
