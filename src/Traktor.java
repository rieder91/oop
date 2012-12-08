@Creator()
public abstract class Traktor {

	private String name;
	private final Integer nummer;
	private int betriebsstunden;
	private TraktorGeraet geraet;

	private static Liste usedSerials = new Liste();

	@Creator()
	public Traktor(String name, int serial) {
		this(name, serial, null);
	}

	@Creator()
	public Traktor(String name, int serial, TraktorGeraet geraet) {
		if (usedSerials.contains(serial)) {
			throw new RuntimeException("Serial already exists");
		} else {
			usedSerials.add(serial);
		}

		this.nummer = serial;

		this.name = name;
		this.betriebsstunden = 0;
		this.geraet = geraet;

	}

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

	@Creator()
	protected void setEinsatzart(TraktorGeraet geraet) {
		if(geraet != null) {
			this.geraet = geraet;
		}
	}

	@Creator()
	protected void dismantle() {
		this.geraet = null;
	}

	@Creator()
	protected TraktorGeraet getGeraet() {
		return geraet;
	}

	@Creator()
	protected int getSerial() {
		return nummer;
	}

	@Creator()
	protected void increaseHours(int hours) {
		if(hours > 0) {
			betriebsstunden += hours;
		}
	}

	@Creator()
	protected int getHours() {
		return this.betriebsstunden;
	}

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
}
