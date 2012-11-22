

public class Transportarbeiter extends Schwerarbeiter {

	public Transportarbeiter(String seriennummer) {
		super(seriennummer);
	}

	@Override
	public void softwareInstallieren(Software s) {
		// TODO Auto-generated method stub
		s.installiertIn(this);
		
	}

	@Override
	public void calledFromBauarbeiterSoftware(BauarbeiterSoftware s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromServiceTechnikerSoftware(ServiceTechnikerSoftware s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromTransportarbeiterSoftware(TransportarbeiterSoftware s) {
		// TODO Auto-generated method stub
		super.installieren(s);
		
	}


}
