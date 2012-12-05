

public abstract class Traktor {

	private String name;
	private final int nummer;
	private int betriebsstunden;
	private TraktorGeraet geraet;
	
	//TODO sanity check
	public Traktor(String name, int nummer){
		this.name=name;
		this.nummer=nummer;
		this.betriebsstunden=0;
		this.geraet=null;
	}
	
	public Traktor(String name, int nummer,TraktorGeraet geraet){
		this.name=name;
		this.nummer=nummer;
		this.betriebsstunden=0;
		this.geraet=geraet;
	}
	
	//TODO sanity check
	protected void setEinsatzart(TraktorGeraet geraet){
		this.geraet=geraet;
	}
	
	protected void dismantle(){
		this.geraet=null;
	}
}
