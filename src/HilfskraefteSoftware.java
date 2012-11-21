

public class HilfskraefteSoftware implements Software {
	private SecurityLevel level;

	public HilfskraefteSoftware(SecurityLevel level) {
		this.level = level;
	}

	@Override
	public void integrate(Hilfskraft android) {
		android.erlaubnis(level, this);
		// TODO Auto-generated method stub

	}

	@Override
	public void integrate(Gesellschaftler android) {
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
	}

	
	/**
	 * @return the level
	 */
	protected SecurityLevel getLevel() {
		return level;
	}


}
