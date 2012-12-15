/**
 * 
 * @author OOP Gruppe 187
 *
 */
public abstract class Backmaschine {

	/**
	 * 
	 * @param p
	 * @return
	 */
	protected static Backmaschine getBackmaschine(Position p) {
		if (p.getFuellung() == null) {
			return (new Keksbackmaschine(p.getForm()));
		} else {
			return (new Doppelkeksbackmaschine((new Keksbackmaschine(
					p.getForm()).backen(p))));
		}
	}
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	protected abstract Keks backen(Position p);
}
