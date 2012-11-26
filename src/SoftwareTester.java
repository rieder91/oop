import java.util.ArrayList;

/**
 * This class tests the implementation of Software
 * THIS CLASS IS FOR TESTING PURPOSES ONLY AND NOT PART OF THE
 * ACTUAL SOLUTION FOR THE ASSIGNMENT
 * 
 * @author Thomas
 */
public class SoftwareTester implements Tester {

	/**
	 * default constructor
	 */
	public SoftwareTester() {
	}

	/**
	 * generates all possible robots, softwares and attempts to create new
	 * android with the values; generates output if the android could be created
	 */
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

		for (SecurityLevel l : levels) {
			allSoftware.add(new HilfskraefteSoftware(l));
			allSoftware.add(new GesellschaftlerSoftware(l));
			allSoftware.add(new BauarbeiterSoftware(l));
			allSoftware.add(new ServiceTechnikerSoftware(l));
			allSoftware.add(new TransportarbeiterSoftware(l));
			allSoftware.add(new KaempferSoftware(l));
			allSoftware.add(new LeibwaechterSoftware(l));
			allSoftware.add(new ObjektbewacherSoftware(l));
		}

		for (Android android : robots) {
			for (Software s : allSoftware) {
				android.wipeSoftware();
				android.installSoftware(s);
				if (android.getSoftware() != null) {
					System.out.print(android.getSeriennummer());
					System.out.println(" is allowed to install " + s + " with " + s.getSecurityLevel());
				}

				// save if's
				// android.wipeSoftware();
				// s.installiertIn(android);
				// if (android.getSoftware() != null) {
				// System.out.println(" and reverse-calling works");
				// }
			}
		}

	}

	public String getName() {
		return "Software";
	}

}
