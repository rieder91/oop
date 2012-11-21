

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
	public void integrate(Bediener android) {
		// forbidden
	}

	@Override
	public void integrate(Beschuetzer android) {
		android.calledFromHochfester(new HochfesterSkin(android.getSeriennummer()));
	}

	@Override
	public void integrate(Schwerarbeiter android) {
		android.calledFromHochfester(new HochfesterSkin(android.getSeriennummer()));
	}
}
