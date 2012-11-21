import java.util.ArrayList;
import java.util.Iterator;

/**
 * this class contains all tests cases that are required according to the 
 * assignment itself
 * 
 * @author OOP Gruppe 187
 *
 */
public class AssignmentTester implements Tester {

	public void runTests() {
		/*
		 * Test Case 1 of Assignment 5
		 */

		Description desc1 = new Description("Ein Text");
		Description desc2 = new Description("Wieder ein Text");
		Description desc3 = new Description("Noch ein Text");
		Description desc4 = new Description("Text");
		Description desc5 = new Description("Thomas");

		OrderedSet<Description> os = new OrderedSet<Description>();
		Iterator<Description> it1;
		Integer count = 0;

		os.insert(desc1);
		os.insert(desc2);
		os.insert(desc3);
		os.insert(desc4);

		it1 = os.iterator();

		while(it1.hasNext()) {
			it1.next();
			count++;
		}

		Validator.report(count == 4, "AssignmentTester: add four elements to an orderedset and verify their existance");

		os.insert(desc5);

		count = 0;
		it1 = os.iterator();
		while(it1.hasNext()) {
			count++;
			it1.next();
			if(count == 0 || count == 1) {
				it1.remove();
			}
		}
		Validator.report(count - 2 == 3, "AssignmentTester: add one additional element and remove two");

		it1 = os.iterator();
		
		while(it1.hasNext()) {
			it1.next();
			it1.remove();
		}

		count = 0;
		it1 = os.iterator();
		while(it1.hasNext()) {
			it1.next();
			count++;
		}

		Validator.report(count == 0, "AssignmentTester: remove ALL the elements");


		/*****************/

		/*
		 * Test Case 2 of Assignment 5
		 */

		OrderedMap<MeanElapsedTime, CompositeTime> om = new OrderedMap<MeanElapsedTime, CompositeTime>();

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

		ArrayList<Double> maxValues = new ArrayList<Double>();
		ArrayList<Double> minValues = new ArrayList<Double>();
		
		maxValues.add(4.9);
		maxValues.add(5.4);
		maxValues.add(9.0);
		maxValues.add(4.9);
		
		minValues.add(1.7);
		minValues.add(1.7);
		minValues.add(0.3);
		minValues.add(1.7);
		minValues.add(1.7);
		minValues.add(0.3);
		minValues.add(0.3);
		minValues.add(0.4);
		
		Iterator<Double> maximumIt = maxValues.iterator();
		Iterator<Double> minimumIt = minValues.iterator();
		
		boolean result = true;
		
		// get min/max values
		it2 = om.iterator();

		while(it2.hasNext()) {
			inIt2 = it2.iterator();
			result = result && (it2.next().getMax().equals(maximumIt.next()));
			
			while(inIt2.hasNext()) {
				result = result && (minimumIt.next().equals(inIt2.next().getMin()));
			}
		}
		
		Validator.report(result, "AssignmentTester: validating the minimum and maximum values from an OrderedMap<MET, CT>");
		
		it2 = om.iterator();
		it2.next();
		it2.remove();
		
		
		maxValues = new ArrayList<Double>();
		minValues = new ArrayList<Double>();
		
		maxValues.add(5.4);
		maxValues.add(9.0);
		
		minValues.add(1.7);
		minValues.add(1.7);
		minValues.add(0.3);
		minValues.add(1.7);
		minValues.add(1.7);
		minValues.add(0.3);
		
		maximumIt = maxValues.iterator();
		minimumIt = minValues.iterator();

		System.out.println("\nKompletter erster Eintrag wurde geloescht:");

		it2 = om.iterator();
		
		result = true;

		while(it2.hasNext()) {
			inIt2 = it2.iterator();

			System.out.println("Max: " + it2.next().getMax());

			while(inIt2.hasNext()) {
				System.out.println("Min: " + inIt2.next().getMin());
			}
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
	}
}
