
/**
 * darf in allen Androiden ausser Bedienern mit Software Level 3 oder 4 verbaut
 * werden
 * 
 * @author OOP Gruppe 187
 * 
 */
public class SensorenAktorenKitFuenfKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 * serial is null
	 */
	public SensorenAktorenKitFuenfKW() {
		seriennummer = null;
	}

	/**
	 * private constructor that is called from within another object of the 
	 * same type to make the serial unique
	 * 
	 * @param seriennummer serial of the new kit
	 */
	private SensorenAktorenKitFuenfKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	public void integrieren(Android android) {
		android.calledFromLeistungFuenf(new SensorenAktorenKitFuenfKW(android.getSeriennummer()));
	}

	public String toString() {
		return "Kit mit <= 5KW";
	}
}
