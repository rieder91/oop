/**
 * Es gibt Keksbackmaschinen, die nur Kekse mit einer bestimmten Form, aber mit unterschiedlichen Teigarten backen
 * koennen.
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Keksbackmaschine extends Backmaschine {
	
	private Form	form;
	private Teigart	teig;
	
	/**
	 * constructor which supplies the fixed form of the cookie
	 * 
	 * @param form
	 *            form of the cookie
	 */
	protected Keksbackmaschine(Form form) {
		this.form = form;
		this.teig = null;
	}
	
	/* only the teigart can be changed */
	
	@Override
	protected Keks backen() {
		if (this.teig != null) {
			return (new EinfacherKeks(this.teig, this.form));
		} else {
			return null;
		}
	}
	
	@Override
	protected void setDetail(Form f) {
		throw new RuntimeException("error: die Form einer einfachen Keksbackmaschine kann nicht geaendert werden");
	}
	
	@Override
	protected void setDetail(Fuellung f) {
		throw new RuntimeException("error: die Fuellung einer einfachen Keksbackmaschine kann nicht geaendert werden");
	}
	
	@Override
	protected void setDetail(Teigart t) {
		this.teig = t;
	}
}
