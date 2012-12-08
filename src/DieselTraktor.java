
public class DieselTraktor extends Traktor {

	private int liter;

	public DieselTraktor(String name, int serial) {
		super(name, serial);
		this.liter = 0;
	}

	public DieselTraktor(String name, int serial, TraktorGeraet geraet) {
		super(name, serial, geraet);
		this.liter = 0;
	}

	protected int getFuel() {
		return this.liter;
	}

	protected void increaseFuel(int liter) {
		if (liter > 0) {
			this.liter += liter;
		}
	}

	public String toString() {
		return super.toString() + "; Typ: Dieseltraktor; Dieselverbrauch: "
				+ liter;
	}
}
