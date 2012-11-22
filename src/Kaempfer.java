
/**
 * ein Kaempfer kann nur Kampfsoftware vom Level 5 verwenden
 * 
 * Er kann Aktoren-Kits mit unbegrenzt viel Leistung verwenden
 * 
 * 
 * @author Thomas
 *
 */
public class Kaempfer extends Beschuetzer {
	/**
	 * default constructor
	 * @param seriennummer serial of the android
	 */
	public Kaempfer(String seriennummer) {
		super(seriennummer);
	}


	public void calledFromKaempferSoftware(Software s) {
		s.getSecurityLevel().vonKaempferVerwendetFuerSoftware(this, s);
		
	}

	public void calledFromSoftwareLevel4(Software s) { }

	public void calledFromSoftwareLevel5(Software s) {
		super.installieren(s);
	}

	public void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	public void calledFromLeistungFuenf(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	public void calledFromLeistungZehn(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	protected void calledFromLeibwaechterSoftware(Software s) {}
	protected void calledFromObjektbewacherSoftware(Software s) {}
	
}
