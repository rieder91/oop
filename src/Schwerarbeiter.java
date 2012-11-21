
public abstract class Schwerarbeiter extends Android{

	public Schwerarbeiter(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calledFromGepanzert(GepanzerterSkin s) {
		// forbidden
	}
	@Override
	public void calledFromHochfester(HochfesterSkin s) {
		super.integrate(s);
	}
	@Override
	public void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.integrate(s);
	}
	
	
	@Override
	public void einbauen(GepanzerterSkin s) {
		// forbidden
	}
	
	@Override
	public void einbauen(BeruehrungssensitiverSkin s) {
		s.integrate(this);
	}
	
	@Override
	public void einbauen(HochfesterSkin s) {
		s.integrate(this);
	}
	
	
	
	
	@Override
	public  void einbauen(HilfskraefteSoftware s) {

	}
	
	@Override
	public  void einbauen(GesellschaftlerSoftware s) {

	}

	@Override
	public  void einbauen(ObjektbewacherSoftware s){

	}
	@Override
	public  void einbauen(LeibwaechterSoftware s) {

	}
	@Override
	public  void einbauen(KaempferSoftware s) {
	
	}
	
	
	
	
	
	
}
