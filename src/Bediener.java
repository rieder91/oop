

public abstract class Bediener extends Android {

	public Bediener(String seriennummer) {
		super(seriennummer);
	}

	@Override
	protected void calledFromGepanzert(GepanzerterSkin s) {	/* forbidden */}
	
	@Override
	protected void calledFromHochfester(HochfesterSkin s) {
		// forbidden
	}
	@Override
	protected void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}
	
//
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
//		// forbidden
//	}
	
	public  void calledFromBauarbeiterSoftware(BauarbeiterSoftware s) {}
	public  void calledFromKaempferSoftware(KaempferSoftware s) {}
	public  void calledFromLeibwaechterSoftware(LeibwaechterSoftware s) {}
	public  void calledFromObjektbewacherSoftware(ObjektbewacherSoftware s) {}
	public  void calledFromServiceTechnikerSoftware(ServiceTechnikerSoftware s) {}
	public  void calledFromTransportarbeiterSoftware(TransportarbeiterSoftware s) {}

	public  void calledFromSoftwareLevel3(Software s) {}
	public  void calledFromSoftwareLevel4(Software s) {}
	public  void calledFromSoftwareLevel5(Software s) {}

	
//	public abstract void softwareInstallieren(HilfskraefteSoftware s, SecurityLevel1 l);
//	public abstract void softwareInstallieren(HilfskraefteSoftware s, SecurityLevel2 l);
//	
//	public abstract void softwareInstallieren(GesellschaftlerSoftware s, SecurityLevel1 l);
//	
//	public  void softwareInstallieren(BauarbeiterSoftware s, SecurityLevel3 l) {}
//	public  void softwareInstallieren(BauarbeiterSoftware s, SecurityLevel4 l) {}
//	
//	public  void softwareInstallieren(ServiceTechnikerSoftware s, SecurityLevel3 l) {}
//	public  void softwareInstallieren(ServiceTechnikerSoftware s, SecurityLevel4 l) {}
//	
//	public  void softwareInstallieren(TransportarbeiterSoftware s, SecurityLevel3 l) {}
//	public  void softwareInstallieren(TransportarbeiterSoftware s, SecurityLevel4 l) {}
//	
//	public  void softwareInstallieren(ObjektbewacherSoftware s, SecurityLevel4 l) {}
//	
//	public void softwareInstallieren(LeibwaechterSoftware s, SecurityLevel4 l) {}
//	
//	public  void softwareInstallieren(KaempferSoftware s, SecurityLevel5 l) { }
	
	
}