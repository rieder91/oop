

public class GepanzerterSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public GepanzerterSkin() {
		seriennummer = null;
	}
	
	private GepanzerterSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	@Override
	public void integrate(Bediener android) {
		// forbidden
	}

	@Override
	public void integrate(Beschuetzer android) {
		android.calledFromGepanzert(new GepanzerterSkin(android.getSeriennummer()));
	}

	@Override
	public void integrate(Schwerarbeiter android) {
		// forbidden
	}

	
}
