import java.util.ArrayList;

/**
 * Test class for Assignment 7
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 7
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		System.out.println("Objektorientierte Programmiertechniken                  \n"
				+ "Datum: 28.11.2012                                      \n"
				+ "Aufgabe 7                                              \n"
				+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");

		ArrayList<Tester> allTests = new ArrayList<Tester>();
		allTests.add(new Test1());
		allTests.add(new Test2());
		allTests.add(new Test3());
		allTests.add(new Test4());
		allTests.add(new Test5());

		for (Tester t : allTests) {
			t.runTests();
			System.out.println();
		}

	}
}
