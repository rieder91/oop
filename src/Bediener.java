
/**
 * alle Bediener muessen Software der Stufen 1 oder 2 verwenden
 * 
 * alle Bediener muessen Beruehrungssenstiven Skin verwenden
 * 
 * alle Bediener muessen ein Kit mit 1KW verwenden
 * 
 * @author OOP Gruppe 187
 *
 */
public abstract class Bediener extends Android {

	/**
	 * default constructor
	 * @param seriennummer serial of the android
	 */
	public Bediener(String seriennummer) {
		super(seriennummer);
	}
	
	protected void calledFromBeruehrungs(BeruehrungssensitiverSkin s) {
		super.installieren(s);
	}
	
	// Software die nicht einem Untertyp gehoert wird verboten
	protected void calledFromBauarbeiterSoftware(Software s) {}
	protected void calledFromKaempferSoftware(Software s) {}
	protected void calledFromLeibwaechterSoftware(Software s) {}
	protected void calledFromObjektbewacherSoftware(Software s) {}
	protected void calledFromServiceTechnikerSoftware(Software s) {}
	protected void calledFromTransportarbeiterSoftware(Software s) {}
	
	// Skin muss beruehrungssensitiv sein
	protected void calledFromGepanzert(GepanzerterSkin s) {}
	protected void calledFromHochfester(HochfesterSkin s) {}
	
	// Security Level muss 1 oder 2 sein
	protected void calledFromSoftwareLevel1(Software s) {
		super.installieren(s);
	}

	protected void calledFromSoftwareLevel2(Software s) {
		super.installieren(s);
	}
	
	protected void calledFromSoftwareLevel3(Software s) {}
	protected void calledFromSoftwareLevel4(Software s) {}
	protected void calledFromSoftwareLevel5(Software s) {}

	// es sind nur Aktoren mit <1KW erlaubt - wie bei ALLEN Androiden
	protected void calledFromLeistungUnbegrenzt(SensorenAktorenKit s) {}
	protected void calledFromLeistungFuenf(SensorenAktorenKit s) { }
	protected void calledFromLeistungZehn(SensorenAktorenKit s) { }
	
	// Aktoren haben nie eine Leistung beim Kit > 1KW
	protected void calledForLeistungFuenfWithLevel3(SensorenAktorenKit s) { }
	protected void calledForLeistungFuenfWithLevel4(SensorenAktorenKit s) { }
	protected void calledForLeistungZehnWithLevel4(SensorenAktorenKit s) { }
	
	protected Android replacedByBauarbeiter(Android android) { return null; }
	protected Android replacedByServiceTechniker(Android android) { return null; }
	protected Android replacedByTransportarbeiter(Android android) { return null;}
	protected Android replacedByKaempfer(Android android) { return null; }
	protected Android replacedByObjektbewacher(Android android) { return null; }
	protected Android replacedByLeibwaechter(Android android) { return null;}
	
	public abstract Android replaceRobotWith(Android android);
	
	
	protected Android replacedByHilfskraft(Android android) {
		return new Hilfskraft(android.getSeriennummer());
	}
	protected Android replacedByGesellschaftler(Android android) {
		return new Gesellschaftler(android.getSeriennummer());
	}
}