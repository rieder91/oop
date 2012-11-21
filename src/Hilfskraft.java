
public class Hilfskraft extends Bediener {

	public Hilfskraft(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}
	
	public void einbauen(HilfskraefteSoftware s) {
		s.getLevel().isAllowed(this, s);
		// ERLAUBT
	}
	
	public void einbauen(GesellschaftlerSoftware s) {
		// NICHT ERLAUBT
	}

	@Override
	public void erlaubnis(SecurityLevel1 l, HilfskraefteSoftware s) {
		super.integrate(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void erlaubnis(SecurityLevel2 l, HilfskraefteSoftware s) {
		super.integrate(s);
		
	}
	
	public void calledFromLevel1(HilfskraefteSoftware s) {
		super.integrate(s);
	}
	

}
