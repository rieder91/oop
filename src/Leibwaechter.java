
/**
 * ein leibwaechter darf nur LeibwaechterSoftware vom Level 4 verwenden
 * 
 * wenn sein SecurityLevel 4 ist, darf er Kits mit <= 10KW verwenden
 * 
 * @author Thomas
 *
 */
public class Leibwaechter extends Beschuetzer {

	/**
	 * default constructor
	 * @param seriennummer serial of the robot
	 */
	public Leibwaechter(String seriennummer) {
		super(seriennummer);
	}


	protected void calledFromLeibwaechterSoftware(Software s) {
		s.getSecurityLevel().vonLeibwaechterVerwendetFuerSoftware(this, s);
		
	}
	
	protected void calledFromKaempferSoftware(Software s) {}
	protected void calledFromObjektbewacherSoftware(Software s) {}
	
	protected void calledFromSoftwareLevel4(Software s) { 
		super.installieren(s);
	}
	
	protected void calledFromSoftwareLevel5(Software s) {}
	
	protected void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	
	protected void calledFromLeistungFuenf(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungFuenf(this, s);
	}
	
	protected void calledFromLeistungZehn(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungZehn(this, s);
	}
}
