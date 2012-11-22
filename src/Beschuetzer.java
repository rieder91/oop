
public abstract class Beschuetzer extends Android {

	public Beschuetzer(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calledFromGepanzert(GepanzerterSkin s) {
		super.installieren(s);
	}
	@Override
	public void calledFromHochfester(HochfesterSkin s) {
		super.installieren(s);
	}
	@Override
	public void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}

	@Override
	public void skinEinbauen(Skin s) {
		s.einbauen(this);
	}

	public  void calledFromBauarbeiterSoftware(BauarbeiterSoftware s) {}
	public  void calledFromGesellschaftlerSoftware(GesellschaftlerSoftware s) {}
	public  void calledFromHilfskraefteSoftware(HilfskraefteSoftware s) {}
	public  void calledFromServiceTechnikerSoftware(ServiceTechnikerSoftware s) {}
	public  void calledFromTransportarbeiterSoftware(TransportarbeiterSoftware s) {}


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
