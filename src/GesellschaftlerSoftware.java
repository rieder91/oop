

public class GesellschaftlerSoftware implements Software {
	private SecurityLevel level;
	
	public GesellschaftlerSoftware(SecurityLevel level) {
		this.level = level;
	}

	@Override
	public void integrate(Hilfskraft android) {
	}

	@Override
	public void integrate(Gesellschaftler android) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void integrate(Bauarbeiter android) {
	}

	@Override
	public void integrate(ServiceTechniker android) {
	}

	@Override
	public void integrate(Transportarbeiter android) {
	}

	@Override
	public void integrate(Objektbewacher android) {
	}

	@Override
	public void integrate(Leibwaechter android) {
	}

	@Override
	public void integrate(Kaempfer android) {
		// TODO Auto-generated method stub
		
	}

}
