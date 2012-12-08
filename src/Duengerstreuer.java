
public class Duengerstreuer implements TraktorGeraet {
	private double kapazitaet;

	/**
	 * @param kapazitaet
	 */
	public Duengerstreuer(double kapazitaet) {
		if (kapazitaet > 0) {
			this.kapazitaet = kapazitaet;
		} else {
			kapazitaet = 0.0;
		}
	}

	public Object getDetail() {
		return this.kapazitaet;
	}

	public String toString() {
		return "Duengerstreuer mit " + kapazitaet + "l Fassungsvolumen";
	}

}
