import java.util.ArrayList;
import java.util.Iterator;

/**
 * Test class for Assignment 5
 * 
 * @author OOP Gruppe 187
 */

public class Test {

	/**
	 * Test class for Assignment 5
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {
		System.out
				.println("Objektorientierte Programmiertechniken                  \n"
						+ "Datum: 14.11.2012                                      \n"
						+ "Aufgabe 5                                              \n"
						+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		
		ArrayList<Tester> testClasses = new ArrayList<Tester>();
		testClasses.add(new SetTester());
		testClasses.add(new OrderedSetTester());
		testClasses.add(new OrderedMapTester());
		testClasses.add(new AssignmentTester());
		
		for(Tester t : testClasses) {
			t.runTests();
		}
		
		Validator.printOverview();
		
		
		/*						verified		test cases
		 * CompositeTime
		 * Description			   x  				-
		 * ElapsedTime
		 * InMapIterator
		 * MapIterator
		 * MeanElapsedTime
		 * OrderedMap
		 * OrderedSet			   x			    x
		 * Set                     x                x
		 * SetIterator             x                x
		 * Shorter                 x				-
		 * 
		 * 
		 * 
		 * 
		 */
	}
}
