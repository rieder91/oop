/**
 * Test class for Assignment 8
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 8
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		System.out.println("Objektorientierte Programmiertechniken                  \n"
				+ "Datum: 05.12.2012                                      \n"
				+ "Aufgabe 8                                              \n"
				+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		
		
		Liste myTests = new Liste();
		myTests.add(new BauernhofTester());
//		myTests.add(new AnnotationTester());
		
		MyIterator it = myTests.iterator();
		
		while(it.hasNext()) {
			((Tester) it.next()).runTests();
		}
	}
}
