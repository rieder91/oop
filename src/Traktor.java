
public abstract class Traktor {

	private String name;
	private final Integer nummer;
	private int betriebsstunden;
	private TraktorGeraet geraet;

	private static Liste usedSerials = new Liste();

	public Traktor(String name, int serial) {
		this(name, serial, null);
	}

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

	protected void setEinsatzart(TraktorGeraet geraet) {
		if(geraet != null) {
			this.geraet = geraet;
		}
	}

	protected void dismantle() {
		this.geraet = null;
	}

	protected TraktorGeraet getGeraet() {
		return geraet;
	}

	protected int getSerial() {
		return nummer;
	}
	
	protected void increaseHours(int hours) {
		if(hours > 0) {
			betriebsstunden += hours;
		}
	}
	
	protected int getHours() {
		return this.betriebsstunden;
	}

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
