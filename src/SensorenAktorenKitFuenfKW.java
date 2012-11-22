
public class SensorenAktorenKitFuenfKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public SensorenAktorenKitFuenfKW() {
		seriennummer = null;
	}

	private SensorenAktorenKitFuenfKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	@Override
	public void vonBedienerInstalliert(Bediener android) {
		
	}

	@Override
	public void vonKaempferInstalliert(Kaempfer android) {
		// TODO Auto-generated method stub
		android.calledFromLeistungFuenf(new SensorenAktorenKitFuenfKW(android.getSeriennummer()));
		// ERLAUBT
		
	}

	@Override
	public void vonLevel3Installiert(Android android) {
		// TODO Auto-generated method stub
		android.calledForLeistungFuenfWithLevel3(new SensorenAktorenKitFuenfKW(android.getSeriennummer()));
		// ERLAUBT
		
	}

	@Override
	public void vonLevel4Installiert(Android android) {
		// TODO Auto-generated method stub
		android.calledForLeistungFuenfWithLevel4(new SensorenAktorenKitFuenfKW(android.getSeriennummer()));
		// ERLAUBT
		
	}

}
