@Creator()
public class Drillmaschine implements TraktorGeraet {
	private int anz;

	/**
	 * @param anz
	 */
	@Creator()
	public Drillmaschine(int anz) {
		if (anz > 0) {
			this.anz = anz;
		} else {
			anz = 0;
		}
	}

	@Creator()
	public Object getDetail() {
		return this.anz;
	}

	@Creator()
	public String toString() {
		return "Drillmaschine mit " + anz + " Saescharen";
	}

}
