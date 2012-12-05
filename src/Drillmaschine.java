

public class Drillmaschine implements TraktorGeraet {
	private int anz;

	/**
	 * @param anz
	 */
	//TODO sanity check
	public Drillmaschine(int anz) {
		this.anz = anz;
	}

	public int getDetail() {
		return this.anz;
	}
	
	
}
