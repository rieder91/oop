/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class EinfacherKeks implements Keks{

	private Teigart teig;
	private Form form;
	
	/**
	 * 
	 * @param teig
	 * @param form
	 */
	protected EinfacherKeks(Teigart teig, Form form){
		this.teig = teig;
		this.form = form;
	}
	
	/**
	 * 
	 * @param keks
	 */
	protected EinfacherKeks(EinfacherKeks keks) {
		this.teig = keks.teig;
		this.form = keks.form;
	}
	
	/**
	 * 
	 */
	@Override
	protected EinfacherKeks clone() {
		return (new EinfacherKeks(this));
	}

	/**
	 * 
	 */
	@Override
	public String toString(){
		return "Form: " + form + ", Teigart: " + teig;
	}

	protected Teigart getTeig() {
		return teig;
	}

	protected Form getForm() {
		return form;
	}
}
