/**
 * Weiters gibt es eine Backmaschine für Doppelkekse. Diese Maschine wird mit
 * einem Keks beladen, erkennt automatisch die Teigart und Form dieses Kekses,
 * baeckt ein aequivalentes Keks und erzeugt daraus ein Doppelkeks, das mit einer
 * bestimmten Fuellung gefüllt ist.
 * 
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Doppelkeksbackmaschine extends Backmaschine {

	private EinfacherKeks vorlage;
	private Fuellung fuellung;
	
	/**
	 * create a new machine with a template-cookie used for the front and back
	 * @param vorlage template cookie
	 */
	protected Doppelkeksbackmaschine(EinfacherKeks vorlage) {
		this.vorlage = vorlage;
		this.fuellung = null;
	}
	
	
	/* only the filling can be changed */
	
	@Override
	protected void setDetail(Fuellung fuellung) {
		this.fuellung = fuellung;
	}

	@Override
	protected void setDetail(Teigart t) {
		throw new RuntimeException("error: die Teigart einer Doppelkeksbackmaschine kann nicht geaendert werden");
	}

	@Override
	protected void setDetail(Form f) { 
		throw new RuntimeException("error: die Form einer Doppelkeksbackmaschine kann nicht geaendert werden");
	}
	
	@Override
	protected Keks backen(){
		if(fuellung != null) {
			return (new Doppelkeks(this.vorlage, this.vorlage.clone() , this.fuellung));
		} else {
			return null;
		}
	}
}
