/**
 * class which represents a biogastraktor
 * 
 * @author Markus
 * 
 */
@Creator(name = "Markus", lastUpdate = "07.12.2012")
public class BiogasTraktor extends Traktor {

	private double kubikmeter;

	/**
	 * two parameter constructor
	 * 
	 * @param name
	 *            name of the tractor
	 * @param serial
	 *            serial of the tractor
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public BiogasTraktor(String name, int serial) {
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
	public BiogasTraktor(String name, int serial, TraktorGeraet geraet) {
		super(name, serial, geraet);
		this.kubikmeter = 0.0;
	}

	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	protected double getFuel() {
		return this.kubikmeter;
	}

	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	protected void increaseFuel(double kubikmeter) {
		if (kubikmeter > 0) {
			this.kubikmeter += kubikmeter;
		}
	}

	/**
	 * returns a string representation of the tractor
	 */
	@Creator(name = "Markus", lastUpdate = "07.12.2012")
	public String toString() {
		return super.toString() + "; Typ: BiogasTraktor; Gasverbrauch: "
				+ kubikmeter;
	}
}
