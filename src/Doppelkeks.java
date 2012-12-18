/**
 * Neben einfachen Keksen gibt es Doppelkekse, die aus zwei einfachen Keksen und
 * einer Fuellung (Schokolade oder Marmelade) bestehen.
 * 
 * Laut Angabe es ist NICHT vorrausgesetzt, dass die Ober- und Unterseite aus
 * der selben Form und Teigart sind!
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Doppelkeks implements Keks {

	private Fuellung fuellung;
	private EinfacherKeks oberSeite;
	private EinfacherKeks unterSeite;

	/**
	 * creates a new doppelkeks based on the upside-cookie, downside-cookie and
	 * the filling
	 * 
	 * @param k1
	 *            upside cookie
	 * @param k2
	 *            downside cookie
	 * @param fu
	 *            filling
	 */
	protected Doppelkeks(EinfacherKeks k1, EinfacherKeks k2, Fuellung fu) {
		this.oberSeite = k1;
		this.unterSeite = k2;
		this.fuellung = fu;
	}

	/**
	 * copy constructor for a cookie
	 * 
	 * @param dk
	 *            other cookie
	 */
	private Doppelkeks(Doppelkeks dk) {
		this.oberSeite = dk.oberSeite.clone();
		this.unterSeite = dk.unterSeite.clone();
		this.fuellung = dk.fuellung;
	}

	/**
	 * clones a cookie
	 */
	@Override
	protected Doppelkeks clone() {
		return (new Doppelkeks(this));

	}

	/**
	 * toString-Method for fancy output
	 */
	@Override
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("Doppelter Keks:\n");
		ret.append("\tOberseite:\t" + oberSeite + "\n");
		ret.append("\tUnterseite:\t" + unterSeite + "\n");
		ret.append("\tFuellung:\t" + fuellung);

		return ret.toString();
	}

}
