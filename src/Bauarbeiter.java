

public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(String seriennummer) {
		super(seriennummer);
	}
	
	// ueber das Security Level checken
	protected void calledFromBauarbeiterSoftware(Software s) {
		s.getSecurityLevel().vonBauarbeiterVerwendetFuerSoftware(this, s);
	}

	// verboten
	protected void calledFromServiceTechnikerSoftware(Software s) { }
	protected void calledFromTransportarbeiterSoftware(Software s) { }

	
}
