

public class DieselTraktor extends Traktor {

	private int liter;
	
	//TODO sanity check
	public DieselTraktor(String name){
		super(name);
		liter=0;
	}
	
	protected int getFuel (){
		return this.liter;
	}
	
	//TODO sanity check
	protected void incrFuel (int liter){
		this.liter+=liter;
	}
}
