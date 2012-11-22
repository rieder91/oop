

public class Transportarbeiter extends Schwerarbeiter {

	public Transportarbeiter(String seriennummer) {
		super(seriennummer);
	}

	public void calledFromTransportarbeiterSoftware(Software s) {
		s.getSecurityLevel().vonSchwerarbeiterVerwendetFuerSoftware(this, s);
	}
	
	protected void calledFromBauarbeiterSoftware(Software s) {}
	protected void calledFromServiceTechnikerSoftware(Software s) {}
}
