
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
		
		
		Hilfskraft sonnic;
		sonnic = new Hilfskraft("R2-D2");
		
		Hilfskraft sonnic2;
		sonnic2 = new Hilfskraft("R4-D2");
		
		Hilfskraft sonnic3;
		sonnic3 = new Hilfskraft("R6-D2");
		
		Hilfskraft sonnic4;
		sonnic4 = new Hilfskraft("R8-D2");
		
		Kaempfer warrior;
		warrior = new Kaempfer("Obi-Wan");
		
		
		BeruehrungssensitiverSkin bSkin = new BeruehrungssensitiverSkin();
		HochfesterSkin hSkin = new HochfesterSkin();
		GepanzerterSkin gSkin = new GepanzerterSkin();
		
		// different kit-types
		SensorenAktorenKitInf ultraLegs = new SensorenAktorenKitInf();
		SensorenAktorenKitEinKW miniLegs = new SensorenAktorenKitEinKW();
		SensorenAktorenKitFuenfKW mediumLegs = new SensorenAktorenKitFuenfKW();
		SensorenAktorenKitZehnKW largeLegs = new SensorenAktorenKitZehnKW();
		
		bSkin.integrate(sonnic);
		bSkin.integrate(sonnic2);
		
		sonnic3.skinEinbauen(hSkin);
		sonnic4.skinEinbauen(gSkin);
		
		HilfskraefteSoftware winWord = new HilfskraefteSoftware(new SecurityLevel1());
		KaempferSoftware excel = new KaempferSoftware(new SecurityLevel5());
		BauarbeiterSoftware powerPoint3 = new BauarbeiterSoftware(new SecurityLevel3());
		BauarbeiterSoftware powerPoint4 = new BauarbeiterSoftware(new SecurityLevel4());
		
		sonnic2.softwareInstallieren(excel);
		sonnic2.softwareInstallieren(winWord);
		warrior.softwareInstallieren(excel);
		
		Bauarbeiter bob = new Bauarbeiter("Bob");
		Bauarbeiter alice = new Bauarbeiter("Alice");
		bob.softwareInstallieren(powerPoint3);
		alice.softwareInstallieren(powerPoint4);
		
		bob.kitInstallieren(largeLegs);
		alice.kitInstallieren(mediumLegs);
		
		
		warrior.kitInstallieren(miniLegs);
		sonnic3.kitInstallieren(mediumLegs);
		
		
		
		
		
		System.out.println(alice);
		
	}
}
