

public class HilfskraefteSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;

	public HilfskraefteSoftware(SecurityLevel level) {
		this.level = level;
		seriennummer = null;
	}
	
	private HilfskraefteSoftware(String seriennummer, SecurityLevel level) {
		this.seriennummer = seriennummer;
		this.level = level;
	}





	@Override
	public void vonHilfskraftInstalliert(Hilfskraft android) {
		// TODO Auto-generated method stub
		android.calledFromHilfskraefteSoftware(new HilfskraefteSoftware(android.getSeriennummer(), this.level));
		
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
		
	}


	public SecurityLevel getSecurityLevel() {
		return level;
	}
}
