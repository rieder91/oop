
public abstract class Beschuetzer extends Android {

	public Beschuetzer(String seriennummer) {
		super(seriennummer);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void calledFromGepanzert(GepanzerterSkin s) {
		super.integrate(s);
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
		s.integrate(this);
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
	public  void einbauen(HilfskraefteSoftware s){

	}
	@Override
	public  void einbauen(GesellschaftlerSoftware s) {

	}
	
	@Override
	public  void einbauen(BauarbeiterSoftware s) {

	}
	@Override
	public  void einbauen(ServiceTechnikerSoftware s) {

	}
	@Override
	public  void einbauen(TransportarbeiterSoftware s) {

	}
	
}
