

public class BauarbeiterSoftware implements Software {
	private SecurityLevel level;
	@SuppressWarnings("unused")
	private final String seriennummer;
	
	public BauarbeiterSoftware(SecurityLevel level) {
		this.level = level;
		this.seriennummer = null;
	}
	
	private BauarbeiterSoftware(String seriennummer, SecurityLevel level) {
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
		android.calledFromBauarbeiterSoftware(new BauarbeiterSoftware(android.getSeriennummer(), this.level));
		
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
		
	}
	
	public SecurityLevel getSecurityLevel() {
		return level;
	}
	
}
