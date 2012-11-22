

public class GepanzerterSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public GepanzerterSkin() {
		seriennummer = null;
	}
	
	private GepanzerterSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	public void einbauen(Android android) {
		android.calledFromGepanzert(new GepanzerterSkin(android.getSeriennummer()));
	}
}
