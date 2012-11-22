
/**
 * Alle Schwerarbeiter duerfen Security Level 3 verwenden.
 * 
 * Mit Security Level 3 darf man Aktoren mit 5KW verwenden. 10KW jedoch nicht
 * 
 * @author Thomas
 * 
 */
public class SecurityLevel3 implements SecurityLevel {

	public void vonSchwerarbeiterVerwendetFuerSoftware(Schwerarbeiter android, Software s) {
		android.calledFromSoftwareLevel4(s);
	}

	public void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s) { }
	public void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s) { }
	public void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s) { }
	public void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s) { }
	public void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s) { }

	public void calledWithLeistungFuenf(Android android, SensorenAktorenKit s) {
		android.calledForLeistungFuenfWithLevel3(s);
	}

	public void calledWithLeistungZehn(Android android, SensorenAktorenKit s) { }

	public String toString() {
		return "Security Level 3";
	}
}
