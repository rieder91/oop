

public class Objektbewacher extends Beschuetzer {

	
	public Objektbewacher(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void softwareInstallieren(Software s) {
		// TODO Auto-generated method stub
		s.vonObjektbewacherInstalliert(this);
		
	}

	@Override
	public void calledFromKaempferSoftware(KaempferSoftware s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromLeibwaechterSoftware(LeibwaechterSoftware s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calledFromObjektbewacherSoftware(ObjektbewacherSoftware s) {
		// TODO Auto-generated method stub
		super.installieren(s);
		
	}

	@Override
	public void calledFromSoftwareLevel4(Software s) {
		// TODO Auto-generated method stub
		super.installieren(s);
		
	}

	@Override
	public void calledFromSoftwareLevel5(Software s) {
		// TODO Auto-generated method stub
		
	}

}
