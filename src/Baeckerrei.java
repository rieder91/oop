import java.util.ArrayList;
import java.util.Hashtable;

public class Baeckerrei {

	private ArrayList<Bestellung> bestellungen = new ArrayList<Bestellung>();
	private ArrayList<Keksdose> keksdosen = new ArrayList<Keksdose>();
	private Hashtable<Form, Keksbackmaschine> einfachkeksmasch = new Hashtable<Form, Keksbackmaschine>();
	private Hashtable<EinfacherKeks, Doppelkeksbackmaschine> doppelkeksmasch = new Hashtable<EinfacherKeks, Doppelkeksbackmaschine>();

	/**
	 * produces the cookies specified in the order; cookies are only baked once
	 * 
	 * @return
	 */
	public Keksdose backe(Bestellung best) {
		if (!bestellungen.contains(best)) {
			this.bestellungen.add(best);
			Backmaschine b = null;
			Keksdose kdose = new Keksdose();

			for (Position p : best) {
				b = createMachineBasedOnPosition(p);
				for (int i = 0; i < p.getAnzahl(); i++) {
					Keks newKeks = b.backen();
					if (newKeks != null) {
						kdose.addKeks(newKeks);
					}
				}
			}
			this.keksdosen.add(kdose);
			return kdose;
		} else {
			return keksdosen.get(this.bestellungen.indexOf(best));
		}

	}

	/**
	 * creates a new cookie-machine based on the position
	 * 
	 * can be extended for new machines very easily
	 * 
	 * @param p
	 *            position
	 * @return new cookie machine - the type depends on the type of cookie the
	 *         position contains
	 */
	private Backmaschine createMachineBasedOnPosition(Position p) {
		Backmaschine b = null;
		if (p.isDoubleSidedCookie()) {
			EinfacherKeks template = new EinfacherKeks(p.getTeigart(), p.getForm());
			if (doppelkeksmasch.containsKey(new EinfacherKeks(p.getTeigart(), p.getForm()))) {
				b = doppelkeksmasch.get(template);
				b.setDetail(p.getFuellung());

			} else {
				b = new Doppelkeksbackmaschine(new EinfacherKeks(p.getTeigart(), p.getForm()));
				b.setDetail(p.getFuellung());
			}

		} else if (p.isSingleSidedCookie()) {
			if (einfachkeksmasch.containsKey(p.getForm())) {
				b = einfachkeksmasch.get(p.getForm());
				b.setDetail(p.getTeigart());

			} else {
				b = new Keksbackmaschine(p.getForm());
				b.setDetail(p.getTeigart());
			}
		}
		// can simply be extended with additional else-ifs...

		return b;
	}
}
