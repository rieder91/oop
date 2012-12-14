
public class Doppelkeks extends Keks{
	
	private Fuellung fuellung; 
	
	public Doppelkeks(Teigart t, Form f,Fuellung fu){
		super(t,f);
		this.fuellung=fu;
	}
	
	public Doppelkeks(Keks k,Fuellung fu){
		super(k);
		this.fuellung=fu;
	}
	
	public Doppelkeks(Doppelkeks dk){
		super(dk);
		this.fuellung=dk.fuellung;
	}
	
	@Override
	public Doppelkeks clone(){
		return (new Doppelkeks(this));
		
	}
	
	@Override
	public String toString(){
		return super.toString()+" Fuellung: " + fuellung;
	}
	
}
