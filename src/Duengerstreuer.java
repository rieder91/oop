

public class Duengerstreuer implements TraktorGeraet {
	private double kapazitaet;

	/**
	 * @param kapazitaet
	 */
	//TODO sanity check
	public Duengerstreuer(double kapazitaet) {
		this.kapazitaet = kapazitaet;
	}

	public double getDetail() {
		return this.kapazitaet;
	}
	
	public String toString() {
		return "Duengerstreuer mit " + kapazitaet + "l Fassungsvolumen";
	}
	
}
