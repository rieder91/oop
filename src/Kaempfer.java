

public class Kaempfer extends Beschuetzer {

	public Kaempfer(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void softwareInstallieren(Software s) {
		// TODO Auto-generated method stub
		s.vonKaempferInstalliert(this);
		
	}

	@Override
	public void calledFromKaempferSoftware(KaempferSoftware s) {
		// TODO Auto-generated method stub
		s.getSecurityLevel().vonKaempferVerwendetFuerSoftware(this, s);
		
	}

	@Override
	public void calledFromLeibwaechterSoftware(LeibwaechterSoftware s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromObjektbewacherSoftware(ObjektbewacherSoftware s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromSoftwareLevel4(Software s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromSoftwareLevel5(Software s) {
		// TODO Auto-generated method stub
		super.installieren(s);
		
	}


}
