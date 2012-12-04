import java.util.ArrayList;

/**
 * Test class for Assignment 7
 * 
 * Die Klasse Test soll (nicht interaktiv) Testl�ufe des Autodroms durchf�hren und die Ergebnisse in allgemein
 * verst�ndlicher Form in der Standardausgabe darstellen. 
 * Bitte achten Sie darauf, dass die Testl�ufe nach kurzer Zeit terminieren (maximal 10 Sekunden f�r alle zusammen). 
 * 
 * F�hren Sie mindestens drei Testl�ufe mit unterschiedlichen Einstellungen durch:
 * Jeder Testlauf soll eine unterschiedliche Menge an
 * Autos mit unterschiedlicher Beweglichkeit und Bewegungsstrategie
 * vor dem Start auf unterschiedliche Felder der Fahrbahn positionieren.
 * 
 * Auch innerhalb eines Testlaufs sollen Autos unterschiedliche Geschwindigkeiten haben.
 * 
 * Stellen Sie die Parameter so ein, dass irgendwann Autos auch zusammensto�en.
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
