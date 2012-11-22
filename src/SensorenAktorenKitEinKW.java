
public class SensorenAktorenKitEinKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public SensorenAktorenKitEinKW() {
		seriennummer = null;
	}

	private SensorenAktorenKitEinKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	
	public void integrieren(Android android) {
		android.calledFromLeistungEins(new SensorenAktorenKitEinKW(android.getSeriennummer()));
	}

}
