

public abstract class Bediener extends Android {

	public Bediener(String seriennummer) {
		super(seriennummer);
	}

	@Override
	protected void calledFromGepanzert(GepanzerterSkin s) {
		// forbidden
	}
	@Override
	protected void calledFromHochfester(HochfesterSkin s) {
		// forbidden
	}
	@Override
	protected void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
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
		// forbidden
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
	@Override
	public  void einbauen(ObjektbewacherSoftware s){
		
	}
	
	@Override
	public  void einbauen(LeibwaechterSoftware s) {
		// NICHT ERLAUBT
	}
	@Override
	public  void einbauen(KaempferSoftware s) {
		// NICHT ERLAUBT
	}
	
	
	public abstract void erlaubnis(SecurityLevel1 l, Software s);
	
	public abstract void erlaubnis(SecurityLevel2 l, Software s);
	
	public void erlaubnis(SecurityLevel3 l, Software s) {
		// NICHT ERLAUBT
	}
	public void erlaubnis(SecurityLevel4 l, Software s) {
		// NICHT ERLAUBT
	}
	public void erlaubnis(SecurityLevel5 l, Software s) {
		// NICHT ERLAUBT
	}
	
}