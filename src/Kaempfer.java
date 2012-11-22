

public class Kaempfer extends Beschuetzer {

	public Kaempfer(String seriennummer) {
		super(seriennummer);
	}


	public void calledFromKaempferSoftware(Software s) {
		s.getSecurityLevel().vonKaempferVerwendetFuerSoftware(this, s);
		
	}

	public void calledFromLeibwaechterSoftware(Software s) { }
	public void calledFromObjektbewacherSoftware(Software s) { }

	public void calledFromSoftwareLevel4(Software s) { }

	public void calledFromSoftwareLevel5(Software s) {
		super.installieren(s);
	}

	public void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {
		this.installieren(s);
	}

	public void calledFromLeistungFuenf(SensorenAktorenKit s) {
		this.installieren(s);
	}

	public void calledFromLeistungZehn(SensorenAktorenKit s) {
		this.installieren(s);
	}
	
	public void kitInstallieren(SensorenAktorenKit s) {
		s.vonKaempferInstalliert(this);
	}

}
