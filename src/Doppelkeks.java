/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Doppelkeks implements Keks {
	
	private Fuellung fuellung;
	private EinfacherKeks oberSeite;
	private EinfacherKeks unterSeite;
	
	/**
	 * 
	 * @param k
	 * @param fu
	 */
	protected Doppelkeks(EinfacherKeks k1, EinfacherKeks k2, Fuellung fu){
		this.oberSeite = k1;
		this.unterSeite = k2;
		this.fuellung=fu;
	}
	
	/**
	 * 
	 * @param dk
	 */
	protected Doppelkeks(Doppelkeks dk){
		this.oberSeite = new EinfacherKeks(dk.oberSeite);
		this.unterSeite = new EinfacherKeks(dk.unterSeite);
		this.fuellung=dk.fuellung;
	}
	
	/**
	 * 
	 */
	@Override
	protected Doppelkeks clone(){
		return (new Doppelkeks(this));
		
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Doppelter Keks:\n");
		ret.append("\tOberseite:\t" + oberSeite + "\n");
		ret.append("\tUnterseite:\t" + unterSeite + "\n");
		ret.append("\tFuellung:\t" + fuellung);
		
		return ret.toString();
	}
	
}
