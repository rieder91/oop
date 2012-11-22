
/**
 * This class tests the implementation of Software
 * 
 * THIS CLASS IS FOR TESTING PURPOSES ONLY AND NOT PART OF THE 
 * ACTUAL SOLUTION FOR THE ASSIGNMENT - THAT IS WHY WE USED INSTANCEOF!
 * 
 * @author Thomas
 *
 */
public class SoftwareTester implements Tester {

	/**
	 * default constructor
	 */
	public SoftwareTester() { }

	@Override
	public void runTests() {
		// Bediener
		Android hilf = new Hilfskraft("Hilfroboter");
		Android gesell = new Gesellschaftler("Gesellschaftsroboter");

		// Schwerarbeiter
		Android bau = new Bauarbeiter("Bauroboter");
		Android service = new ServiceTechniker("Serviceroboter");
		Android transport = new Transportarbeiter("Transportroboter");

		// Beschuetzer
		Android kampf = new Kaempfer("Kampfroboter");
		Android leib = new Leibwaechter("Leibwaechteroboter");
		Android object = new Objektbewacher("Objektroboter");

		// alle Skins
		Skin bSkin = new BeruehrungssensitiverSkin();
		Skin hSkin = new HochfesterSkin();
		Skin gSkin = new GepanzerterSkin();

		// alle Security levels
		SecurityLevel level1 = new SecurityLevel1();
		SecurityLevel level2 = new SecurityLevel2();
		SecurityLevel level3 = new SecurityLevel3();
		SecurityLevel level4 = new SecurityLevel4();
		SecurityLevel level5 = new SecurityLevel5();


		// all possible software combos - for testing
		Software hilfS1 = new HilfskraefteSoftware(level1);
		Software hilfS2 = new HilfskraefteSoftware(level2);
		Software hilfS3 = new HilfskraefteSoftware(level3);
		Software hilfS4 = new HilfskraefteSoftware(level4);
		Software hilfS5 = new HilfskraefteSoftware(level5);

		Software gesellS1 = new GesellschaftlerSoftware(level1);
		Software gesellS2 = new GesellschaftlerSoftware(level2);
		Software gesellS3 = new GesellschaftlerSoftware(level3);
		Software gesellS4 = new GesellschaftlerSoftware(level4);
		Software gesellS5 = new GesellschaftlerSoftware(level5);


		Software bauS1 = new BauarbeiterSoftware(level1);
		Software bauS2 = new BauarbeiterSoftware(level2);
		Software bauS3 = new BauarbeiterSoftware(level3);
		Software bauS4 = new BauarbeiterSoftware(level4);
		Software bauS5 = new BauarbeiterSoftware(level5);

		Software serviceS1 = new ServiceTechnikerSoftware(level1);
		Software serviceS2 = new ServiceTechnikerSoftware(level2);
		Software serviceS3 = new ServiceTechnikerSoftware(level3);
		Software serviceS4 = new ServiceTechnikerSoftware(level4);
		Software serviceS5 = new ServiceTechnikerSoftware(level5);

		Software transportS1 = new TransportarbeiterSoftware(level1);
		Software transportS2 = new TransportarbeiterSoftware(level2);
		Software transportS3 = new TransportarbeiterSoftware(level3);
		Software transportS4 = new TransportarbeiterSoftware(level4);
		Software transportS5 = new TransportarbeiterSoftware(level5);


		Software kampfS1 = new KaempferSoftware(level1);
		Software kampfS2 = new KaempferSoftware(level2);
		Software kampfS3 = new KaempferSoftware(level3);
		Software kampfS4 = new KaempferSoftware(level4);
		Software kampfS5 = new KaempferSoftware(level5);

		Software leibS1 = new LeibwaechterSoftware(level1);
		Software leibS2 = new LeibwaechterSoftware(level2);
		Software leibS3 = new LeibwaechterSoftware(level3);
		Software leibS4 = new LeibwaechterSoftware(level4);
		Software leibS5 = new LeibwaechterSoftware(level5);

		Software objectS1 = new ObjektbewacherSoftware(level1);
		Software objectS2 = new ObjektbewacherSoftware(level2);
		Software objectS3 = new ObjektbewacherSoftware(level3);
		Software objectS4 = new ObjektbewacherSoftware(level4);
		Software objectS5 = new ObjektbewacherSoftware(level5);

		
		hilf.softwareInstallieren(gesellS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Gesellschaflersoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(bauS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Bausoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(serviceS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Servicesoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(transportS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Transportsoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(kampfS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Kampfsoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(leibS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Leibwaechtersoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf.softwareInstallieren(objectS1);
		Validator.report(hilf.getSoftware() == null, "versuchen Objektbewachersoftware(1) in einem Hilfsroboter zu installieren");

		hilf.softwareInstallieren(hilfS1);
		Validator.report(hilf.getSoftware() instanceof HilfskraefteSoftware, "versuchen Hilfssoftware(1) in einem Hilfsroboter zu installieren");
		
		hilf = new Hilfskraft("Hilfsroboter");
		hilf.softwareInstallieren(hilfS2);
		Validator.report(hilf.getSoftware() instanceof HilfskraefteSoftware, "versuchen Hilfssoftware(2) in einem Hilfsroboter zu installieren");
		
		hilf = new Hilfskraft("Hilfsroboter");
		hilf.softwareInstallieren(hilfS3);
		Validator.report(hilf.getSoftware() == null, "versuchen Hilfssoftware(3) in einem Hilfsroboter zu installieren");
		
		hilf = new Hilfskraft("Hilfsroboter");
		hilf.softwareInstallieren(hilfS4);
		Validator.report(hilf.getSoftware() == null, "versuchen Hilfssoftware(4) in einem Hilfsroboter zu installieren");
		
		hilf = new Hilfskraft("Hilfsroboter");
		hilf.softwareInstallieren(hilfS5);
		Validator.report(hilf.getSoftware() == null, "versuchen Hilfssoftware(5) in einem Hilfsroboter zu installieren");
		
	}

}
