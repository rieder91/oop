
/**
 * ein Bauarbeiter darf nur Bauarbeiter-Software verwenden
 * 
 * @author Thomas
 *
 */
public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(String seriennummer) {
		super(seriennummer);
	}
	
	// checks the security level first
	protected void calledFromBauarbeiterSoftware(Software s) {
		s.getSecurityLevel().vonSchwerarbeiterVerwendetFuerSoftware(this, s);
	}

	protected void calledFromServiceTechnikerSoftware(Software s) {}
	protected void calledFromTransportarbeiterSoftware(Software s) {}
	
}
