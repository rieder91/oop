
/**
 * wird von allen Bedienern verwendet
 * 
 * @author OOP Gruppe 187
 *
 */
public class BeruehrungssensitiverSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	/**
	 * default constructor
	 */
	public BeruehrungssensitiverSkin() {
		seriennummer = null;
	}
	
	/**
	 * private constructor that is called from within another object of the 
	 * same type to make the serial unique
	 * 
	 * @param seriennummer serial of the new skin
	 */
	private BeruehrungssensitiverSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	public void einbauen(Android android) {
		android.calledFromBeruehrungs(new BeruehrungssensitiverSkin(android.getSeriennummer()));
	}
	
	public String toString() {
		return "Beruehrungssensitiver Skin";
	}
}
