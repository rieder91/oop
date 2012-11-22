
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
public class SecurityLevel2 implements SecurityLevel{

	public void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s) {
		android.calledFromSoftwareLevel2(s);
	}

	public void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s) { }
	public void vonSchwerarbeiterVerwendetFuerSoftware(Schwerarbeiter android, Software s) { }
	public void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s) { }
	public void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s) { }
	public void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s) { }

	public void calledWithLeistungFuenf(Android android, SensorenAktorenKit s) { }
	public void calledWithLeistungZehn(Android android, SensorenAktorenKit s) { }
	
	public String toString() {
		return "Security Level 2";
	}
}
