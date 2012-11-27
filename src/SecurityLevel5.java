
/**
 * Nur der Kaempfer darf mit SecurityLevel 5 ausgestattet werden
 * 
 * es ist nicht angegeben, dass mit man mit level 5 ueberhaupt aktoren
 * verwenden darf. die Ausnahme fuer den Kaempfer ist naemlich laut Angabe
 * nicht von Level 5 abhhaengig
 * 
 * @author OOP Gruppe 187
 *
 */
public class SecurityLevel5 extends SecurityLevel{

	protected void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s) { }
	protected void vonSchwerarbeiterVerwendetFuerSoftware(Schwerarbeiter android, Software s) { }
	protected void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s) { }
	protected void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s) { }
	protected void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s) { }

	protected void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s) {
		android.calledFromSoftwareLevel5(s);
	}

	protected void calledWithLeistungFuenf(Android android, SensorenAktorenKit s) { }
	protected void calledWithLeistungZehn(Android android, SensorenAktorenKit s) {	}
	
	public String toString() {
		return "Security Level 5";
	}
}
