/**
 * darf in allen Androiden mit Software Level 4 verbaut werden
 * @author Thomas
 *
 */
public class SensorenAktorenKitZehnKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 * serial is null
	 */
	public SensorenAktorenKitZehnKW() {
		seriennummer = null;
	}

	/**
	 * private constructor that is called from within another object of the 
	 * same type to make the serial unique
	 * 
	 * @param seriennummer serial of the new kit
	 */
	private SensorenAktorenKitZehnKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	
	public void integrieren(Android android) {
		android.calledFromLeistungZehn(new SensorenAktorenKitZehnKW(android.getSeriennummer()));
	}

}
