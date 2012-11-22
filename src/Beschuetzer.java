/**
 * nur Beschuetzer duerfen gepanzerten Skin verwenden
 * 
 * alle Beschuetzer haben security level 4:
 * 
 * wird nicht hier definiert, weil es dann ein Problem mit der Vererbung des
 * Kaempfers gaebe (er wurde dann die Invariante verletzen, dass alle
 * Beschuetzer kein Security Level 5 haben). deshalb werden die security level
 * extra fuer alle untertypen implementiert
 * 
 * 
 * @author Thomas
 * 
 */
public abstract class Beschuetzer extends Android {

	public Beschuetzer(String seriennummer) {
		super(seriennummer);
	}

	// alle drei Skin Typen sind erlaubt
	protected void calledFromGepanzert(GepanzerterSkin s) {
		super.installieren(s);
	}

	protected void calledFromHochfester(HochfesterSkin s) {
		super.installieren(s);
	}

	protected void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}

	// nur die Software der Untertypen ist erlaubt
	protected void calledFromBauarbeiterSoftware(Software s) {}
	protected void calledFromGesellschaftlerSoftware(Software s) {}
	protected void calledFromHilfskraefteSoftware(Software s) {}
	protected void calledFromServiceTechnikerSoftware(Software s) {}
	protected void calledFromTransportarbeiterSoftware(Software s) {}
	
	// nur Software mit Level 4 oder 5 ist in einem der Untertypen erlaubt
	protected void calledFromSoftwareLevel1(Software s) {}
	protected void calledFromSoftwareLevel2(Software s) {}
	protected void calledFromSoftwareLevel3(Software s) {}
	
	// wenn die Software eines Beschuetzers das entsprechende Level 
	// hat koennen Kits mit 5 oder 10 KW verwendet werden
	protected void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s) {
		this.installieren(s);
	}
	
	protected void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s) {
		this.installieren(s);
	}
	
	protected void calledForLeistungZehnWithLevel4(SensorenAktorenKit s) {
		this.installieren(s);
	}
}
