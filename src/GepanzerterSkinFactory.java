
public class GepanzerterSkinFactory implements SkinFactory {
	public void einbauenIn(Bediener	android) {
		// Bediener darf nur den beruehrungssensitiven Skin haben
	}

	public void einbauenIn(Beschuetzer android) {
			android.integrate(new GepanzerterSkin(android.getSeriennummer()));
	}

	public void einbauenIn(Schwerarbeiter android) {
		// darf nur der Beschuetzer haben
	}
}
