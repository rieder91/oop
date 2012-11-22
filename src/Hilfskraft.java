
public class Hilfskraft extends Bediener {

	public Hilfskraft(String seriennummer) {
		super(seriennummer);
	}
	

	public void softwareInstallieren(Software s) {
		s.installiertIn(this);
	}

	// verboten
	public void calledFromGesellschaftlerSoftware(GesellschaftlerSoftware s) { }

	
	// erlaubt
	public void calledFromHilfskraefteSoftware(HilfskraefteSoftware s) {
		s.getSecurityLevel().vonHilfskraftVerwendetFuerSoftware(this, s);
	}


	// Level 1 und Level 2 sind erlaubt
	public void calledFromSoftwareLevel1(Software s) {
		super.installieren(s);
	}


	public void calledFromSoftwareLevel2(Software s) {
		super.installieren(s);
	}

	
}
