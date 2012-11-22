

public class BeruehrungssensitiverSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public BeruehrungssensitiverSkin() {
		seriennummer = null;
	}
	
	private BeruehrungssensitiverSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	public void einbauen(Android android) {
		android.calledFromBeruehrungs(new BeruehrungssensitiverSkin(android.getSeriennummer()));
	}
}
