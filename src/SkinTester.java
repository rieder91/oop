import java.util.ArrayList;


/**
 * This class tests the implementation of Skin
 * 
 * THIS CLASS IS FOR TESTING PURPOSES ONLY AND NOT PART OF THE 
 * ACTUAL SOLUTION FOR THE ASSIGNMENT - THAT IS WHY WE USED GETCLASS!
 * 
 * @author Thomas
 *
 */
public class SkinTester implements Tester {

	/**
	 * default constructor
	 */
	public SkinTester() { }

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
		
		ArrayList<Skin> skins = new ArrayList<Skin>();
		skins.add(new BeruehrungssensitiverSkin());
		skins.add(new GepanzerterSkin());
		skins.add(new HochfesterSkin());
		
		for(Android android : robots) {
			for(Skin s : skins) {
				android.smashSkin();
				android.installSkin(s);
				if(android.getSkin() != null) {
					System.out.print(android.getClass().getName() + " is allowed to install " + s.getClass().getName());
					
				}
				
				android.smashSkin();
				s.einbauen(android);
				if(android.getSkin() != null) {
					System.out.println(" and reverse-calling works");
				}
			}
		}
	}
}
