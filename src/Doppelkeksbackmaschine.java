/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Doppelkeksbackmaschine extends Backmaschine {

	private EinfacherKeks vorlage;
	private Fuellung fuellung;
	
	/**
	 * 
	 * @param vorlage
	 */
	protected Doppelkeksbackmaschine(EinfacherKeks vorlage) {
		this.vorlage = vorlage;
		this.fuellung = null;
	}
	
	protected void setFuellung(Fuellung fuellung) {
		this.fuellung = fuellung;
	}
	
	/**
	 * 
	 */
	protected Keks backen(){
		return (new Doppelkeks(this.vorlage, this.vorlage.clone() , fuellung));
	}

}
