
public abstract class Beschuetzer extends Android {

	public Beschuetzer(String seriennummer) {
		super(seriennummer);
	}

	/*
	 * Beschuezter duerfen alle Skin-Typen haben
	 * (non-Javadoc)
	 * @see Android#calledFromGepanzert(GepanzerterSkin)
	 */
	
	protected void calledFromGepanzert(GepanzerterSkin s) {
		super.installieren(s);
	}

	protected void calledFromHochfester(HochfesterSkin s) {
		super.installieren(s);
	}

	protected void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}


	protected void calledFromBauarbeiterSoftware(Software s) {}
	protected void calledFromGesellschaftlerSoftware(Software s) {}
	protected void calledFromHilfskraefteSoftware(Software s) {}
	protected void calledFromServiceTechnikerSoftware(Software s) {}
	protected void calledFromTransportarbeiterSoftware(Software s) {}


	protected void calledFromSoftwareLevel1(Software s) {}
	protected void calledFromSoftwareLevel2(Software s) {}
	protected void calledFromSoftwareLevel3(Software s) {}

	
	protected abstract void calledFromLeistungUnbegrenzt(SensorenAktorenKit s);
	protected abstract void calledFromLeistungFuenf(SensorenAktorenKit s);
	protected abstract void calledFromLeistungZehn(SensorenAktorenKit s);
	

	protected void calledFromLeistungEins(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	
}
