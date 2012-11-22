

public class Objektbewacher extends Beschuetzer {

	
	public Objektbewacher(String seriennummer) {
		super(seriennummer);
	}


	public void calledFromKaempferSoftware(Software s) { }
	public void calledFromLeibwaechterSoftware(Software s) { }

	public void calledFromObjektbewacherSoftware(Software s) {
		s.getSecurityLevel().vonObjektbewacherVerwendetFuerSoftware(this, s);
		
	}

	
	public void calledFromSoftwareLevel5(Software s) { }
	
	public void calledFromSoftwareLevel4(Software s) {
		super.installieren(s);
	}

	
	
	public void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) { }
	


}
