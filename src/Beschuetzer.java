
public abstract class Beschuetzer extends Android {

	public Beschuetzer(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
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


	public  void calledFromBauarbeiterSoftware(Software s) {}
	public  void calledFromGesellschaftlerSoftware(Software s) {}
	public  void calledFromHilfskraefteSoftware(Software s) {}
	public  void calledFromServiceTechnikerSoftware(Software s) {}
	public  void calledFromTransportarbeiterSoftware(Software s) {}


	public  void calledFromSoftwareLevel1(Software s) {}
	public  void calledFromSoftwareLevel2(Software s) {}
	public  void calledFromSoftwareLevel3(Software s) {}

	public abstract void calledFromLeistungUnbegrenzt(SensorenAktorenKit s);

	public  void calledFromLeistungEins(SensorenAktorenKit s) {
		super.installieren(s);
	}
	public abstract void calledFromLeistungFuenf(SensorenAktorenKit s);


	public abstract void calledFromLeistungZehn(SensorenAktorenKit s);
}
