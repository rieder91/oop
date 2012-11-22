

public class HochfesterSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 */
	public HochfesterSkin() {
		seriennummer = null;
	}
	
	/**
	 * private constructor that is called from within another of the 
	 * same type as this to make the serial unique
	 * 
	 * @param seriennummer serial of the new skin
	 */
	private HochfesterSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	public void einbauen(Android android) {
		android.calledFromHochfester(new HochfesterSkin(android.getSeriennummer()));
	}
}
