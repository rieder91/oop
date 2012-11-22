

public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}
	
	public void softwareInstallieren(Software s) {
		s.vonBauarbeiterInstalliert(this);
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

//	public  void softwareInstallieren(BauarbeiterSoftware s, SecurityLevel3 l) {
//		// ERLAUBT
//		s.integrate(this);
//	}
//	public  void softwareInstallieren(BauarbeiterSoftware s, SecurityLevel4 l) {
//		// ERLAUBT
//	}
//	
//	public  void softwareInstallieren(ServiceTechnikerSoftware s, SecurityLevel3 l) {}
//	public  void softwareInstallieren(ServiceTechnikerSoftware s, SecurityLevel4 l) {}
//	
//	public  void softwareInstallieren(TransportarbeiterSoftware s, SecurityLevel3 l) {	}
//	public  void softwareInstallieren(TransportarbeiterSoftware s, SecurityLevel4 l) {	}
	
}
