import java.util.ArrayList;


/**
 * This class tests the implementation of SensorenAktorenKit
 * 
 * THIS CLASS IS FOR TESTING PURPOSES ONLY AND NOT PART OF THE 
 * ACTUAL SOLUTION FOR THE ASSIGNMENT - THAT IS WHY WE USED GETCLASS!
 * 
 * @author Thomas
 *
 */
public class SensorTester implements Tester {

	/**
	 * default constructor
	 */
	public SensorTester() { }

	public void runTests() {
		ArrayList<Android> robots = new ArrayList<Android>();
		robots.add(new Hilfskraft("Hilfsroboter"));
		robots.add(new Gesellschaftler("Gesellschaftsroboter"));
		robots.add(new Bauarbeiter("Bauroboter"));
		robots.add(new ServiceTechniker("Serviceroboter"));
		robots.add(new Transportarbeiter("Transportroboter"));
		robots.add(new Kaempfer("Kampfroboter"));
		robots.add(new Leibwaechter("Leibwaechteroboter"));
		robots.add(new Objektbewacher("Objektroboter"));
		
		
		ArrayList<SecurityLevel> levels = new ArrayList<SecurityLevel>();
		levels.add(new SecurityLevel1());
		levels.add(new SecurityLevel2());
		levels.add(new SecurityLevel3());
		levels.add(new SecurityLevel4());
		levels.add(new SecurityLevel5());
		
		ArrayList<Software> allSoftware = new ArrayList<Software>();
		
		for(SecurityLevel l : levels) {
			allSoftware.add(new HilfskraefteSoftware(l));
			allSoftware.add(new GesellschaftlerSoftware(l));
			allSoftware.add(new BauarbeiterSoftware(l));
			allSoftware.add(new ServiceTechnikerSoftware(l));
			allSoftware.add(new TransportarbeiterSoftware(l));
			allSoftware.add(new KaempferSoftware(l));
			allSoftware.add(new LeibwaechterSoftware(l));
			allSoftware.add(new ObjektbewacherSoftware(l));
		}
		
		ArrayList<SensorenAktorenKit> sensoren = new ArrayList<SensorenAktorenKit>();
		sensoren.add(new SensorenAktorenKitEinKW());
		sensoren.add(new SensorenAktorenKitFuenfKW());
		sensoren.add(new SensorenAktorenKitZehnKW());
		sensoren.add(new SensorenAktorenKitInf());

		
		
		for(Android android : robots) {
			for(Software s : allSoftware) {
				android.wipeSoftware();
				android.softwareInstallieren(s);
				if(android.getSoftware() != null) {
					
					for(SensorenAktorenKit sense : sensoren) {
						android.dismantleKit();
						android.kitInstallieren(sense);
						
						if(android.getKit() != null) {
							System.out.print(android.getClass().getName() + " is allowed to install " + sense.getClass().getName() 
											 + " with software " + s.getClass().getName() + " and level " + s.getSecurityLevel().getClass().getName());
						}
						
						android.dismantleKit();
						sense.integrieren(android);
						
						if(android.getKit() != null) {
							System.out.println(" and reverse-calling works");
						}
					}
				}
				
			}
		}
	}
}
