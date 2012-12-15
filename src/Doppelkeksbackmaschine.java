/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Doppelkeksbackmaschine extends Backmaschine {

	Keks k;
	
	/**
	 * 
	 * @param k
	 */
	protected Doppelkeksbackmaschine(Keks k) {
		this.k=k;
	}
	
	/**
	 * 
	 */
	protected Keks backen(Position p){
		return (new Doppelkeks(this.k.clone(),p.getFuellung()));
	}

}
