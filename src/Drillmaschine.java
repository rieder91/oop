

public class Drillmaschine implements TraktorGeraet {
	private Integer anz;

	/**
	 * @param anz
	 */
	//TODO sanity check
	public Drillmaschine(int anz) {
		this.anz = anz;
	}

	@Override
	public Object getDetail() {
		return this.anz;
	}
	
	
}
