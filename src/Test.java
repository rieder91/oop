import java.util.ArrayList;


/**
 * Test class for Assignment 6
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 6
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		System.out
				.println("Objektorientierte Programmiertechniken                  \n"
						+ "Datum: 21.11.2012                                      \n"
						+ "Aufgabe 6                                              \n"
						+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		
		
		ArrayList<Tester> tests = new ArrayList<Tester>();
		tests.add(new SkinTester());
		
		
		for(Tester t : tests) {
			t.runTests();
		}
		
		Validator.enableDebug();
		Validator.printOverview();
		
		
		
		// Bediener
		Hilfskraft hilf = new Hilfskraft("Hilfroboter");
		Gesellschaftler gesell = new Gesellschaftler("Gesellschaftsroboter");
		
		// Schwerarbeiter
		Bauarbeiter bau = new Bauarbeiter("Bauroboter");
		ServiceTechniker service = new ServiceTechniker("Serviceroboter");
		Transportarbeiter transport = new Transportarbeiter("Transportroboter");
		
		// Beschuetzer
		Kaempfer kampf = new Kaempfer("Kampfroboter");
		Leibwaechter leib = new Leibwaechter("Leibwaechteroboter");
		Objektbewacher object = new Objektbewacher("Objektroboter");
		
		// alle Skins
		BeruehrungssensitiverSkin bSkin = new BeruehrungssensitiverSkin();
		HochfesterSkin hSkin = new HochfesterSkin();
		GepanzerterSkin gSkin = new GepanzerterSkin();
		
		// alle Security levels
		SecurityLevel1 level1 = new SecurityLevel1();
		SecurityLevel2 level2 = new SecurityLevel2();
		SecurityLevel3 level3 = new SecurityLevel3();
		SecurityLevel4 level4 = new SecurityLevel4();
		SecurityLevel5 level5 = new SecurityLevel5();
		
		
		// all possible software combos - for testing
		HilfskraefteSoftware hilfS1 = new HilfskraefteSoftware(level1);
		HilfskraefteSoftware hilfS2 = new HilfskraefteSoftware(level2);
		HilfskraefteSoftware hilfS3 = new HilfskraefteSoftware(level3);
		HilfskraefteSoftware hilfS4 = new HilfskraefteSoftware(level4);
		HilfskraefteSoftware hilfS5 = new HilfskraefteSoftware(level5);
		
		GesellschaftlerSoftware gesellS1 = new GesellschaftlerSoftware(level1);
		GesellschaftlerSoftware gesellS2 = new GesellschaftlerSoftware(level2);
		GesellschaftlerSoftware gesellS3 = new GesellschaftlerSoftware(level3);
		GesellschaftlerSoftware gesellS4 = new GesellschaftlerSoftware(level4);
		GesellschaftlerSoftware gesellS5 = new GesellschaftlerSoftware(level5);
		
		BauarbeiterSoftware bauS1 = new BauarbeiterSoftware(level1);
		BauarbeiterSoftware bauS2 = new BauarbeiterSoftware(level2);
		BauarbeiterSoftware bauS3 = new BauarbeiterSoftware(level3);
		BauarbeiterSoftware bauS4 = new BauarbeiterSoftware(level4);
		BauarbeiterSoftware bauS5 = new BauarbeiterSoftware(level5);
		
		// all kit-types
		SensorenAktorenKitInf sensorenInf = new SensorenAktorenKitInf();
		SensorenAktorenKitEinKW sensorenEins = new SensorenAktorenKitEinKW();
		SensorenAktorenKitFuenfKW sensorenFuenf = new SensorenAktorenKitFuenfKW();
		SensorenAktorenKitZehnKW sensorenZehn = new SensorenAktorenKitZehnKW();
		


		
		hilf.skinEinbauen(bSkin);
		hilf.softwareInstallieren(hilfS2);
		
//		bSkin.einbauen(hilf);
//		hilfS1.installiertIn(hilf);
		
		
		
		
		
		
	}
}
