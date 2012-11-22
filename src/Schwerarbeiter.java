
public abstract class Schwerarbeiter extends Android{

	public Schwerarbeiter(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}

	public void calledFromGepanzert(GepanzerterSkin s) {
		// forbidden
	}

	public void calledFromHochfester(HochfesterSkin s) {
		super.installieren(s);
	}

	public void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}
	
	public  void calledFromGesellschaftlerSoftware(Software s) {}
	public  void calledFromHilfskraefteSoftware(Software s) {}
	public  void calledFromKaempferSoftware(Software s) {}
	public  void calledFromLeibwaechterSoftware(Software s) {}
	public  void calledFromObjektbewacherSoftware(Software s) {}
	
	
	
	// Schwerarbeiter können mit Software der Stufen 3 und 4 ausgestattet sein
	public void calledFromSoftwareLevel1(Software s) {}
	public void calledFromSoftwareLevel2(Software s) {}
	public void calledFromSoftwareLevel5(Software s) {}
	
	public  void calledFromSoftwareLevel3(Software s) {
		super.installieren(s);
	}
	
	public  void calledFromSoftwareLevel4(Software s) {
		super.installieren(s);
	}
	
	
	
	
	
	public void kitInstallieren(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().vomAndroidFuerAktoren(this, s);
	}
	
	public  void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	
	public  void calledFromLeistungEins(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	public void calledFromLeistungFuenf(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().vomAndroidFuerAktoren(this, s);
	}
	
	public void calledFromLeistungZehn(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().vomAndroidFuerAktoren(this, s);
	}
	
	
}
