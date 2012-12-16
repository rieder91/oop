/**
 * Jedes Keks hat eine bestimmte Form (rund, in der Form eines Mondes und in der
 * Form eines Weihnachtsmannes) und besteht aus einer bestimmten Teigart
 * (Muerbteig, Zimtsternteig oder Schololadenteig).
 * 
 * Die Form und die Teigart eines Kekses laesst sich nicht aendern.
 * 
 * @author OOP Gruppe 187
 * 
 */
public class EinfacherKeks implements Keks{

	private Teigart teig;
	private Form form;
	
	/**
	 * constructor which creates a new cookie inside the factory
	 * @param teig teig of the cookie
	 * @param form form of the cookie
	 */
	protected EinfacherKeks(Teigart teig, Form form){
		this.teig = teig;
		this.form = form;
	}
	
	/**
	 * copy-constructor used for clone
	 * @param keks cookie that is copied
	 */
	private EinfacherKeks(EinfacherKeks keks) {
		this.teig = keks.teig;
		this.form = keks.form;
	}
	
	/**
	 * clones a cookie
	 */
	@Override
	protected EinfacherKeks clone() {
		return (new EinfacherKeks(this));
	}

	/**
	 * toString-Method for fancy output
	 */
	@Override
	public String toString(){
		return "Einfacher Keks - " + "Form: " + form + ", Teigart: " + teig;
	}
}
