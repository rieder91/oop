

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
	


	// verboten - kann man in der abstrakten Klasse machen
	protected void calledFromBauarbeiterSoftware(Software s) {}
	protected void calledFromKaempferSoftware(Software s) {}
	protected void calledFromLeibwaechterSoftware(Software s) {}
	protected void calledFromObjektbewacherSoftware(Software s) {}
	protected void calledFromServiceTechnikerSoftware(Software s) {}
	protected void calledFromTransportarbeiterSoftware(Software s) {}

	// verboten - Bediener haben entweder Level 1 oder 2
	//
	// Gesellschafter benötigen Software der Stufe 1, alle anderen Bediener Software der Stufen 1 oder 2
	protected void calledFromSoftwareLevel3(Software s) {}
	protected void calledFromSoftwareLevel4(Software s) {}
	protected void calledFromSoftwareLevel5(Software s) {}
	
	
	// Bediener darf nur eine Leistung < 1KW haben
	protected void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	protected void calledFromLeistungFuenf(SensorenAktorenKit s) {}
	protected void calledFromLeistungZehn(SensorenAktorenKit s) {}
	
	protected void calledFromLeistungEins(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	
	// Bediener haben nur Software mit Level 1 oder 2
	protected void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s) {}
	protected void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s) {}
	protected void calledForLeistungZehnWithLevel3(SensorenAktorenKit s) {}
	protected void calledForLeistungZehnWithLevel4(SensorenAktorenKit s) {}
	
}