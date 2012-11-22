public class Gesellschaftler extends Bediener {

	public Gesellschaftler(String seriennummer) {
		super(seriennummer);
	}
	
	public void calledFromGesellschaftlerSoftware(Software s) {
		s.getSecurityLevel().vonGesellschaftlerVerwendetFuerSoftware(this, s);
	}

	public void calledFromHilfskraefteSoftware(Software s) { }
	
	// Gesellschafter benötigen Software der Stufe 1
	public void calledFromSoftwareLevel2(Software s) { }

	public void calledFromSoftwareLevel1(Software s) {
		super.installieren(s);
	}
}
