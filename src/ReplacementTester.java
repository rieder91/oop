import java.util.ArrayList;

/**
 * This class tests witch android could be replaced with another
 * THIS CLASS IS FOR TESTING PURPOSES ONLY AND NOT PART OF THE
 * ACTUAL SOLUTION FOR THE ASSIGNMENT
 * 
 * @author OOP Gruppe 187
 */
public class ReplacementTester implements Tester {

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
		
		for(Android a : robots) {
			Android temp = a;
			for(Android b : robots) {
				if(a.replaceRobotWith(b) != null) {
					System.out.println(temp.getSeriennummer() + " can be replaced with " + b.getSeriennummer());
				}
			}
		}
		
	}

	public String getName() {
		return "Replacement";
	}

}
