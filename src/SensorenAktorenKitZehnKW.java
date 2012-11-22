
public class SensorenAktorenKitZehnKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public SensorenAktorenKitZehnKW() {
		seriennummer = null;
	}

	private SensorenAktorenKitZehnKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	@Override
	public void vonBedienerInstalliert(Bediener android) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonKaempferInstalliert(Kaempfer android) {
		// TODO Auto-generated method stub
		android.calledFromLeistungZehn(new SensorenAktorenKitZehnKW(android.getSeriennummer()));
	}

	@Override
	public void vonLevel3Installiert(Android android) {
		// TODO Auto-generated method stub
		// NICHT ERLAUBT
		android.calledForLeistungZehnWithLevel3(this);
		
	}

	@Override
	public void vonLevel4Installiert(Android android) {
		// TODO Auto-generated method stub
		android.calledForLeistungZehnWithLevel4(new SensorenAktorenKitZehnKW(android.getSeriennummer()));
		
	}

}
