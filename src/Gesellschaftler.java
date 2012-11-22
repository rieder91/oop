public class Gesellschaftler extends Bediener {

	public Gesellschaftler(String seriennummer) {
		super(seriennummer);
	}
	
	@Override
	public void softwareInstallieren(Software s) {
		// TODO Auto-generated method stub
		s.vonGesellschaftlerInstalliert(this);
		
	}

	@Override
	public void calledFromGesellschaftlerSoftware(GesellschaftlerSoftware s) {
		super.installieren(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromHilfskraefteSoftware(HilfskraefteSoftware s) {
		// VERBOTEN
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromSoftwareLevel1(Software s) {
		// TODO Auto-generated method stub
		super.installieren(s);
		
	}

	@Override
	public void calledFromSoftwareLevel2(Software s) {
		// TODO Auto-generated method stub
		
	}

}
