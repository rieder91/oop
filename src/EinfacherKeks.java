/**
 * Jedes Keks hat eine bestimmte Form (rund, in der Form eines Mondes und in der Form eines Weihnachtsmannes) und
 * besteht aus einer bestimmten Teigart (Muerbteig, Zimtsternteig oder Schololadenteig).
 * 
 * Die Form und die Teigart eines Kekses laesst sich nicht aendern.
 * 
 * @author OOP Gruppe 187
 * 
 */
public class EinfacherKeks implements Keks {
	
	private Teigart	teig;
	private Form	form;
	
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
	 * clones a cookie
	 */
	@Override
	protected EinfacherKeks clone() {
		return (new EinfacherKeks(this));
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
		if (this.form != other.form) {
			return false;
		}
		if (this.teig != other.teig) {
			return false;
		}
		return true;
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
		result = (prime * result) + ((this.teig == null) ? 0 : this.teig.hashCode());
		return result;
	}
	
	/**
	 * toString-Method for fancy output
	 */
	@Override
	public String toString() {
		return "Einfacher Keks - " + "Form: " + this.form + ", Teigart: " + this.teig;
	}
}
