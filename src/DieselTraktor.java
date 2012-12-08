@Creator()
public class DieselTraktor extends Traktor {

	private int liter;
	
	@Creator()
	public DieselTraktor(String name, int serial) {
		super(name, serial);
		this.liter = 0;
	}

	@Creator()
	public DieselTraktor(String name, int serial, TraktorGeraet geraet) {
		super(name, serial, geraet);
		this.liter = 0;
	}

	@Creator()
	protected int getFuel() {
		return this.liter;
	}

	@Creator()
	protected void increaseFuel(int liter) {
		if (liter > 0) {
			this.liter += liter;
		}
	}

	@Creator()
	public String toString() {
		return super.toString() + "; Typ: Dieseltraktor; Dieselverbrauch: "
				+ liter;
	}
}
