

public class SecurityLevel3 implements SecurityLevel {

	@Override
	public void vonHilfskraftVerwendetFuerSoftware(Hilfskraft android,
			Software s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonGesellschaftlerVerwendetFuerSoftware(
			Gesellschaftler android, Software s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonBauarbeiterVerwendetFuerSoftware(Bauarbeiter android,
			Software s) {
		android.calledFromSoftwareLevel4(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonServiceTechnikerVerwendetFuerSoftware(
			ServiceTechniker android, Software s) {
		android.calledFromSoftwareLevel4(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonTransportarbeiterVerwendetFuerSoftware(
			Transportarbeiter android, Software s) {
		android.calledFromSoftwareLevel4(s);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonObjektbewacherVerwendetFuerSoftware(Objektbewacher android,
			Software s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonLeibwaechterVerwendetFuerSoftware(Leibwaechter android,
			Software s) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void vonKaempferVerwendetFuerSoftware(Kaempfer android, Software s) {
		// TODO Auto-generated method stub
		
	}

}
