
public class BiogasTraktor extends Traktor {

	private double kubikmeter;

	public BiogasTraktor(String name, int serial) {
		super(name, serial);
		this.kubikmeter = 0.0;
	}

	public BiogasTraktor(String name, int serial, TraktorGeraet geraet) {
		super(name, serial, geraet);
		this.kubikmeter = 0.0;
	}

	protected double getFuel() {
		return this.kubikmeter;
	}

	protected void increaseFuel(double kubikmeter) {
		if (kubikmeter > 0) {
			this.kubikmeter += kubikmeter;
		}
	}

	public String toString() {
		return super.toString() + "; Typ: BiogasTraktor; Gasverbrauch: "
				+ kubikmeter;
	}
}
