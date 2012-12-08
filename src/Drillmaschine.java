/**
 * drillmaschinen device which can be equipped by tractors
 * 
 * @author Markus
 * 
 */
@Creator(name = "Markus", lastUpdate = "07.12.2012")
public class Drillmaschine implements TraktorGeraet {
	private int anz;

	/**
	 * constructor which takes one arguments
	 * 
	 * @param anz
	 *            number of saescharen
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public Drillmaschine(int anz) {
		if (anz > 0) {
			this.anz = anz;
		} else {
			anz = 0;
		}
	}

	/**
	 * returns the saescharen count (int) as an object
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public Object getDetail() {
		return this.anz;
	}

	/**
	 * returns string representation of the device
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public String toString() {
		return "Drillmaschine mit " + anz + " Saescharen";
	}

}
