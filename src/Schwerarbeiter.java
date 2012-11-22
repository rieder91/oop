
public abstract class Schwerarbeiter extends Android{

	public Schwerarbeiter(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calledFromGepanzert(GepanzerterSkin s) {
		// forbidden
	}
	@Override
	public void calledFromHochfester(HochfesterSkin s) {
		super.installieren(s);
	}
	@Override
	public void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}
	
	
//	@Override
//	public void skinEinbauen(GepanzerterSkin s) {
//		// forbidden
//	}
	
	@Override
	public void skinEinbauen(Skin s) {
		s.einbauen(this);
	}
	
//	@Override
//	public void skinEinbauen(HochfesterSkin s) {
//		s.integrate(this);
//	}
	
	public  void calledFromGesellschaftlerSoftware(GesellschaftlerSoftware s) {}
	public  void calledFromHilfskraefteSoftware(HilfskraefteSoftware s) {}
	public  void calledFromKaempferSoftware(KaempferSoftware s) {}
	public  void calledFromLeibwaechterSoftware(LeibwaechterSoftware s) {}
	public  void calledFromObjektbewacherSoftware(ObjektbewacherSoftware s) {}
	
	public  void calledFromSoftwareLevel1(Software s) {}
	public  void calledFromSoftwareLevel2(Software s) {}
	
	public  void calledFromSoftwareLevel3(Software s) {
		super.installieren(s);
	}
	public  void calledFromSoftwareLevel4(Software s) {
		super.installieren(s);
	}
	
	public void calledFromSoftwareLevel5(Software s) {}
	
	
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
