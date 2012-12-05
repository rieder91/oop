

public class Duengerstreuer implements TraktorGeraet {
	private Double kapazitaet;

	/**
	 * @param kapazitaet
	 */
	//TODO sanity check
	public Duengerstreuer(double kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	@Override
	public Object getDetail() {
		return this.kapazitaet;
	}
	
	
}
