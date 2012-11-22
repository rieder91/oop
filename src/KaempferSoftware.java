

public class KaempferSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	public KaempferSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
	private KaempferSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}





	@Override
	public void vonHilfskraftInstalliert(Hilfskraft android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void vonGesellschaftlerInstalliert(Gesellschaftler android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void vonBauarbeiterInstalliert(Bauarbeiter android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void vonServiceTechnikerInstalliert(ServiceTechniker android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void vonTransportarbeiterInstalliert(Transportarbeiter android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void vonObjektbewacherInstalliert(Objektbewacher android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void vonLeibwaechterInstalliert(Leibwaechter android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void vonKaempferInstalliert(Kaempfer android) {
		// TODO Auto-generated method stub
		android.calledFromKaempferSoftware(new KaempferSoftware(android.getSeriennummer(), this.level));

		
	}
	
	public SecurityLevel getSecurityLevel() {
		return level;
	}

}
