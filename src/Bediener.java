

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
	

	@Override
	public void skinEinbauen(Skin s) {
		s.integrate(this);
	}

	
	public  void calledFromBauarbeiterSoftware(BauarbeiterSoftware s) {}
	public  void calledFromKaempferSoftware(KaempferSoftware s) {}
	public  void calledFromLeibwaechterSoftware(LeibwaechterSoftware s) {}
	public  void calledFromObjektbewacherSoftware(ObjektbewacherSoftware s) {}
	public  void calledFromServiceTechnikerSoftware(ServiceTechnikerSoftware s) {}
	public  void calledFromTransportarbeiterSoftware(TransportarbeiterSoftware s) {}

	public  void calledFromSoftwareLevel3(Software s) {}
	public  void calledFromSoftwareLevel4(Software s) {}
	public  void calledFromSoftwareLevel5(Software s) {}
	
	public  void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	
	public  void calledFromLeistungEins(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	public  void calledFromLeistungFuenf(SensorenAktorenKit s) {}
	public  void calledFromLeistungZehn(SensorenAktorenKit s) {}

	public  void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s) {}
	public  void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s) {}
	public  void calledForLeistungZehnWithLevel3(SensorenAktorenKit s) {}
	public  void calledForLeistungZehnWithLevel4(SensorenAktorenKit s) {}
	
	public void kitInstallieren(SensorenAktorenKit s) {
		s.vonBedienerInstalliert(this);
	}
	
}