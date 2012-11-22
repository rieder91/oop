

public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(String seriennummer) {
		super(seriennummer);
	}
	
	// ueber das Security Level checken
	public void calledFromBauarbeiterSoftware(Software s) {
		s.getSecurityLevel().vonBauarbeiterVerwendetFuerSoftware(this, s);
	}

	// verboten
	public void calledFromServiceTechnikerSoftware(Software s) { }
	public void calledFromTransportarbeiterSoftware(Software s) { }

	
}
