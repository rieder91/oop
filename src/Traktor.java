/**
 * abstract class which contains all methods common to both BioGas- and
 * DieselTraktor
 * 
 * @author Thomas
 * 
 */
@Creator(name = "Thomas", lastUpdate = "08.12.2012")
public abstract class Traktor {

	private String name;
	private final Integer nummer;
	private int betriebsstunden;
	private TraktorGeraet geraet;

	// a list of all serials that are used; needed to keep tractor-serials
	// unique
	private static Liste usedSerials = new Liste();

	/**
	 * two parameter constructor
	 * 
	 * @param name
	 *            the name of the tractor
	 * @param serial
	 *            the (unique) serial of the tractor
	 */
	@Creator()
	public Traktor(String name, int serial) {
		this(name, serial, null);
	}

	/**
	 * three parameter constructor
	 * 
	 * @param name
	 *            the name of the tractor
	 * @param serial
	 *            the (unique) serial of the tractor
	 * @param geraet
	 *            the device that is attached to the tractor
	 */
	@Creator()
	public Traktor(String name, int serial, TraktorGeraet geraet) {
		if (usedSerials.contains(serial)) {
			throw new RuntimeException("Traktoren-Seriennummer existiert bereits");
		} else {
			usedSerials.add(serial);
		}

		this.nummer = serial;

		this.name = name;
		this.betriebsstunden = 0;
		this.geraet = geraet;

	}

	/**
	 * returns true if two objects are equals (only compares the serial though)
	 */
	@Creator()
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}

		if (other == null) {
			return false;
		}

		if (other.equals(this.nummer)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * changes the device attached to the tractor
	 * 
	 * @param geraet
	 *            new device (mustn't be null - use dismantle())
	 */
	@Creator()
	protected void setEinsatzart(TraktorGeraet geraet) {
		if (geraet != null) {
			this.geraet = geraet;
		}
	}

	/**
	 * removes the current device from the tractor
	 */
	@Creator()
	protected void dismantle() {
		this.geraet = null;
	}

	/**
	 * @return the device that is currently attached (can be null)
	 */
	@Creator()
	protected TraktorGeraet getGeraet() {
		return geraet;
	}

	/**
	 * increases the working hours of the tractor
	 * 
	 * @param hours
	 *            additional working hours
	 */
	@Creator(name = "Dominic", lastUpdate = "09.12.2012")
	protected void increaseHours(int hours) {
		if (hours > 0) {
			betriebsstunden += hours;
		}
	}

	/**
	 * @return the current working hours
	 */
	@Creator(name = "Dominic", lastUpdate = "06.12.2012")
	protected int getHours() {
		return this.betriebsstunden;
	}

	/**
	 * returns a string representation of the tractor for easier debugging
	 */
	@Creator()
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Name: " + name);
		ret.append("; Nummer: " + nummer);
		ret.append("; Betriebsstunden: " + betriebsstunden);
		ret.append("; Geraet: ");
		if (geraet == null) {
			ret.append("keines");
		} else {
			ret.append(geraet);
		}
		return ret.toString();
	}
	
	/**
	 * 
	 * @return
	 */
	@Creator(name = "Thomas", lastUpdate = "09.12.2012")
	protected abstract Object getFuel();
	
	/**
	 * 
	 * @param o
	 */
	@Creator(name = "Thomas", lastUpdate = "09.12.2012")
	protected abstract void increaseFuel(Object o);
}
