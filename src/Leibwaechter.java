

public class Leibwaechter extends Beschuetzer {

	public Leibwaechter(String seriennummer) {
		super(seriennummer);
	}


	public void calledFromKaempferSoftware(Software s) { }
	public void calledFromObjektbewacherSoftware(Software s) { }

	public void calledFromLeibwaechterSoftware(Software s) {
		s.getSecurityLevel().vonLeibwaechterVerwendetFuerSoftware(this, s);
		
	}

	
	public void calledFromSoftwareLevel5(Software s) { }

	public void calledFromSoftwareLevel4(Software s) {
		super.installieren(s);
		
	}

	

	
	public void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) { }
	

	public void calledFromLeistungFuenf(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungFuenf(this, s);
	}
	
	public void calledFromLeistungZehn(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungZehn(this, s);
	}

}
