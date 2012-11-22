
public class Hilfskraft extends Bediener {

	public Hilfskraft(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public void softwareInstallieren(Software s) {
		s.vonHilfskraftInstalliert(this);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromGesellschaftlerSoftware(GesellschaftlerSoftware s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromHilfskraefteSoftware(HilfskraefteSoftware s) {
		// TODO Auto-generated method stub
		super.installieren(s);
		
	}


	@Override
	public void calledFromSoftwareLevel1(Software s) {
		// TODO Auto-generated method stub
		super.installieren(s);
		
	}


	@Override
	public void calledFromSoftwareLevel2(Software s) {
		// TODO Auto-generated method stub
		super.installieren(s);
	}

	
}
