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
		 */
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
		
		Double[] c1 = {2.3, 4.1, 7.3, 1.4};
		Double[] c2 = {0.3, 5.5};
		Double[] c3 = {1.7, 8.3, 3.0};
		Double[] c4 = {2.3, 6.2, 7.3, 4.4};
		Double[] c5 = {2.3, 4.1, 1.6, 0.4};
		
		CompositeTime comp1 = new CompositeTime(c1);
		CompositeTime comp2 = new CompositeTime(c2);
		CompositeTime comp3 = new CompositeTime(c3);
		CompositeTime comp4 = new CompositeTime(c4);
		CompositeTime comp5 = new CompositeTime(c5);
		
		MeanElapsedTime met1 = new MeanElapsedTime(sd1);
		MeanElapsedTime met2 = new MeanElapsedTime(sd2);
		MeanElapsedTime met3 = new MeanElapsedTime(sd3);
		
		//Set<CompositeTime> sct1 = new Set<CompositeTime>(comp1);
		
		// fill om
		if(!om.insert(met1))
			System.out.println("Fehler 1");
		if(!om.insert(met2))
			System.out.println("Fehler 1");
		if(!om.insert(met3))
			System.out.println("Fehler 1");
		
		
		MapIterator<MeanElapsedTime,CompositeTime> it2 = om.iterator();
		it2.next();
		
		InMapIterator<CompositeTime> inIt2 = it2.iterator();/*
		inIt2.add(comp1);
		inIt2.add(comp2);
		inIt2.next();
		inIt2.add(comp3);
		
		it2.next();
		
		inIt2 = it2.iterator();
		inIt2.add(comp4);
		inIt2.add(comp1);
		inIt2.next();
		inIt2.add(comp3);
		
		it2.next();
		
		inIt2 = it2.iterator();
		inIt2.add(comp4);
		inIt2.add(comp5);
		inIt2.next();
		inIt2.add(comp2);
		*/
		// get min/max values
		it2 = om.iterator();
		
		while(it2.hasNext()) {
			System.out.println("Max: " + it2.next().getMax());
			/*
			inIt2 = it2.iterator();
			
			while(inIt2.hasNext())
				System.out.println("Min: " + inIt2.next().getMin());*/
		}
		
		/*
		 * Test Case 3 of Assignment 5
		 */
		
		/*
		 * Test Case 4 of Assignment 5
		 */
	}
}
