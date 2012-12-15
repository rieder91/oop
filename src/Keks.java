/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Keks {

	private Teigart teig;
	private Form form;
	
	/**
	 * 
	 * @param t
	 * @param f
	 */
	protected Keks(Teigart t, Form f){
		this.teig=t;
		this.form=f;
	}
	
	/**
	 * 
	 * @param k
	 */
	protected Keks(Keks k){
		this.teig=k.teig;
		this.form=k.form;
	}
	
	/**
	 * 
	 */
	@Override
	protected Keks clone(){
		return (new Keks(this));
		
	}

	/**
	 * 
	 */
	@Override
	public String toString(){
		return "Teigart: " + teig + " Form: " + form;
		
	}
}
