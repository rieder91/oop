
public class SensorenAktorenKitZehnKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public SensorenAktorenKitZehnKW() {
		seriennummer = null;
	}

	private SensorenAktorenKitZehnKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	public void vonBedienerInstalliert(Bediener android) {	}

	public void vonKaempferInstalliert(Kaempfer android) {
		android.calledFromLeistungZehn(new SensorenAktorenKitZehnKW(android.getSeriennummer()));
	}

	public void vonLevel3Installiert(Android android) {
		android.calledForLeistungZehnWithLevel3(this);
		
	}

	public void vonLevel4Installiert(Android android) {
		android.calledForLeistungZehnWithLevel4(new SensorenAktorenKitZehnKW(android.getSeriennummer()));
	}

}
