
/**
 * darf in allen Androiden verbaut werden
 * 
 * in Bediener darf ausschliesslich dieses Kit verbaut werden
 * @author Thomas
 *
 */
public class SensorenAktorenKitEinKW implements SensorenAktorenKit {
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 * serial is null
	 */
	public SensorenAktorenKitEinKW() {
		seriennummer = null;
	}

	/**
	 * private constructor that is called from within another object of the 
	 * same type to make the serial unique
	 * 
	 * @param seriennummer serial of the new kit
	 */
	private SensorenAktorenKitEinKW(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	
	public void integrieren(Android android) {
		android.calledFromLeistungEins(new SensorenAktorenKitEinKW(android.getSeriennummer()));
	}
	
	public String toString() {
		return "Kit mit <= 1KW";
	}

}
