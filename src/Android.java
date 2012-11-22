

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
	
	protected abstract void calledFromBauarbeiterSoftware(Software s);
	protected abstract void calledFromGesellschaftlerSoftware(Software s);
	protected abstract void calledFromHilfskraefteSoftware(Software s);
	protected abstract void calledFromKaempferSoftware(Software s);
	protected abstract void calledFromLeibwaechterSoftware(Software s);
	protected abstract void calledFromObjektbewacherSoftware(Software s);
	protected abstract void calledFromServiceTechnikerSoftware(Software s);
	protected abstract void calledFromTransportarbeiterSoftware(Software s);
	
	
	protected abstract void calledFromSoftwareLevel1(Software s);
	protected abstract void calledFromSoftwareLevel2(Software s);
	protected abstract void calledFromSoftwareLevel3(Software s);
	protected abstract void calledFromSoftwareLevel4(Software s);
	protected abstract void calledFromSoftwareLevel5(Software s);


	/*****************/
	
	// Kits
	
	public void kitInstallieren(SensorenAktorenKit s) {
		s.integrieren(this);
	}
	
	protected abstract void calledFromLeistungUnbegrenzt(SensorenAktorenKit s);
	protected abstract void calledFromLeistungEins(SensorenAktorenKit s);
	protected abstract void calledFromLeistungFuenf(SensorenAktorenKit s);
	protected abstract void calledFromLeistungZehn(SensorenAktorenKit s);
	
	// wenn das Security Level = 3,4 ist, ist es erlaubt - unabhaengig vom Robotertyp
	protected  void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s) {
		this.installieren(s);
	}
	protected  void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s) {
		this.installieren(s);
	}
	
	// bei 10KW braucht man Level 4
	protected void calledForLeistungZehnWithLevel3(SensorenAktorenKit s) { }
	protected void calledForLeistungZehnWithLevel4(SensorenAktorenKit s) {
		this.installieren(s);
	}


	
	/* USED FOR DEBUGGING ONLY!!! */
	protected void dismantleKit() {
		this.kit = null;
	}
	
	protected void wipeSoftware() {
		this.software = null;
	}
	
	protected void smashSkin() {
		this.skin = null;
	}
	
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