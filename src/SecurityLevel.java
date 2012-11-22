
/**
 * security level interface, dass verwendet wird um zu pruefen ob eine software
 * verwendet oder ein kit eingebaut werden kann
 * 
 * @author Thomas
 * 
 */
public interface SecurityLevel {
	public void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s);

	public void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s);

	public void vonSchwerarbeiterVerwendetFuerSoftware(Schwerarbeiter android, Software s);

	public void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s);

	public void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s);

	public void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s);
	
	public void calledWithLeistungFuenf(Android android, SensorenAktorenKit s);
	
	public void calledWithLeistungZehn(Android android, SensorenAktorenKit s);
	
}
