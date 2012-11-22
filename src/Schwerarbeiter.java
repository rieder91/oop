/**
 * 
 * nur Beschuetzer duerfen gepanzerten Skin verwenden
 * 
 * @author Thomas
 *
 */
public abstract class Schwerarbeiter extends Android{

	public Schwerarbeiter(String seriennummer) {
		super(seriennummer);
	}

	public void calledFromHochfester(HochfesterSkin s) {
		super.installieren(s);
	}

	public void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}
	
	protected void calledFromGepanzert(GepanzerterSkin s) {}
	
	// Schwerarbeiter k�nnen mit Software der Stufen 3 und 4 ausgestattet sein
	public  void calledFromSoftwareLevel3(Software s) {
		super.installieren(s);
	}
	
	public  void calledFromSoftwareLevel4(Software s) {
		super.installieren(s);
	}
	
	protected void calledFromGesellschaftlerSoftware(Software s) {}
	protected void calledFromHilfskraefteSoftware(Software s) {}
	protected void calledFromKaempferSoftware(Software s) {}
	protected void calledFromLeibwaechterSoftware(Software s) {}
	protected void calledFromObjektbewacherSoftware(Software s) {}
	
	protected void calledFromSoftwareLevel1(Software s) {}
	protected void calledFromSoftwareLevel2(Software s) {}
	protected void calledFromSoftwareLevel5(Software s) {}
	
	protected void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	
	public void calledFromLeistungFuenf(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungFuenf(this, s);
	}
	
	public void calledFromLeistungZehn(SensorenAktorenKit s) {
		this.getSoftware().getSecurityLevel().calledWithLeistungZehn(this, s);
	}
	
	protected void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s) {
		this.installieren(s);
	}
	
	protected void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s) {
		this.installieren(s);
	}
	
	protected void calledForLeistungZehnWithLevel4(SensorenAktorenKit s) {
		this.installieren(s);
	}
}