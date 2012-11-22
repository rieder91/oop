
/**
 * Nur der Kaempfer darf mit SecurityLevel 5 ausgestattet werden
 * 
 * es ist nicht angegeben, dass mit man mit level 5 ueberhaupt aktoren
 * verwenden darf. die Ausnahme fuer den Kaempfer ist naemlich laut Angabe
 * nicht von Level 5 abhhaengig
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

	public void calledWithLeistungFuenf(Android android, SensorenAktorenKit s) { }
	public void calledWithLeistungZehn(Android android, SensorenAktorenKit s) {	}
	
	public String toString() {
		return "Security Level 5";
	}
}
