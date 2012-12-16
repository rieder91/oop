/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Keksbackmaschine extends Backmaschine{
	
	private Form form;
	private Teigart teig;
	
	/**
	 * 
	 * @param form
	 */
	protected Keksbackmaschine(Form form) {
		this.form = form;
		teig = null;
	}
	
	protected void setTeigart(Teigart teig) {
		this.teig = teig;
	}
	
	/**
	 * 
	 */
	protected EinfacherKeks backen(){
		return (new EinfacherKeks(teig, form));
	}
}
