

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
	public void einbauen(Bediener android) {
		// forbidden
	}

	@Override
	public void einbauen(Beschuetzer android) {
		android.calledFromGepanzert(new GepanzerterSkin(android.getSeriennummer()));
	}

	@Override
	public void einbauen(Schwerarbeiter android) {
		// forbidden
	}

	
}
