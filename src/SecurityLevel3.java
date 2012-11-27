
/**
 * Alle Schwerarbeiter duerfen Security Level 3 verwenden.
 * 
 * Mit Security Level 3 darf man Aktoren mit 5KW verwenden. 10KW jedoch nicht
 * 
 * @author OOP Gruppe 187
 * 
 */
public class SecurityLevel3 extends SecurityLevel {

	protected void vonSchwerarbeiterVerwendetFuerSoftware(Schwerarbeiter android, Software s) {
		android.calledFromSoftwareLevel4(s);
	}

	protected void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s) { }
	protected void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s) { }
	protected void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s) { }
	protected void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s) { }
	protected void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s) { }

	protected void calledWithLeistungFuenf(Android android, SensorenAktorenKit s) {
		android.calledForLeistungFuenfWithLevel3(s);
	}

	protected void calledWithLeistungZehn(Android android, SensorenAktorenKit s) { }

	public String toString() {
		return "Security Level 3";
	}
}
