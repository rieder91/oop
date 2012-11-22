
public class Hilfskraft extends Bediener {

	public Hilfskraft(String seriennummer) {
		super(seriennummer);
	}
	
	public void calledFromHilfskraefteSoftware(Software s) {
		s.getSecurityLevel().vonHilfskraftVerwendetFuerSoftware(this, s);
	}
	
	protected void calledFromGesellschaftlerSoftware(Software s) {}
	
}
