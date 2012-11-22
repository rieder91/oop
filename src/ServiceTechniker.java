

public class ServiceTechniker extends Schwerarbeiter {

	public ServiceTechniker(String seriennummer) {
		super(seriennummer);
	}

	// verboten
	public void calledFromBauarbeiterSoftware(Software s) { }
	public void calledFromTransportarbeiterSoftware(Software s) { }

	// erlaubt
	public void calledFromServiceTechnikerSoftware(Software s) {
		s.getSecurityLevel().vonServiceTechnikerVerwendetFuerSoftware(this, s);
	}

	


}
