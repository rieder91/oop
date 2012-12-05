

public abstract class Traktor {

	private String name;
	private final int nummer;
	private int betriebsstunden;
	private TraktorGeraet geraet;
	
	private static int runningSerial = 1;
	
	//TODO sanity check
	public Traktor(String name){
		this(name, null);
	}
	
	public Traktor(String name, TraktorGeraet geraet){
		this.name=name;
		this.betriebsstunden=0;
		this.geraet=geraet;
		
		this.nummer=runningSerial;
		// increase running serial to keep it unique
		Traktor.runningSerial++;
	}
	
	//TODO sanity check
	protected void setEinsatzart(TraktorGeraet geraet){
		this.geraet=geraet;
	}
	
	protected void dismantle(){
		this.geraet=null;
	}
	
	protected Object getGeraet() {
		return geraet;
	}
	
	protected Integer getSaeschareCount() {
		if(geraet instanceof Drillmaschine) {
			return ((Drillmaschine) geraet).getDetail();
		} else {
			// 0 - weil das Geraet ja nicht installiert ist
			return 0;
		}
	}
	
	protected Double getDuengerCapacity() {
		if(geraet instanceof Duengerstreuer) {
			return ((Duengerstreuer) geraet).getDetail();
		} else {
			// 0 - weil das Geraet ja nicht installiert ist
			return 0.0;
		}
	}

	public int getNummer() {
		return nummer;
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Name: " + name);
		ret.append("; Nummer: " + nummer);
		ret.append("; Betriebsstunden: " + betriebsstunden);
		ret.append("; Geraet: ");
		if(geraet == null) {
			ret.append("keines");
		} else {
			ret.append(geraet);
		}
		return ret.toString();
	}
}
