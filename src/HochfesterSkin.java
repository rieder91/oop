

public class HochfesterSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public HochfesterSkin() {
		seriennummer = null;
	}
	
	private HochfesterSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	@Override
	public void einbauen(Bediener android) {
		// forbidden
	}

	@Override
	public void einbauen(Beschuetzer android) {
		android.calledFromHochfester(new HochfesterSkin(android.getSeriennummer()));
	}

	@Override
	public void einbauen(Schwerarbeiter android) {
		android.calledFromHochfester(new HochfesterSkin(android.getSeriennummer()));
	}
}
