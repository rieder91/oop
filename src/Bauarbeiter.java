

public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}
	
	public void softwareInstallieren(Software s) {
		s.installiertIn(this);
	}
	
	public void calledFromBauarbeiterSoftware(BauarbeiterSoftware s) {
		super.installieren(s);
	}

	@Override
	public void calledFromServiceTechnikerSoftware(ServiceTechnikerSoftware s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromTransportarbeiterSoftware(TransportarbeiterSoftware s) {
		// TODO Auto-generated method stub
		
	}

	
}
