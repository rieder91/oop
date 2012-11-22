
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
		s.integrate(this);
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
	
	
//	public void softwareInstallieren(HilfskraefteSoftware s, SecurityLevel1 l) {}
//	public void softwareInstallieren(HilfskraefteSoftware s, SecurityLevel2 l) {}
//	
//	public void softwareInstallieren(GesellschaftlerSoftware s, SecurityLevel1 l) {}
//	
//	public abstract void softwareInstallieren(BauarbeiterSoftware s, SecurityLevel3 l);
//	public abstract void softwareInstallieren(BauarbeiterSoftware s, SecurityLevel4 l);
//	
//	public abstract void softwareInstallieren(ServiceTechnikerSoftware s, SecurityLevel3 l);
//	public abstract void softwareInstallieren(ServiceTechnikerSoftware s, SecurityLevel4 l);
//	
//	public abstract void softwareInstallieren(TransportarbeiterSoftware s, SecurityLevel3 l);
//	public abstract void softwareInstallieren(TransportarbeiterSoftware s, SecurityLevel4 l);
//	
//	public void softwareInstallieren(ObjektbewacherSoftware s, SecurityLevel4 l) { }
//	
//	public void softwareInstallieren(LeibwaechterSoftware s, SecurityLevel4 l) { }
//	
//	public void softwareInstallieren(KaempferSoftware s, SecurityLevel5 l) { }
	
}
