
/**
 * Nur der Kaempfer darf mit SecurityLevel 5 ausgestattet werden
 * 
 * Mit Level 5 darf man sowohl 5KW als auch 10KW Aktoren verwenden
 * 
 * @author Thomas
 *
 */
public class SecurityLevel5 implements SecurityLevel{

	public void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s) { }
	public void vonSchwerarbeiterVerwendetFuerSoftware(Schwerarbeiter android, Software s) { }
	public void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s) { }
	public void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s) { }
	public void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s) { }

	public void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s) {
		android.calledFromSoftwareLevel5(s);
	}

	public void calledWithLeistungFuenf(Android android, SensorenAktorenKit s) {
		android.calledForLeistungFuenfWithLevel4(s);
	}

	public void calledWithLeistungZehn(Android android, SensorenAktorenKit s) {
		android.calledForLeistungZehnWithLevel4(s);
	}
	
	public String toString() {
		return "Security Level 5";
	}
}
