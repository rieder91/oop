
@Creator()
public class BiogasTraktor extends Traktor {

	private double kubikmeter;
	
	@Creator()
	public BiogasTraktor(String name, int serial) {
		super(name, serial);
		this.kubikmeter = 0.0;
	}

	@Creator()
	public BiogasTraktor(String name, int serial, TraktorGeraet geraet) {
		super(name, serial, geraet);
		this.kubikmeter = 0.0;
	}

	@Creator()
	protected double getFuel() {
		return this.kubikmeter;
	}

	@Creator()
	protected void increaseFuel(double kubikmeter) {
		if (kubikmeter > 0) {
			this.kubikmeter += kubikmeter;
		}
	}

	@Creator()
	public String toString() {
		return super.toString() + "; Typ: BiogasTraktor; Gasverbrauch: "
				+ kubikmeter;
	}
}
