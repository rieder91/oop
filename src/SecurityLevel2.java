
/**
 * Security Level 2 darf fuer die Software aller Bediener ausser Gesellschaftler
 * verwendet werden
 * 
 * 
 * Security Level 1 ist nicht aufreichend um Aktoren mit 5 oder 10KW zu
 * verwenden
 * 
 * @author Thomas
 * 
 */
public class SecurityLevel2 extends SecurityLevel{

	protected void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s) {
		android.calledFromSoftwareLevel2(s);
	}

	protected void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s) { }
	protected void vonSchwerarbeiterVerwendetFuerSoftware(Schwerarbeiter android, Software s) { }
	protected void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s) { }
	protected void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s) { }
	protected void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s) { }

	protected void calledWithLeistungFuenf(Android android, SensorenAktorenKit s) { }
	protected void calledWithLeistungZehn(Android android, SensorenAktorenKit s) { }
	
	public String toString() {
		return "Security Level 2";
	}
}
