/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Doppelkeksbackmaschine extends Backmaschine {

	private EinfacherKeks template;
	
	/**
	 * 
	 * @param k
	 */
	protected Doppelkeksbackmaschine(EinfacherKeks k) {
		this.template = k;
	}
	
	/**
	 * 
	 */
	protected Keks backen(Position p){
		return (new Doppelkeks(this.template.clone(), this.template.clone() ,p.getFuellung()));
	}

}
