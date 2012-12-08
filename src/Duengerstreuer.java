@Creator()
public class Duengerstreuer implements TraktorGeraet {
	private double kapazitaet;

	/**
	 * @param kapazitaet
	 */
	@Creator()
	public Duengerstreuer(double kapazitaet) {
		if (kapazitaet > 0) {
			this.kapazitaet = kapazitaet;
		} else {
			kapazitaet = 0.0;
		}
	}

	@Creator()
	public Object getDetail() {
		return this.kapazitaet;
	}

	@Creator()
	public String toString() {
		return "Duengerstreuer mit " + kapazitaet + "l Fassungsvolumen";
	}

}
