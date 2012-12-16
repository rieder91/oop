/**
 * abstract class which all cookie-factories extend
 * 
 * 
 * the class is meant to be used like this:
 * 
 * the setDetails methods are implemented by each cookie-machine and specify
 * which parameters of the cookie-machine can be changed
 * 
 * 
 * example: our Single-sided-cookie-machine has a fixed form and a changeable
 * teig - if we wanted to add a new machine where both can be changed, we only
 * need to implement the setDetail-method for both teig and form
 * 
 * 
 * if a new cookie detail like the coating were to be introduced we only need to
 * implement a new setDetail method with the coating as a parameter
 * 
 * 
 * 
 * the backen-method then creates a new cookie IF all the necessary data needed
 * by a specific machine are available
 * 
 * 
 * @author OOP Gruppe 187
 * 
 * 
 */
public abstract class Backmaschine {

	/**
	 * sets the fuellung used in the new cookie (if it applies to the specific machine)
	 * @param f new fuellung
	 */
	protected abstract void setDetail(Fuellung f);
	
	/**
	 * sets the Teig used in the new cookie (if it applies to the specific machine)
	 * @param t new teigart
	 */
	protected abstract void setDetail(Teigart t);
	
	/**
	 * sets the form of the new cookie (if it applies to the specific machine)
	 * @param f new form
	 */
	protected abstract void setDetail(Form f);
	
	/**
	 * creates a new cookie if the maschine has all the necessary data; return
	 * null otherwise
	 * 
	 * @return new cookie
	 */
	protected abstract Keks backen();
}
