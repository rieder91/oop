import java.util.ArrayList;
import java.util.Iterator;

/**
 * Kunden geben Bestellungen an die Baeckerei ab. Eine Bestellung ist eine Liste
 * von Positionen, die jeweils die Anzahl, Form, Teigart und Fuelle (wenn
 * Doppelkekse gewuenscht sind, sonst keine Fuelle) angeben. Als Ergebnis erhaelt
 * man eine Keksdose, die mit allen entsprechenden Keksen gefuellt ist.
 * 
 * @author OOP Gruppe 187
 * 
 */
public class Bestellung implements Iterable<Position> {

	private ArrayList<Position> positionen;
	private Keksdose kekse;
	
	/**
	 * constructor without args
	 */
	public Bestellung() {
		positionen = new ArrayList<Position>();
		kekse = new Keksdose();
	}

	/**
	 * adds a new position to an order
	 * @param p new position
	 */
	public void addPosition(Position p) {
		positionen.add(p);

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

	/**
	 * produces the cookies specified in the order; cookies are only baked once
	 * @return
	 */
	public Keksdose backe() {
		// wir backen nur, falls unsere Keksdose noch leer ist - wir wollen ja
		// nicht zwei mal das selbe backen!
		
		if (kekse.isEmpty()) {
			Backmaschine b = null;
			
			for (Position p : this) {
				b = createMachineBasedOnPosition(p);

				for (int i = 0; i < p.getAnzahl(); i++) {
					Keks newKeks = b.backen();
					if(newKeks != null) {
						this.kekse.addKeks(newKeks);
					}
				}
			}
		}
		return kekse;
	}
	
	/**
	 * creates a new cookie-machine based on the position
	 * 
	 * can be extended for new machines very easily
	 * 
	 * @param p position
	 * @return new cookie machine - the type depends on the type of cookie the position contains
	 */
	private Backmaschine createMachineBasedOnPosition(Position p) {
		Backmaschine b = null;
		if (p.isDoubleSidedCookie()) {
			b = new Doppelkeksbackmaschine(new EinfacherKeks(p.getTeigart(), p.getForm()));
			b.setDetail(p.getFuellung());
		} else if (p.isSingleSidedCookie()) {
			b = new Keksbackmaschine(p.getForm());
			b.setDetail(p.getTeigart());
		} 
		// can simply be extended with additional else-ifs...
		
		return b;
	}

}
