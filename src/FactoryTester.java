import java.util.ArrayList;


/**
 * This class tests the implementation of the Droid-Factory
 * 
 * THIS CLASS IS FOR TESTING PURPOSES ONLY AND NOT PART OF THE 
 * ACTUAL SOLUTION FOR THE ASSIGNMENT - THAT IS WHY WE USED GETCLASS!
 * 
 * @author Thomas
 *
 */
public class FactoryTester implements Tester {

	/**
	 * default constructor
	 */
	public FactoryTester() { }

	public void runTests() {
		AndroidFactory factory = new AndroidFactory();
		
		// all security levels
		SecurityLevel level1 = new SecurityLevel1();
		SecurityLevel level2 = new SecurityLevel2(); 
		SecurityLevel level3 = new SecurityLevel3(); 
		SecurityLevel level4 = new SecurityLevel4(); 
		SecurityLevel level5 = new SecurityLevel5(); 
		
		Android hilf = new Hilfskraft("R2-D2");
		Android gesell = new Gesellschaftler("R4");
		Android kampf = new Kaempfer("Sonnic");
		Android bau = new Bauarbeiter("Bob");
		Android leib = new Leibwaechter("Megatron");
		
		
		SensorenAktorenKit kit1 = new SensorenAktorenKitEinKW();
		SensorenAktorenKit kit5 = new SensorenAktorenKitFuenfKW();
		SensorenAktorenKit kit10 = new SensorenAktorenKitZehnKW();
		SensorenAktorenKit kitMax = new SensorenAktorenKitInf();
		
		Skin bSkin = new BeruehrungssensitiverSkin();
		Skin gSkin = new GepanzerterSkin();
		Skin hSkin = new HochfesterSkin();
		
		Software hSoft1 = new HilfskraefteSoftware(level1);
		Software hSoft2 = new HilfskraefteSoftware(level2);
		Software hSoft3 = new HilfskraefteSoftware(level3);
		
		Software gSoft1 = new GesellschaftlerSoftware(level1);
		
		Software kSoft4 = new KaempferSoftware(level4);
		Software kSoft5 = new KaempferSoftware(level5);
		
		Software bSoft3 = new BauarbeiterSoftware(level3);
		Software bSoft4 = new BauarbeiterSoftware(level4);
		
		Software lSoft4 = new LeibwaechterSoftware(level4);
		Software lSoft5 = new LeibwaechterSoftware(level5);

		System.out.println("\nAdd 5 valid robots...\n");
		
		factory.insert(hilf, bSkin, hSoft2, kit1);
		factory.insert(gesell, bSkin, gSoft1, kit1);
		factory.insert(kampf, gSkin, kSoft5, kitMax);
		factory.insert(bau, hSkin, bSoft4, kit10);
		factory.insert(leib, hSkin, lSoft4, kit5);
		
		ArrayList<String> order1 = new ArrayList<String>();
		
		for(Android an : factory) {
			System.out.println(an.toString());
			order1.add(an.toString().substring(an.toString().indexOf("Serial:"), an.toString().indexOf("Software") - 1));
		}
		
		System.out.println("\nAttempt 5 illegal changes...\n");
		
		if(factory.insert(hilf, bSkin, hSoft3, kit1) == null) {
			System.out.println("Change denied");
		} else {
			System.out.println("Change allowed");
		}
		
		if(factory.insert(gesell, bSkin, kSoft4, kit5) == null) {
			System.out.println("Change denied");
		} else {
			System.out.println("Change allowed");
		}
		
		if(factory.insert(kampf, gSkin, lSoft5, kit10) == null) {
			System.out.println("Change denied");
		} else {
			System.out.println("Change allowed");
		}
		
		if(factory.insert(bau, hSkin, bSoft3, kit10) == null) {
			System.out.println("Change denied");
		} else {
			System.out.println("Change allowed");
		}
		
		if(factory.insert(leib, gSkin, hSoft1, kit5) == null) {
			System.out.println("Change denied");
		} else {
			System.out.println("Change allowed");
		}
		
		
		System.out.println("\nAttemp 5 legal changes...\n");
		
		if(factory.insert(leib, gSkin, lSoft4, kit10) == null) {
			System.out.println("Change failed");
		} else {
			System.out.println("Change successful");
		}
		
		if(factory.insert(kampf, hSkin, kSoft5, kit5) == null) {
			System.out.println("Change failed");
		} else {
			System.out.println("Change successful");
		}
		
		if(factory.insert(bau, bSkin, bSoft3, kit5) == null) {
			System.out.println("Change failed");
		} else {
			System.out.println("Change successful");
		}
		
		if(factory.insert(gesell, bSkin, gSoft1, kit1) == null) {
			System.out.println("Change failed");
		} else {
			System.out.println("Change successful");
		}
		
		if(factory.insert(hilf, bSkin, hSoft1, kit1) == null) {
			System.out.println("Change failed");
		} else {
			System.out.println("Change successful");
		}
		
		ArrayList<String> order3 = new ArrayList<String>();
		
		for(Android an : factory) {
			order3.add(an.toString().substring(an.toString().indexOf("Serial:"), an.toString().indexOf("Software") - 1));
		}
		
		
		System.out.println("\nList several existant and non-existant robots...\n");
		
		System.out.println("R2-D2: " + factory.find("R2-D2"));
		System.out.println("C3P0: " + factory.find("C3P0") + "\n");
		System.out.println("Sonnic: " + factory.find("Sonnic"));
		System.out.println("Cybertron: " + factory.find("Cybertron") + "\n");
		
		
		System.out.println("\nOrder of the Factory at the beginning: ");
		for(String s : order1) {
			System.out.println(s);
		}
		
		System.out.println("\nOrder of the Factory after the changes: ");
		for(String s : order3) {
			System.out.println(s);
		}
		
	}

}
