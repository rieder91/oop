

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
	public void installiertIn(Hilfskraft android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void installiertIn(Gesellschaftler android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void installiertIn(Bauarbeiter android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void installiertIn(ServiceTechniker android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void installiertIn(Transportarbeiter android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void installiertIn(Objektbewacher android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void installiertIn(Leibwaechter android) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void installiertIn(Kaempfer android) {
		// TODO Auto-generated method stub
		android.calledFromKaempferSoftware(new KaempferSoftware(android.getSeriennummer(), this.level));

		
	}
	
	public SecurityLevel getSecurityLevel() {
		return level;
	}

}
