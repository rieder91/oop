
/**
 * security level klasse, dass verwendet wird um zu pruefen ob eine software
 * verwendet oder ein kit eingebaut werden kann
 * 
 * @author Thomas
 * 
 */
public abstract class SecurityLevel {
	protected abstract void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s);

	protected abstract void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s);

	protected abstract void vonSchwerarbeiterVerwendetFuerSoftware(Schwerarbeiter android, Software s);

	protected abstract void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s);

	protected abstract void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s);

	protected abstract void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s);
	
	protected abstract void calledWithLeistungFuenf(Android android, SensorenAktorenKit s);
	
	protected abstract void calledWithLeistungZehn(Android android, SensorenAktorenKit s);
	
}
