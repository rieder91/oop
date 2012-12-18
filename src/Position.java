/**
 * Eine Bestellung ist eine Liste von Positionen, die jeweils die Anzahl, Form, Teigart und Fuelle (wenn Doppelkekse
 * gewuenscht sind, sonst keine Fuelle) angeben.
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Position {
	
	private int	     anzahl;
	private Form	 form;
	private Teigart	 teigart;
	private Fuellung	fuellung;
	
	/**
	 * constructor for a single sided cookie
	 * 
	 * @param anzahl
	 *            number of cookies
	 * @param form
	 *            form of the cookies
	 * @param teigart
	 *            teig used in the cookies
	 */
	public Position(int anzahl, Form form, Teigart teigart) {
		this(anzahl, form, teigart, null);
	}
	
	/**
	 * constructor for a double sided cookie
	 * 
	 * @param anzahl
	 *            number of cookies
	 * @param form
	 *            form of the cookies
	 * @param teigart
	 *            teig used in the cookies
	 * @param fuellung
	 *            the filling of the cookies
	 */
	public Position(int anzahl, Form form, Teigart teigart, Fuellung fuellung) {
		this.anzahl = anzahl;
		this.form = form;
		this.teigart = teigart;
		this.fuellung = fuellung;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Position)) {
			return false;
		}
		Position other = (Position) obj;
		if (this.form != other.form) {
			return false;
		}
		if (this.fuellung != other.fuellung) {
			return false;
		}
		if (this.teigart != other.teigart) {
			return false;
		}
		return true;
	}
	
	/**
	 * @return the number of cookies
	 */
	protected int getAnzahl() {
		return this.anzahl;
	}
	
	/**
	 * @return the form of the cookies
	 */
	protected Form getForm() {
		return this.form;
	}
	
	/**
	 * @return the filling of the cookies
	 */
	protected Fuellung getFuellung() {
		return this.fuellung;
	}
	
	/**
	 * @return the teig of the cookies
	 */
	protected Teigart getTeigart() {
		return this.teigart;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.form == null) ? 0 : this.form.hashCode());
		result = (prime * result) + ((this.fuellung == null) ? 0 : this.fuellung.hashCode());
		result = (prime * result) + ((this.teigart == null) ? 0 : this.teigart.hashCode());
		return result;
	}
	
	/**
	 * 
	 * @return returns true if the position is a double sided cookie; false otherwise
	 */
	protected boolean isDoubleSidedCookie() {
		return this.fuellung != null;
	}
	
	/**
	 * 
	 * @return returns true if the position is a single sided cookie; false otherwise
	 */
	protected boolean isSingleSidedCookie() {
		return this.fuellung == null;
	}
	
	/**
	 * @param anzahl
	 *            the anzahl to set
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	
	/**
	 * toString-Method for fancy output
	 */
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		
		ret.append("Position: ");
		
		if (this.fuellung == null) {
			ret.append("Einfacher Keks - ");
			ret.append("Anzahl: " + this.anzahl + ", Form: " + this.form + ", Teigart: " + this.teigart);
		} else {
			ret.append("Doppelter Keks - ");
			ret.append("Anzahl: " + this.anzahl + ", Form: " + this.form + ", Teigart: " + this.teigart
			        + ", Fuellung: " + this.fuellung);
		}
		
		return ret.toString();
	}
}
