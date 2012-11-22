

public class Transportarbeiter extends Schwerarbeiter {

	public Transportarbeiter(String seriennummer) {
		super(seriennummer);
	}


	public void calledFromBauarbeiterSoftware(Software s) { }
	public void calledFromServiceTechnikerSoftware(Software s) { }

	public void calledFromTransportarbeiterSoftware(Software s) {
		s.getSecurityLevel().vonTransportarbeiterVerwendetFuerSoftware(this, s);
	}


}
