

public class BiogasTraktor extends Traktor {

	private double kubikmeter;
	
	//TODO sanity check
	public BiogasTraktor (String name, int nummer){
		super(name,nummer);
		this.kubikmeter=0.0;
	}
	
	protected double getFuel (){
		return this.kubikmeter;
	}
	
	//TODO sanity check
	protected void incrFuel (double kubikmeter){
		this.kubikmeter+=kubikmeter;
	}
}
