

public abstract class Android {
	private String seriennummer;
	private Skin skin;
	private Software software;
	private SensorenAktorenKit kit;


	public Android(String seriennummer) {
		this.seriennummer = seriennummer;
		skin = null;
		software = null;
		kit = null;
	}

	protected String getSeriennummer() {
		return seriennummer;
	}

	protected void integrate(Skin s) {
		skin = s;
	}

	protected void integrate(Software s) {
		software = s;
	}

	protected void integrate(SensorenAktorenKit s) {
		kit = s;
	}

	/*********************/
	
	// Skin
	
	protected abstract void calledFromGepanzert(GepanzerterSkin s);
	protected abstract void calledFromHochfester(HochfesterSkin s);
	protected abstract void calledFromBeruehrungs(BeruehrungssensitiverSkin s);
	
	public abstract void einbauen(GepanzerterSkin s);
	public abstract void einbauen(HochfesterSkin s);
	public abstract void einbauen(BeruehrungssensitiverSkin s);
	
	/*********************/
	
	
	
	protected abstract void calledFromHilfssoftware(HilfskraefteSoftware s);

	

	public abstract void einbauen(HilfskraefteSoftware s);
	public abstract void einbauen(GesellschaftlerSoftware s);
	public abstract void einbauen(BauarbeiterSoftware s);
	public abstract void einbauen(ServiceTechnikerSoftware s);
	public abstract void einbauen(TransportarbeiterSoftware s);
	public abstract void einbauen(ObjektbewacherSoftware s);
	public abstract void einbauen(LeibwaechterSoftware s);
	public abstract void einbauen(KaempferSoftware s);

	/*****************/
	
	public abstract void erlaubnis(SecurityLevel1 l, GesellschaftlerSoftware s);
	
	public abstract void erlaubnis(SecurityLevel1 l, HilfskraefteSoftware s);
	public abstract void erlaubnis(SecurityLevel2 l, HilfskraefteSoftware s);
	
	public abstract void erlaubnis(SecurityLevel3 l, BauarbeiterSoftware s);
	public abstract void erlaubnis(SecurityLevel3 l, ServiceTechnikerSoftware s);
	public abstract void erlaubnis(SecurityLevel3 l, TransportarbeiterSoftware s);
	public abstract void erlaubnis(SecurityLevel4 l, BauarbeiterSoftware s);
	public abstract void erlaubnis(SecurityLevel4 l, ServiceTechnikerSoftware s);
	public abstract void erlaubnis(SecurityLevel4 l, TransportarbeiterSoftware s);
	
	public abstract void erlaubnis(SecurityLevel4 l, ObjektbewacherSoftware s);
	public abstract void erlaubnis(SecurityLevel4 l, LeibwaechterSoftware s);
	
	public abstract void erlaubnis(SecurityLevel5 l, KaempferSoftware s);

	/*****************/
}