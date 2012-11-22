
public class Hilfskraft extends Bediener {

	public Hilfskraft(String seriennummer) {
		super(seriennummer);
	}
	

	// verboten
	public void calledFromGesellschaftlerSoftware(Software s) { }

	
	// erlaubt
	public void calledFromHilfskraefteSoftware(Software s) {
		s.getSecurityLevel().vonHilfskraftVerwendetFuerSoftware(this, s);
	}


	// alle anderen Bediener Software der Stufen 1 oder 2
	public void calledFromSoftwareLevel1(Software s) {
		super.installieren(s);
	}

	public void calledFromSoftwareLevel2(Software s) {
		super.installieren(s);
	}

	
}
