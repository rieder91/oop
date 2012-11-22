

public class ServiceTechniker extends Schwerarbeiter {

	public ServiceTechniker(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
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
		super.installieren(s);
		
	}

	@Override
	public void calledFromTransportarbeiterSoftware(TransportarbeiterSoftware s) {
		// TODO Auto-generated method stub
		
	}


}
