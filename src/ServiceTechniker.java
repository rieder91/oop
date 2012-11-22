

public class ServiceTechniker extends Schwerarbeiter {

	public ServiceTechniker(String seriennummer) {
		super(seriennummer);
	}

	public void calledFromServiceTechnikerSoftware(Software s) {
		s.getSecurityLevel().vonSchwerarbeiterVerwendetFuerSoftware(this, s);
	}
	
	protected void calledFromBauarbeiterSoftware(Software s) {}
	protected void calledFromTransportarbeiterSoftware(Software s) {}

}
