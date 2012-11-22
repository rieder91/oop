

public abstract class Bediener extends Android {

	public Bediener(String seriennummer) {
		super(seriennummer);
	}
	
	/* Skins */
	
	/*
	 * Bediener muessen einen BeruehrungssensitivenSkin haben
	 * (non-Javadoc)
	 * @see Android#calledFromGepanzert(GepanzerterSkin)
	 */
	
	// verboten
	protected void calledFromGepanzert(GepanzerterSkin s) { }
	protected void calledFromHochfester(HochfesterSkin s) {	}
	
	// erlaubt
	protected void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}
	


	// verboten - kann man in der abstrakten Klasse machen weil es kein Untertyp von Bediener ist
	public  void calledFromBauarbeiterSoftware(Software s) {}
	public  void calledFromKaempferSoftware(Software s) {}
	public  void calledFromLeibwaechterSoftware(Software s) {}
	public  void calledFromObjektbewacherSoftware(Software s) {}
	public  void calledFromServiceTechnikerSoftware(Software s) {}
	public  void calledFromTransportarbeiterSoftware(Software s) {}

	// verboten - Bediener haben entweder Level 1 oder 2
	public  void calledFromSoftwareLevel3(Software s) {}
	public  void calledFromSoftwareLevel4(Software s) {}
	public  void calledFromSoftwareLevel5(Software s) {}
	
	
	public  void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	
	
	public  void calledFromLeistungEins(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	public  void calledFromLeistungFuenf(SensorenAktorenKit s) {}
	public  void calledFromLeistungZehn(SensorenAktorenKit s) {}

	// Bediener haben nur Software mit Level 1 oder 2 - verboten
	public  void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s) {}
	public  void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s) {}
	public  void calledForLeistungZehnWithLevel3(SensorenAktorenKit s) {}
	public  void calledForLeistungZehnWithLevel4(SensorenAktorenKit s) {}
	
	public void kitInstallieren(SensorenAktorenKit s) {
		s.vonBedienerInstalliert(this);
	}
	
}