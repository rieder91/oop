/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Keksbackmaschine extends Backmaschine{
	
	private Form f;
	
	/**
	 * 
	 * @param f
	 */
	protected Keksbackmaschine(Form f){
		this.f=f;
	}
	
	/**
	 * 
	 */
	protected Keks backen(Position p){
		return (new Keks(p.getTeigart(),f));
	}
}
