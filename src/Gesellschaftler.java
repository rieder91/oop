
public class Gesellschaftler extends Bediener {

	public Gesellschaftler(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}

	public void einbauen(GesellschaftlerSoftware s) {
		// ERLAUBT
	}
	
	public void einbauen(HilfskraefteSoftware s) {
		// NICHT ERLAUBT
	}

	@Override
	public void erlaubnis(SecurityLevel1 l, Software s) {
		s.integrate(this);
	}

	@Override
	public void erlaubnis(SecurityLevel2 l, Software s) {
		s.integrate(this);
	}
}
