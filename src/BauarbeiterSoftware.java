

public class BauarbeiterSoftware implements Software {

	@Override
	public void integrate(Hilfskraft android) {
		
	}

	@Override
	public void integrate(Gesellschaftler android) {
	}

	@Override
	public void integrate(Bauarbeiter android) {
		android.einbauen(this);
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
	}
}
