/**
 * Eine Bestellung ist eine Liste von Positionen, die jeweils die Anzahl, Form,
 * Teigart und Fuelle (wenn Doppelkekse gewuenscht sind, sonst keine Fuelle)
 * angeben.
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Position {
	private int anzahl;
	private Form form;
	private Teigart teigart;
	private Fuellung fuellung;
	
	/**
	 * @param anzahl the anzahl to set
	 */
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((form == null) ? 0 : form.hashCode());
		result = prime * result + ((fuellung == null) ? 0 : fuellung.hashCode());
		result = prime * result + ((teigart == null) ? 0 : teigart.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		if (form != other.form) {
			return false;
		}
		if (fuellung != other.fuellung) {
			return false;
		}
		if (teigart != other.teigart) {
			return false;
		}
		return true;
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
	 * @return the number of cookies
	 */
	protected int getAnzahl() {
		return anzahl;
	}

	/**
	 * @return the form of the cookies
	 */
	protected Form getForm() {
		return form;
	}

	/**
	 * @return the teig of the cookies
	 */
	protected Teigart getTeigart() {
		return teigart;
	}

	/**
	 * @return the filling of the cookies
	 */
	protected Fuellung getFuellung() {
		return fuellung;
	}

	/**
	 * 
	 * @return returns true if the position is a double sided cookie; false
	 *         otherwise
	 */
	protected boolean isDoubleSidedCookie() {
		return fuellung != null;
	}

	/**
	 * 
	 * @return returns true if the position is a single sided cookie; false
	 *         otherwise
	 */
	protected boolean isSingleSidedCookie() {
		return fuellung == null;
	}

	/**
	 * toString-Method for fancy output
	 */
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();

		ret.append("Position: ");

		if (fuellung == null) {
			ret.append("Einfacher Keks - ");
			ret.append("Anzahl: " + anzahl + ", Form: " + form + ", Teigart: " + teigart);
		} else {
			ret.append("Doppelter Keks - ");
			ret.append("Anzahl: " + anzahl + ", Form: " + form + ", Teigart: " + teigart + ", Fuellung: " + fuellung);
		}

		return ret.toString();
	}
}
