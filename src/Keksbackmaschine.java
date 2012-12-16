/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Keksbackmaschine extends Backmaschine{
	
	private Form form;
	
	/**
	 * 
	 * @param form
	 */
	protected Keksbackmaschine(Form form) {
		this.form = form;
	}
	
	
	/**
	 * 
	 */
	protected EinfacherKeks backen(Position p){
		return (new EinfacherKeks(p.getTeigart(), form));
	}
}
