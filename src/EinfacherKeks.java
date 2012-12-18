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
public class EinfacherKeks implements Keks {


	private Teigart teig;
	private Form form;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((form == null) ? 0 : form.hashCode());
		result = prime * result + ((teig == null) ? 0 : teig.hashCode());
		return result;
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
		if (!(obj instanceof EinfacherKeks)) {
			return false;
		}
		EinfacherKeks other = (EinfacherKeks) obj;
		if (form != other.form) {
			return false;
		}
		if (teig != other.teig) {
			return false;
		}
		return true;
	}


	/**
	 * constructor which creates a new cookie inside the factory
	 * 
	 * @param teig
	 *            teig of the cookie
	 * @param form
	 *            form of the cookie
	 */
	protected EinfacherKeks(Teigart teig, Form form) {
		this.teig = teig;
		this.form = form;
	}

	/**
	 * copy-constructor used for clone
	 * 
	 * @param keks
	 *            cookie that is copied
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
	public String toString() {
		return "Einfacher Keks - " + "Form: " + form + ", Teigart: " + teig;
	}
}
