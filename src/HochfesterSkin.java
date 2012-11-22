

public class HochfesterSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public HochfesterSkin() {
		seriennummer = null;
	}
	
	private HochfesterSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	public void einbauen(Android android) {
		android.calledFromHochfester(new HochfesterSkin(android.getSeriennummer()));
	}
}
