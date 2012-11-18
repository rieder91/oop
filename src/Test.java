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
		
		Iterator<Description> it1 = os.iterator();
		
		while(it1.hasNext()) {
			System.out.println(it1.next().length());
		}
		
		
		/*
		 * Test Case 2 of Assignment 5
		 *//*
		OrderedMap<MeanElapsedTime,CompositeTime> om = new OrderedMap<MeanElapsedTime,CompositeTime>();
		
		Set<Double> sd1 = new Set<Double>();
		sd1.insert(5.4);
		sd1.insert(2.3);
		sd1.insert(4.8);
		
		Set<Double> sd2 = new Set<Double>();
		sd2.insert(6.2);
		sd2.insert(2.7);
		sd2.insert(9.0);
		
		Set<Double> sd3 = new Set<Double>();
		sd3.insert(1.4);
		sd3.insert(4.9);
		
		MeanElapsedTime met1 = new MeanElapsedTime(sd1);
		MeanElapsedTime met2 = new MeanElapsedTime(sd2);
		MeanElapsedTime met3 = new MeanElapsedTime(sd3);
		
		if(!om.insert(met1))
			System.out.println("Fehler 1");
		
		MapIterator<MeanElapsedTime,CompositeTime> it2 = om.iterator();
		it2.next();
		InMapIterator<CompositeTime> inIt2 = it2.iterator();
		
		
		if(!om.insert(met2))
			System.out.println("Fehler 1");
		if(!om.insert(met3))
			System.out.println("Fehler 1");
		*/
		
		/*
		 * Test Case 3 of Assignment 5
		 */
		
		/*
		 * Test Case 4 of Assignment 5
		 */
	}
}
