
public class BeruehrungsSkinFactory implements SkinFactory {
	
	public void einbauenIn(Bediener	android) {
		android.integrate(new BeruehrungssensitiverSkin(android.getSeriennummer()));
	}

	public void einbauenIn(Beschuetzer android) {
		android.integrate(new BeruehrungssensitiverSkin(android.getSeriennummer()));
	}

	public void einbauenIn(Schwerarbeiter android) {
		android.integrate(new BeruehrungssensitiverSkin(android.getSeriennummer()));
	}
}
