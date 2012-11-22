
/**
 * ein objektbewache darf nur objektbewacher-software vom Level 4 verwenden
 * 
 * wenn er software vom level 4 hat, darf er kits mit <= 10 KW verwenden
 * 
 * @author Thomas
 *
 */
public class Objektbewacher extends Beschuetzer {

	/**
	 * default constructor
	 * @param seriennummer serial of the android
	 */
	public Objektbewacher(String seriennummer) {
		super(seriennummer);
	}

	public void calledFromObjektbewacherSoftware(Software s) {
		s.getSecurityLevel().vonObjektbewacherVerwendetFuerSoftware(this, s);
		
	}
	
	protected void calledFromKaempferSoftware(Software s) {}
	protected void calledFromLeibwaechterSoftware(Software s) {}
	
	public void calledFromSoftwareLevel4(Software s) { 
		super.installieren(s);
	}
	
	protected void calledFromSoftwareLevel5(Software s) {}
	
	protected void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	
	public void calledFromLeistungFuenf(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungFuenf(this, s);
	}
	
	public void calledFromLeistungZehn(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungZehn(this, s);
	}

}
