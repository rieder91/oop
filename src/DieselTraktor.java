/**
 * class which represents a dieseltraktor
 * 
 * @author Markus
 * 
 */
@Creator(name = "Markus", lastUpdate = "07.12.2012")
public class DieselTraktor extends Traktor {

	private int liter;

	/**
	 * two parameter constructor
	 * 
	 * @param name
	 *            name of the tractor
	 * @param serial
	 *            serial of the tractor
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public DieselTraktor(String name, int serial) {
		this(name, serial, null);
	}

	/**
	 * three parameter constructor
	 * 
	 * @param name
	 *            name of the tractor
	 * @param serial
	 *            serial of the tractor
	 * @param geraet
	 *            device attached to the tractor
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public DieselTraktor(String name, int serial, TraktorGeraet geraet) {
		super(name, serial, geraet);
		this.liter = 0;
	}

	/**
	 * @return the fuel used by the tractor
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	protected Object getFuel() {
		return this.liter;
	}

	/**
	 * increases the fuel used
	 * 
	 * @param liter
	 *            additional fuel used
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	protected void increaseFuel(Object liter) {
		if (liter instanceof Integer && (Integer) liter > 0) {
			this.liter += (Integer) liter;
		}
	}

	/**
	 * returns a string representation of the tractor
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public String toString() {
		return super.toString() + "; Typ: Dieseltraktor; Dieselverbrauch: "
				+ liter;
	}
}
