
public class SensorenAktorenKitFuenfKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public SensorenAktorenKitFuenfKW() {
		seriennummer = null;
	}

	private SensorenAktorenKitFuenfKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	public void integrieren(Android android) {
		android.calledFromLeistungFuenf(new SensorenAktorenKitFuenfKW(android.getSeriennummer()));
	}

}
