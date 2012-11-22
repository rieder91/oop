

public class Leibwaechter extends Beschuetzer {

	public Leibwaechter(String seriennummer) {
		super(seriennummer);
	}


	public void calledFromLeibwaechterSoftware(Software s) {
		s.getSecurityLevel().vonLeibwaechterVerwendetFuerSoftware(this, s);
		
	}
	
	protected void calledFromKaempferSoftware(Software s) {}
	protected void calledFromObjektbewacherSoftware(Software s) {}
	
	public void calledFromSoftwareLevel4(Software s) { 
		super.installieren(s);
	}
	
	protected void calledFromSoftwareLevel5(Software s) {}
	
	protected void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	
	public void calledFromLeistungFuenf(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungFuenf(this, s);
	}
	
	public void calledFromLeistungZehn(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungZehn(this, s);
	}
}