/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Doppelkeksbackmaschine extends Backmaschine {

	private EinfacherKeks vorlage;
	
	/**
	 * 
	 * @param vorlage
	 */
	protected Doppelkeksbackmaschine(EinfacherKeks vorlage) {
		this.vorlage = vorlage;
	}
	
	
	/**
	 * 
	 */
	protected Keks backen(Position p){
		Fuellung f = p.getFuellung();
		if(f != null) {
			return (new Doppelkeks(this.vorlage, this.vorlage.clone() , f));
		} else {
			return null;
		}
	}

}
