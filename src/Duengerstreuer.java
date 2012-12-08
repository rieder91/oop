/**
 * duengerstreuer-device which can be equipped by tractors
 * 
 * @author Markus
 * 
 */
@Creator(name = "Markus", lastUpdate = "07.12.2012")
public class Duengerstreuer implements TraktorGeraet {
	private double kapazitaet;

	/**
	 * constructor with one argumen
	 * 
	 * @param kapazitaet
	 *            capacity
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public Duengerstreuer(double kapazitaet) {
		if (kapazitaet > 0) {
			this.kapazitaet = kapazitaet;
		} else {
			kapazitaet = 0.0;
		}
	}

	/**
	 * returns the capacity (double) as an object
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public Object getDetail() {
		return this.kapazitaet;
	}

	/**
	 * returns string representation of the device
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public String toString() {
		return "Duengerstreuer mit " + kapazitaet + "l Fassungsvolumen";
	}

}
