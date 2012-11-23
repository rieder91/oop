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

		/*
		 * 
		 * ANMERKUNG: alle Methoden die fuer die Simulation der Multimethoden
		 * verwendet werden haben wir protected gemacht. Ohne Packages entfaltet
		 * dies bei java nicht die gewuenschte Wirkung. Allerdings sollte so
		 * erkennbar sein welche Methoden nicht direkt aufgerufen werden sollten.
		 * 
		 */
		
		ArrayList<Tester> tests = new ArrayList<Tester>();
		tests.add(new SkinTester());
		tests.add(new SoftwareTester());
		tests.add(new SensorTester());
		tests.add(new FactoryTester());
		
		
		for(Tester t : tests) {
			// GET CLASS FOR EASIER DEBUGGING ONLY!
			System.out.println(t.getClass().getName() + ": ");
			t.runTests();
			System.out.println();
		}
		
	}
}
