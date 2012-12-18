import java.util.ArrayList;
import java.util.Iterator;

/**
 * Kunden geben Bestellungen an die Baeckerei ab. Eine Bestellung ist eine Liste
 * von Positionen, die jeweils die Anzahl, Form, Teigart und Fuelle (wenn
 * Doppelkekse gewuenscht sind, sonst keine Fuelle) angeben. Als Ergebnis
 * erhaelt man eine Keksdose, die mit allen entsprechenden Keksen gefuellt ist.
 * 
 * @author OOP Gruppe 187
 * 
 */
//TODO gruppieren
public class Bestellung implements Iterable<Position> {

	private ArrayList<Position> positionen;

	/**
	 * constructor without args
	 */
	public Bestellung() {
		positionen = new ArrayList<Position>();
	}

	/**
	 * adds a new position to an order
	 * 
	 * @param p
	 *            new position
	 */
	public void addPosition(Position p) {
		positionen.add(p);

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((positionen == null) ? 0 : positionen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bestellung other = (Bestellung) obj;
		if (positionen == null) {
			if (other.positionen != null)
				return false;
		} else if (!positionen.equals(other.positionen))
			return false;
		return true;
	}

	/**
	 * returns an iterator to traverse the order
	 */
	@Override
	public Iterator<Position> iterator() {
		return this.positionen.iterator();
	}

	/**
	 * prints the order to sysout
	 */
	public void drucke() {
		System.out.println("Bestellung: ");
		for (Position p : this) {
			System.out.println(p);
		}
	}

}
