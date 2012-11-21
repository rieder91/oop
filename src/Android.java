

public abstract class Android {
	private String seriennummer;
	private Skin skin;
	private Software software;
	private SensorenAktorenKit kit;
	
	
	public Android(String seriennummer) {
		this.seriennummer = seriennummer;
		skin = null;
		software = null;
		kit = null;
	}
	
	protected String getSeriennummer() {
		return seriennummer;
	}
	
	
	public void integrate(Skin s) {
		skin = s;
	}
	
	public void integrate(Software s) {
		software = s;
	}
	
	public void integrate(SensorenAktorenKit s) {
		kit = s;
	}

	protected Skin getSkin() {
		return skin;
	}

	protected void setSkin(Skin skin) {
		this.skin = skin;
	}

	protected Software getSoftware() {
		return software;
	}

	protected void setSoftware(Software software) {
		this.software = software;
	}

	protected SensorenAktorenKit getKit() {
		return kit;
	}

	protected void setKit(SensorenAktorenKit kit) {
		this.kit = kit;
	}

	protected void setSeriennummer(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	
}
