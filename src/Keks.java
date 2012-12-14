
public class Keks {

	private Teigart teig;
	private Form form;
	
	public Keks(Teigart t, Form f){
		this.teig=t;
		this.form=f;
	}
	
	protected Keks(Keks k){
		
	}
	
	public Keks clone(){
		return (new Keks(this));
		
	}
	
	protected Form getForm(){
		return this.form;
	}
	
	protected Teigart getTeigart(){
		return this.teig;
	}
}
