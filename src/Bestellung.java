import java.util.ArrayList;
import java.util.Iterator;

/**
 * 
 * @author OOP Gruppe 187
 *
 */
public class Bestellung implements Iterable<Position> {

	private ArrayList<Position> positionen = new ArrayList<Position>();
	private Keksdose kekse = new Keksdose();

	/**
	 * 
	 * @param p
	 */
	public void addPosition(Position p) {
		positionen.add(p);

	}

	/**
	 * 
	 */
	@Override
	public Iterator<Position> iterator() {
		return this.positionen.iterator();
	}

	/**
	 * 
	 */
	public void drucke() {
		for (Position p : this) {
			System.out.println(p);
		}
	}

	/**
	 * 
	 * @return
	 */
	public Keksdose backe() {

		for (Position p : this) {
			Backmaschine b;
			
			if (p.isDoubleSidedCookie()) {
				b = new Doppelkeksbackmaschine(new EinfacherKeks(p.getTeigart(), p.getForm()));
			} else {
				b = new Keksbackmaschine(p.getForm());
			}

			for (int i = 0; i < p.getAnzahl(); i++) {
				this.kekse.addKeks(b.backen(p));
			}
		}

		return kekse;

	}

}
