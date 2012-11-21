
public class HochfesterSkinFactory implements SkinFactory {
	public void einbauenIn(Bediener	android) {
		// Bediener darf nur den beruehrungssensitiven Skin haben
	}

	public void einbauenIn(Beschuetzer android) {
		android.integrate(new HochfesterSkin(android.getSeriennummer()));
	}

	public void einbauenIn(Schwerarbeiter android) {
		android.integrate(new HochfesterSkin(android.getSeriennummer()));
	}
}
