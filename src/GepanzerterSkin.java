
/**
 * der gepanzerte Skin wird nur von Beschuetzern verwendet
 * 
 * @author Thomas
 *
 */
public class GepanzerterSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 */
	public GepanzerterSkin() {
		seriennummer = null;
	}
	
	/**
	 * private constructor that is called from within another object of the 
	 * same type to make the serial unique
	 * 
	 * @param seriennummer serial of the new skin
	 */
	private GepanzerterSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	public void einbauen(Android android) {
		android.calledFromGepanzert(new GepanzerterSkin(android.getSeriennummer()));
	}
	
	public String toString() {
		return "Gepanzerter Skin";
	}
}
