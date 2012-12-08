
public class Drillmaschine implements TraktorGeraet {
	private int anz;

	/**
	 * @param anz
	 */
	public Drillmaschine(int anz) {
		if (anz > 0) {
			this.anz = anz;
		} else {
			anz = 0;
		}
	}

	public Object getDetail() {
		return this.anz;
	}

	public String toString() {
		return "Drillmaschine mit " + anz + " Saescharen";
	}

}
