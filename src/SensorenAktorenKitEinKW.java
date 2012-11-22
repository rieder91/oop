
public class SensorenAktorenKitEinKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public SensorenAktorenKitEinKW() {
		seriennummer = null;
	}

	private SensorenAktorenKitEinKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	@Override
	public void vonBedienerInstalliert(Bediener android) {
		// TODO Auto-generated method stub
		android.calledFromLeistungEins(new SensorenAktorenKitEinKW(android.getSeriennummer()));

	}

	@Override
	public void vonKaempferInstalliert(Kaempfer android) {
		// TODO Auto-generated method stub
		android.calledFromLeistungEins(new SensorenAktorenKitEinKW(android.getSeriennummer()));

	}

	@Override
	public void vonLevel3Installiert(Android android) {
		// TODO Auto-generated method stub
		android.calledFromLeistungEins(new SensorenAktorenKitEinKW(android.getSeriennummer()));

	}

	@Override
	public void vonLevel4Installiert(Android android) {
		// TODO Auto-generated method stub
		android.calledFromLeistungEins(new SensorenAktorenKitEinKW(android.getSeriennummer()));
	}

}
