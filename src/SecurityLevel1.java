/**
 * Security Level 1 darf fuer die Software aller Bediener und fuer den
 * Gesellschaftler verwendet werden (der ja auch ein Bediener ist)
 * 
 * Security Level 1 ist nicht aufreichend um Aktoren mit 5 oder 10KW zu verwenden
 * 
 * @author Thomas
 * 
 */
public class SecurityLevel1 implements SecurityLevel {

	public void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s) {
		android.calledFromSoftwareLevel1(s);
	}

	public void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s) {
		android.calledFromSoftwareLevel1(s);
	}

	public void vonBauarbeiterVerwendetFuerSoftware(Bauarbeiter android,Software s) { }
	public void vonServiceTechnikerVerwendetFuerSoftware(ServiceTechniker android, Software s) { }
	public void vonTransportarbeiterVerwendetFuerSoftware(Transportarbeiter android, Software s) { }
	public void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s) { }
	public void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s) { }
	public void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s) { }
	
	public void calledWithLeistungFuenf(Android android, SensorenAktorenKit s) { }
	public void calledWithLeistungZehn(Android android, SensorenAktorenKit s) { }

	public String toString() {
		return "Security Level 1";
	}
}
