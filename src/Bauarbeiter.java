

public class Bauarbeiter extends Schwerarbeiter {

	public Bauarbeiter(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void einbauen(BauarbeiterSoftware s) {
		super.integrate(s);
		// ERLAUBT
		
	}

	@Override
	public void einbauen(ServiceTechnikerSoftware s) {
		// NICHT ERLAUBT
		
	}

	@Override
	public void einbauen(TransportarbeiterSoftware s) {
		// NICHT ERLAUBT
		
	}

}
