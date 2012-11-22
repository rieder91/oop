

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
	
	public void skinEinbauen(Skin s) {
		s.einbauen(this);
	}
	
	/*********************/
	
	// Software
	
	public void softwareInstallieren(Software s) {
		s.installiertIn(this);
	}
	
	protected abstract void calledFromBauarbeiterSoftware(BauarbeiterSoftware s);
	protected abstract void calledFromGesellschaftlerSoftware(GesellschaftlerSoftware s);
	protected abstract void calledFromHilfskraefteSoftware(HilfskraefteSoftware s);
	protected abstract void calledFromKaempferSoftware(KaempferSoftware s);
	protected abstract void calledFromLeibwaechterSoftware(LeibwaechterSoftware s);
	protected abstract void calledFromObjektbewacherSoftware(ObjektbewacherSoftware s);
	protected abstract void calledFromServiceTechnikerSoftware(ServiceTechnikerSoftware s);
	protected abstract void calledFromTransportarbeiterSoftware(TransportarbeiterSoftware s);
	
	
	protected abstract void calledFromSoftwareLevel1(Software s);
	protected abstract void calledFromSoftwareLevel2(Software s);
	protected abstract void calledFromSoftwareLevel3(Software s);
	protected abstract void calledFromSoftwareLevel4(Software s);
	protected abstract void calledFromSoftwareLevel5(Software s);


	/*****************/
	
	// Kits
	
	public abstract void kitInstallieren(SensorenAktorenKit s);
	
	protected abstract void calledFromLeistungUnbegrenzt(SensorenAktorenKit s);
	protected abstract void calledFromLeistungEins(SensorenAktorenKit s);
	protected abstract void calledFromLeistungFuenf(SensorenAktorenKit s);
	protected abstract void calledFromLeistungZehn(SensorenAktorenKit s);
	
	protected  void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s) {
		this.installieren(s);
	}
	protected  void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s) {
		this.installieren(s);
	}
	
	protected  void calledForLeistungZehnWithLevel3(SensorenAktorenKit s) { }
	protected  void calledForLeistungZehnWithLevel4(SensorenAktorenKit s) {
		this.installieren(s);
	}


	/* USED FOR DEBUGGING ONLY */
	protected Software getSoftware() {
		return software;
	}

	protected Skin getSkin() {
		return skin;
	}

	protected SensorenAktorenKit getKit() {
		return kit;
	}
	/* USED FOR DEBUGGING ONLY */

}