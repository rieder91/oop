/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Doppelkeks extends Keks{
	
	private Fuellung fuellung; 
	
	/**
	 * 
	 * @param k
	 * @param fu
	 */
	protected Doppelkeks(Keks k,Fuellung fu){
		super(k);
		this.fuellung=fu;
	}
	
	/**
	 * 
	 * @param dk
	 */
	protected Doppelkeks(Doppelkeks dk){
		super(dk);
		this.fuellung=dk.fuellung;
	}
	
	/**
	 * 
	 */
	@Override
	protected Keks clone(){
		return (new Doppelkeks(this));
		
	}
	
	/**
	 * 
	 */
	@Override
	public String toString(){
		return super.toString()+" Fuellung: " + fuellung;
	}
	
}
