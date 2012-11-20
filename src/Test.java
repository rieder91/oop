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
		
		/*
		 * Test Case 1 of Assignment 5
		 */
		System.out.println("Testfall 1");
		
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
		
		System.out.println("\nLaenge der einzelnen Elemente der befuellten OrderedSet<Description>:");
		
		while(it1.hasNext()) {
			System.out.println(it1.next().length());
		}
		
		it1 = os.iterator();
		
		if(it1.hasNext()) {
			it1.next();
		}
		
		it1.remove();
		
		System.out.println("\nErstes Element wurde geloescht:");
		
		it1 = os.iterator();
		
		while(it1.hasNext()) {
			System.out.println(it1.next().length());
		}
		
		it1 = os.iterator();
		
		for(int i = 0; i < 2; i++) {
			if(it1.hasNext()) {
				it1.next();
			}
		}
		
		it1.remove();
		
		System.out.println("\nZweites Element (der verbliebenen) wurde geloescht:");
		
		it1 = os.iterator();
		
		while(it1.hasNext()) {
			System.out.println(it1.next().length());
		}
		
		/*
		 * Test Case 2 of Assignment 5
		 */
		System.out.println("\n\nTestfall 2");
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
				
		// fill om
		om.insert(met1);
		om.insert(met2);
		om.insert(met3);
		
		
		MapIterator<MeanElapsedTime,CompositeTime> it2 = om.iterator();
		InMapIterator<CompositeTime> inIt2;
		
		if(it2.hasNext()) {
			inIt2 = it2.iterator();
			inIt2.add(comp1);
			inIt2.add(comp2);
			inIt2.next();
			inIt2.add(comp3);
		}
		
		if(it2.hasNext()) {
			it2.next();
			inIt2 = it2.iterator();
			inIt2.add(comp4);
			inIt2.add(comp1);
			inIt2.next();
			inIt2.add(comp3);
		}
		
		if(it2.hasNext()) {
			it2.next();
			inIt2 = it2.iterator();
			inIt2.add(comp4);
			inIt2.add(comp5);
			inIt2.next();
			inIt2.add(comp2);
		}
		
		System.out.println("\nMaxima der MET und Minima der CT der befuellten OrderedMap<MeanElapsedTime,CompositeTime>:");

		// get min/max values
		it2 = om.iterator();
		
		while(it2.hasNext()) {
			inIt2 = it2.iterator();
			
			System.out.println("Max: " + it2.next().getMax());
			
			while(inIt2.hasNext())
				System.out.println("Min: " + inIt2.next().getMin());
		}
		
		it2 = om.iterator();
		it2.next();
		it2.remove();
		
		System.out.println("\nKompletter erster Eintrag wurde geloescht:");
		
		it2 = om.iterator();
		
		while(it2.hasNext()) {
			inIt2 = it2.iterator();
			
			System.out.println("Max: " + it2.next().getMax());
			
			while(inIt2.hasNext())
				System.out.println("Min: " + inIt2.next().getMin());
		}
		
		it2 = om.iterator();
		it2.next();
		inIt2 = it2.iterator();
		inIt2.next();
		inIt2.remove();
		
		System.out.println("\nErstes Element des zweiten Eintrags wurde geloescht:");
		
		it2 = om.iterator();
		
		while(it2.hasNext()) {
			inIt2 = it2.iterator();
			
			System.out.println("Max: " + it2.next().getMax());
			
			while(inIt2.hasNext())
				System.out.println("Min: " + inIt2.next().getMin());
		}
		
		
		
		/*
		 * Test Case 3 of Assignment 5
		 */
		System.out.println("\n\nTestfall 3");
		System.out.println("OrderedMap<T,U> wurde als eigene Klasse ohne Bezug auf Set<T> bzw. OrderedSet<T> erstellt.\n" +
							"Hier besteht keine Untertypbeziehung zwischen diesen Collections.");
		
		/*
		 * Test Case 4 of Assignment 5
		 */
		System.out.println("\n\nTestfall 4");
		OrderedSet<ElapsedTime> osEt = new OrderedSet<ElapsedTime>();
		
		// fill osEt with all MeanElapsedTime- and CompositeTime-instances of om
		it2 = om.iterator();
		
		while(it2.hasNext()) {
			inIt2 = it2.iterator();
			
			osEt.insert(it2.next());
			
			while(inIt2.hasNext())
				osEt.insert(inIt2.next());
		}
		
		// print count() of all values
		System.out.println("\nBefuelltes OrderedSet<ElapsedTime> mit verbliebenen Elementen aus Testfall 2\n" +
							"Anzahl der Einzelzeiten pro Eintrag:");
		Iterator<ElapsedTime> osEtIt = osEt.iterator();
		int i = 1;
		
		while(osEtIt.hasNext()) {
			System.out.println("Value " + i +": " + osEtIt.next().count());
			i++;
		}
				
		
		/*
		 * Debug-Removal-test of Set
		 *//*
		Set<String> iteratorSet = new Set<String>();
		iteratorSet.insert("Thomas");
		iteratorSet.insert("Markus");
//		iteratorSet.insert("Dominic");
//		iteratorSet.insert("Patrick");
//		iteratorSet.insert("Manuel");

		Iterator<String> setIterator = iteratorSet.iterator();
		setIterator.next();
//		setIterator.next();
//		setIterator.next();
//		setIterator.next();
//		setIterator.next();
		setIterator.remove();
		
//		System.out.println(iteratorSet);
		
		*/
	}
}
