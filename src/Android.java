

public abstract class Android {
	private String seriennummer;
	private Skin skin;
	private Software software;
	private SensorenAktorenKit kit;


	public Android(String seriennummer) {
		this.seriennummer = seriennummer;
		skin = null;
		software = null;
		kit = null;
	}

	protected String getSeriennummer() {
		return seriennummer;
	}

	protected void installieren(Skin s) {
		skin = s;
	}

	protected void installieren(Software s) {
		software = s;
	}

	protected void installieren(SensorenAktorenKit s) {
		kit = s;
	}

	/*********************/
	
	// Skin
	
	protected abstract void calledFromGepanzert(GepanzerterSkin s);
	protected abstract void calledFromHochfester(HochfesterSkin s);
	protected abstract void calledFromBeruehrungs(BeruehrungssensitiverSkin s);
	
//	public abstract void skinEinbauen(GepanzerterSkin s);
//	public abstract void skinEinbauen(HochfesterSkin s);
//	public abstract void skinEinbauen(BeruehrungssensitiverSkin s);
	public abstract void skinEinbauen(Skin s);
	
	/*********************/
	
	public abstract void softwareInstallieren(Software s);
	
	public abstract void calledFromBauarbeiterSoftware(BauarbeiterSoftware s);
	public abstract void calledFromGesellschaftlerSoftware(GesellschaftlerSoftware s);
	public abstract void calledFromHilfskraefteSoftware(HilfskraefteSoftware s);
	public abstract void calledFromKaempferSoftware(KaempferSoftware s);
	public abstract void calledFromLeibwaechterSoftware(LeibwaechterSoftware s);
	public abstract void calledFromObjektbewacherSoftware(ObjektbewacherSoftware s);
	public abstract void calledFromServiceTechnikerSoftware(ServiceTechnikerSoftware s);
	public abstract void calledFromTransportarbeiterSoftware(TransportarbeiterSoftware s);
	
	
	public abstract void calledFromSoftwareLevel1(Software s);
	public abstract void calledFromSoftwareLevel2(Software s);
	public abstract void calledFromSoftwareLevel3(Software s);
	public abstract void calledFromSoftwareLevel4(Software s);
	public abstract void calledFromSoftwareLevel5(Software s);


	/*****************/

}