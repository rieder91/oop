
public class SensorenAktorenKitZehnKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public SensorenAktorenKitZehnKW() {
		seriennummer = null;
	}

	private SensorenAktorenKitZehnKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	
	public void integrieren(Android android) {
		android.calledFromLeistungZehn(new SensorenAktorenKitZehnKW(android.getSeriennummer()));
	}

}
