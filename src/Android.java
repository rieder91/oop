/**
 * Jeder Androide muss mit einer berührungssensitiven, hochfesten oder
 * gepanzerten Skin ausgestattet sein.
 * 
 * 
 * Die Software muss dem Einsatzgebiet des Androiden entsprechen. Die Software
 * muss entsprechend der Sicherheitsstufen 1 bis 5 zertifiziert sein.
 * 
 * Nachträgliche Änderungen der Androiden sind nur auf eingeschränkte Weise
 * erlaubt: Die Seriennummer, der Haupttyp (Bediener, Schwerarbeiter oder
 * Beschützer) sowie die Sicherheitsstufe der Software dürfen nicht geändert
 * werden.
 * 
 * Bei allen Androiden, die mit Software der Stufe 3 ausgestattet sind, darf die
 * Grenze von 5 kW nicht überschritten werden, bei Androiden mit Software der
 * Stufe 4 die Grenze von 10 kW.
 * 
 * Alle Androiden duerfen Aktoren mit 1KW verwenden.
 * 
 * @author Thomas
 * 
 */
public abstract class Android {
	private final String seriennummer;
	private Skin skin;
	private Software software;
	private SensorenAktorenKit kit;

	/**
	 * default constructor
	 * @param seriennummer serial of the robot
	 */
	public Android(String seriennummer) {
		this.seriennummer = seriennummer;
		skin = null;
		software = null;
		kit = null;
	}

	/**
	 * returns the serial of the robot
	 * @return serial of the robot
	 */
	protected String getSeriennummer() {
		return seriennummer;
	}
	
	/**
	 * getter needed to verify the security level when adding a new kit
	 * @return software that is deployed
	 */
	protected Software getSoftware() {
		return software;
	}

	/**
	 * installs a new skin; should never be called directly but via installSkin() 
	 * @param s new skin
	 */
	protected void installieren(Skin s) {
		skin = s;
	}

	/**
	 * installs a new software; should never be called directly but via installSoftware() 
	 * @param s new software
	 */
	protected void installieren(Software s) {
		software = s;
	}

	/**
	 * installs a new kit; should never be called directly but via installKit() 
	 * @param s new kit
	 */
	protected void installieren(SensorenAktorenKit s) {
		kit = s;
	}

	/*********************/
	
	/**
	 * installs a new skin, if it is valid for the current android	
	 * @param s skin to be installed
	 */
	public void installSkin(Skin s) {
		s.einbauen(this);
	}
	
	// used for multimethods simulation
	protected abstract void calledFromGepanzert(GepanzerterSkin s);
	protected abstract void calledFromHochfester(HochfesterSkin s);
	protected abstract void calledFromBeruehrungs(BeruehrungssensitiverSkin s);
	
	/*****************/
	
	/**
	 * installs the software s if it is valid for the current android
	 * @param s software to be installed
	 */
	public void installSoftware(Software s) {
		s.installiertIn(this);
	}
	
	// used for multimethods simulation
	protected abstract void calledFromBauarbeiterSoftware(Software s);
	protected abstract void calledFromGesellschaftlerSoftware(Software s);
	protected abstract void calledFromHilfskraefteSoftware(Software s);
	protected abstract void calledFromKaempferSoftware(Software s);
	protected abstract void calledFromLeibwaechterSoftware(Software s);
	protected abstract void calledFromObjektbewacherSoftware(Software s);
	protected abstract void calledFromServiceTechnikerSoftware(Software s);
	protected abstract void calledFromTransportarbeiterSoftware(Software s);
	
	// used for multimethods simulation
	protected abstract void calledFromSoftwareLevel1(Software s);
	protected abstract void calledFromSoftwareLevel2(Software s);
	protected abstract void calledFromSoftwareLevel3(Software s);
	protected abstract void calledFromSoftwareLevel4(Software s);
	protected abstract void calledFromSoftwareLevel5(Software s);

	/*****************/
	
	public void installKit(SensorenAktorenKit s) {
		s.integrieren(this);
	}
	
	protected void calledFromLeistungEins(SensorenAktorenKit s) {
		installieren(s);
	}
	
	// used for multimethods simulation
	protected abstract void calledFromLeistungFuenf(SensorenAktorenKit s);
	protected abstract void calledFromLeistungZehn(SensorenAktorenKit s);
	protected abstract void calledFromLeistungUnbegrenzt(SensorenAktorenKit s);
	
	// used for multimethods simulation
	protected abstract void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s);
	protected abstract void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s);
	protected abstract void calledForLeistungZehnWithLevel4(SensorenAktorenKit s);
	
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		ret.append("\nSerial: " + seriennummer);
		ret.append("\nSoftware: " + software);
		ret.append("\tSoftware-Level: " + software.getSecurityLevel());
		ret.append("\nSkin: " + skin);
		ret.append("\nKit: " + kit + "\n");
		return ret.toString();
	}
	
	
	/* USED FOR EASIER DEBUGGING ONLY!!! */
	
	protected void dismantleKit() {
		this.kit = null;
	}
	
	protected void wipeSoftware() {
		this.software = null;
	}
	
	protected void smashSkin() {
		this.skin = null;
	}
	

	protected Skin getSkin() {
		return skin;
	}

	protected SensorenAktorenKit getKit() {
		return kit;
	}
	
	/* USED FOR EASIER DEBUGGING ONLY!!! */

}