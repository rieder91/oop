
/**
 * darf nur im Kaempfer verbaut werden (unabhaengig vom Software Level)
 * @author Thomas
 *
 */
public class SensorenAktorenKitInf implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;
	
	/**
	 * default constructor
	 * serial is null
	 */
	public SensorenAktorenKitInf() {
		seriennummer = null;
	}
	
	/**
	 * private constructor that is called from within another object of the 
	 * same type to make the serial unique
	 * 
	 * @param seriennummer serial of the new kit
	 */
	private SensorenAktorenKitInf(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	
	public void integrieren(Android android) {
		android.calledFromLeistungUnbegrenzt(new SensorenAktorenKitInf(android.getSeriennummer()));
	}


}
