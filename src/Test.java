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
		tests.add(new SoftwareTester());
		tests.add(new SensorTester());
		
		
		for(Tester t : tests) {
			t.runTests();
		}
		
		Validator.enableDebug();
		Validator.printOverview();
		
	}
}
