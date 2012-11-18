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
				.println("Objektorientierte Programmiertechniken                 \n"
						+ "Datum: 14.11.2012                                      \n"
						+ "Aufgabe 5                                              \n"
						+ "Gruppe 187: Dominic Riedl, Thomas Rieder, Markus Zisser\n");
		
		/*
		 * Test Case 1 of Assignment 5
		 */
		OrderedSet<Description> os = new OrderedSet<Description>();
		
		if(!os.insert(new Description("Ein Text")))
			System.out.println("Fehler 1");
		if(!os.insert(new Description("Wieder ein Text")))
			System.out.println("Fehler 2");
		if(!os.insert(new Description("Noch ein Text")))
			System.out.println("Fehler 3");
		if(!os.insert(new Description("Text")))
			System.out.println("Fehler 4");
		
		Iterator<Description> it = os.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().length());
		}
	}
}
