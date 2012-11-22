
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


	protected void calledFromKaempferSoftware(Software s) {
		s.getSecurityLevel().vonKaempferVerwendetFuerSoftware(this, s);
		
	}

	protected void calledFromSoftwareLevel4(Software s) { }

	protected void calledFromSoftwareLevel5(Software s) {
		super.installieren(s);
	}

	protected void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	protected void calledFromLeistungFuenf(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	protected void calledFromLeistungZehn(SensorenAktorenKit s) {
		super.installieren(s);
	}
	
	protected void calledFromLeibwaechterSoftware(Software s) {}
	protected void calledFromObjektbewacherSoftware(Software s) {}
	
	public String toString() {
		return "Typ: Kampf-Roboter" + super.toString();
	}
}
