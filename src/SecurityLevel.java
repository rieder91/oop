

public interface SecurityLevel {
	public void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android, Software s);

	public void vonGesellschaftlerVerwendetFuerSoftware(Gesellschaftler android, Software s);

	public void vonBauarbeiterVerwendetFuerSoftware(Bauarbeiter android, Software s);

	public void vonServiceTechnikerVerwendetFuerSoftware(ServiceTechniker android, Software s);

	public void vonTransportarbeiterVerwendetFuerSoftware(Transportarbeiter android, Software s);

	public void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android, Software s);

	public void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android, Software s);

	public void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s);
	
	public void vomAndroidFuerAktoren(Android android, SensorenAktorenKit s);
	
}
