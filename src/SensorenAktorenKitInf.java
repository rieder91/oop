
public class SensorenAktorenKitInf implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;
	
	public SensorenAktorenKitInf() {
		seriennummer = null;
	}
	
	private SensorenAktorenKitInf(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	
	public void integrieren(Android android) {
		android.calledFromLeistungUnbegrenzt(new SensorenAktorenKitInf(android.getSeriennummer()));
	}


}
