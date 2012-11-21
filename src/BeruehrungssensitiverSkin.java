

public class BeruehrungssensitiverSkin implements Skin {
	@SuppressWarnings("unused")
	private final String seriennummer;

	public BeruehrungssensitiverSkin() {
		seriennummer = null;
	}
	
	private BeruehrungssensitiverSkin(String seriennummer) {
		this.seriennummer = seriennummer;
	}

	@Override
	public void integrate(Bediener android) {
		android.calledFromBeruehrungs(new BeruehrungssensitiverSkin(android.getSeriennummer()));
	}

	@Override
	public void integrate(Beschuetzer android) {
		android.calledFromBeruehrungs(new BeruehrungssensitiverSkin(android.getSeriennummer()));
	}

	@Override
	public void integrate(Schwerarbeiter android) {
		android.calledFromBeruehrungs(new BeruehrungssensitiverSkin(android.getSeriennummer()));
	}

}
